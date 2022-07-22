package com.intellias.vitkovska;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super("You don't have enough money to buy this product");
    }
}
