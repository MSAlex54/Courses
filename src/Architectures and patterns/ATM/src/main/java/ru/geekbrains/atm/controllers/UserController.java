package ru.geekbrains.atm.controllers;

public abstract class UserController {

    public void welcome(){
        System.out.println("Welcome User!");
    }
    public void logOut(){
        System.out.println("GoodBye User!");
    }

}
