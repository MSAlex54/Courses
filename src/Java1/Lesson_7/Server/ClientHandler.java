package Java1.Lesson_7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private MainServer server;
    private String nick;

    public ClientHandler(Socket socket, MainServer server) {
        try {
            this.socket = socket;
            this.server = server;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // цикл для авторизации
                        while (true) {
                            String str = in.readUTF();
                            // если сообщение начинается с /auth
                            if(str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                // Вытаскиваем данные из БД
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                if (newNick != null) {
                                    // отправляем сообщение об успешной авторизации
                                    if (!server.isAlreadyOnline(newNick)) {
                                        sendMsg("/authok");
                                        nick = newNick;
                                        server.subscribe(ClientHandler.this);
                                        break;
                                    } else {
                                        sendMsg("Пользователь уже авторизован!");
                                    }

                                } else {
                                    sendMsg("Неверный логин/пароль!");
                                }
                            }
                        }

                        // блок для отправки сообщений
                        while (true) {
                            String str = in.readUTF();
                            if(str.equals("/end")) {
                                out.writeUTF("/serverClosed");
                                break;
                            }
                            if(str.startsWith("/w ")){
                                String[] tokens = str.split(" ");
                                String toHwo = tokens[1];

                                server.privateMsg(ClientHandler.this,toHwo,nick + ": " + str.replace("/w ",""));

                            } else {
                                server.broadcastMsg(nick + ": " + str);
                            }
                        }
                    }  catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHandler.this);
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getNick() {
        return nick;
    }
}
