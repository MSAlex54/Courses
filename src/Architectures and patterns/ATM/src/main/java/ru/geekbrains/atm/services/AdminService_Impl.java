package ru.geekbrains.atm.services;

import ru.geekbrains.atm.entities.AuthData;

public class AdminService_Impl implements AdminService_I {

    @Override
    public String authorize(AuthData aData){
        return String.valueOf(aData.hasToken());
    }
}
