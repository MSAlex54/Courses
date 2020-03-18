package Java1.Lesson_5;

public class ThreadsPractice {

    static final int size = 2000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        method1();
        method2(3);
    }

    public static void method1(){
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr [i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);

    }

    public static void method2(int numOfThreads){
        float[] arr = new float[size];
        int currentStart = 0;
        Thread [] thread = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {//заполняем единицами
            int startPos = size/numOfThreads*i;
            int len =0;
            if (i+1 == numOfThreads) {
                len = size-startPos;
            } else {
                len = size/numOfThreads;
            }

            int finalLen = len;
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    float[] arrTmp = new float[finalLen];
                    System.arraycopy(arr, startPos, arrTmp, 0, finalLen);
                    for (int j = 0; j < finalLen; j++) {
                        arrTmp[j] = 1;
                    }
                    System.arraycopy(arrTmp, 0, arr, startPos, finalLen);
                }});
            thread[i].start();
        }
        try {
            for (int i = 0; i < numOfThreads; i++) {
                thread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long a = System.currentTimeMillis(); //засекаем время
        for (int i = 0; i < numOfThreads; i++) {//считаем
            int startPos = size/numOfThreads*i;
            int len =0;
            if (i+1 == numOfThreads) {
                len = size-startPos;
            } else {
                len = size/numOfThreads;
            }

            int finalLen = len;
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    float[] arrTmp = new float[finalLen];
                    System.arraycopy(arr, startPos, arrTmp, 0, finalLen);
                    for (int j = 0; j < finalLen; j++) {
                        arrTmp[j] = (float)(arrTmp[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));;
                    }
                    System.arraycopy(arrTmp, 0, arr, startPos, finalLen);
                }});
            thread[i].start();
        }

        try {
            for (int i = 0; i < numOfThreads; i++) {
                thread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - a);
    }
}