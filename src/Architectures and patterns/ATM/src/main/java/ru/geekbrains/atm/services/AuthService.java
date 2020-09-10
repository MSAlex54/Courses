package ru.geekbrains.atm.services;

import ru.geekbrains.atm.entities.AuthData;

public interface AuthService {
    String authorize(AuthData aData);
}
