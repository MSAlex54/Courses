package ru.geekbrains.atm.services;

public class BankService {
    public boolean isClient(String cardNumber){
        return cardNumber=="2";
    }

    public boolean isPartner(String cardNumber){
        return cardNumber=="3";
    }

    public boolean isCorrectPin(String cardNumber, int pinCodeHash){
        return pinCodeHash==4;
    }
}
