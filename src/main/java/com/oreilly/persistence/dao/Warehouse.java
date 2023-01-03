package com.oreilly.persistence.dao;

import com.oreilly.persistence.entities.AbstractToy;

import java.util.ArrayList;

public class Warehouse {
    private ArrayList<Shelf> inventory;

    public Warehouse(int numberOfRows, int numberOfColumns, int shelfSize) {
        this.inventory = new ArrayList<>(numberOfColumns * numberOfRows);
        for (int index = 0; index < numberOfColumns * numberOfRows; index++) {
            inventory.add(new Shelf(shelfSize));
        }
    }

    public boolean store(AbstractToy toy) {
        for (Shelf shelf : inventory) {
            if (shelf.add(toy) == true) {
                return true;
            }
        }
        return false;
    }

    public AbstractToy retrieve(String toyName) {
        for (Shelf shelf : inventory){
            AbstractToy toy = shelf.remove(toyName);
            if (toy != null){
                return toy;
            }
        }
        throw new RuntimeException("The is no toy with this name on stock");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Shelf shelf : inventory) {
            sb.append(shelf.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}