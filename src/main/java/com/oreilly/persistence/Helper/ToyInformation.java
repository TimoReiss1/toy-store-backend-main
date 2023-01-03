package com.oreilly.persistence.Helper;

import com.oreilly.persistence.entities.ToySize;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Date;
import java.util.UUID;

@Component
public class ToyInformation {

    //use this in abstract factory
    protected String type;
    protected UUID id;
    protected String name;
    public Color color;
    protected ToySize size;
    protected double purchasePrice;
    protected double sellPrice;
    protected Date arrivalDate;
    protected int amountOfWheels;
    protected int speed;
    protected int distance;

    public ToyInformation() {
    }

    public String returnToyInformation(){
        return null;
    }

    public ToyInformation setType(String type){
        this.type = type;
        return this;
    }

    public String getType(){
        return this.type;
    }

    public UUID getId() {
        return id;
    }

    public ToyInformation setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ToyInformation setName(String name) {
        this.name = name;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public ToyInformation setColor(Color color) {
        this.color = color;
        return this;
    }

    public ToySize getSize() {
        return size;
    }

    public ToyInformation setSize(ToySize size) {
        this.size = size;
        return this;
    }


    public double getPurchasePrice() {
        return purchasePrice;
    }

    public ToyInformation setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public ToyInformation setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
        return this;
    }

    public int getAmountOfWheels() {
        return amountOfWheels;
    }

    public ToyInformation setAmountOfWheels(int amountOfWheels) {
        this.amountOfWheels = amountOfWheels;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public ToyInformation setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    public ToyInformation setDistance(int distance) {
        this.distance = distance;
        return this;
    }
}
