package com.player;

public class Player extends Person {
    private String role;
    private int number;

    public Player(String role, int number, String name, String surname, String address, String fiscalCode) {
        super(name, surname, address, fiscalCode); /* prendo i dati dal costruttre Person */
        this.role = role;
        this.number = number;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "\nName: " + getName() +
                "\nSurname: " + getSurname() +
                "\nAddress: " + getAddress() +
                "\nFiscal Code: " + getFiscalCode() +
                "\nRole: " + role +
                "\nNumber T-shirt: " + number;
    }
}