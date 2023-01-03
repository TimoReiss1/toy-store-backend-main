package com.oreilly.persistence.entities;

public enum ToySize {
    XS(1),
    S(2),
    M(4),
    L(8),
    XL(16);

    public final int value;

    private ToySize(int value) {
        this.value = value;
    }
}

