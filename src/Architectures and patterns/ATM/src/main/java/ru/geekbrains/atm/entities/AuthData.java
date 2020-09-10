package ru.geekbrains.atm.entities;

public class AuthData {

    private int pinCodeHash;
    private String cardNumber;
    private int tokenHash;

    private boolean hasToken  = false;

    public boolean hasToken() {
        return hasToken;
    }

    public int getPinCodeHash() {
        return pinCodeHash;
    }

    public void setPinCodeHash(int pinCodeHash) {
        this.pinCodeHash = pinCodeHash;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getTokenHash() {
        return tokenHash;
    }

    public void setTokenHash(int tokenHash) {
        this.tokenHash = tokenHash;
        hasToken = true;
    }
}
