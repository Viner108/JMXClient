package org.example.client;

import java.io.Serializable;

public class Person implements Serializable {
    private String name = "Max";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
