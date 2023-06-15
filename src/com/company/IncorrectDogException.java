package com.company;

public class IncorrectDogException extends Exception {
    private String name;

    public IncorrectDogException(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IncorrectDogException{" +
                "name='" + name + '\'' +
                '}';
    }
}
