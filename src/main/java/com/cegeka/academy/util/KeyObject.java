package com.cegeka.academy.util;

import java.util.Objects;

public class KeyObject {
    String name;
    int number;

    public KeyObject(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyObject)) return false;
        KeyObject keyObject = (KeyObject) o;
        return getNumber() == keyObject.getNumber() &&
                getName().equals(keyObject.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNumber());
    }
}
