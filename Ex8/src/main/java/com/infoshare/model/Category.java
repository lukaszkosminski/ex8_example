package com.infoshare.model;

public enum Category {
    EVENT("Event"),
    HOME("House"),
    SHOPPING("Shopping"),
    WORK("Work");

    String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
