package com.oreilly.persistence.dao;

import com.oreilly.persistence.entities.AbstractToy;

import java.util.Vector;

public class Shelf {
    private Vector<AbstractToy> content;
    private int capacity;

    public Shelf(int capacity) {
        this.content = new Vector<>();
        this.capacity = capacity;
    }

    public boolean add(AbstractToy toy){
        if(toy.getSize().value <= capacity){
            capacity -= toy.getSize().value;
            content.add(toy);
            return true;
        }
        return false;
    }

    public AbstractToy remove(String toyName){
        for (AbstractToy toy: content) {
            if(toy.getName().equals(toyName)){
                capacity += toy.getSize().value;
                content.remove(toy);
                return toy;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (AbstractToy toy: content) {
            sb.append(toy.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}