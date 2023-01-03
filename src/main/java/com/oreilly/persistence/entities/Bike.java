package com.oreilly.persistence.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("bike")
public class Bike extends AbstractToy implements Drivable{

    private int speed;
    private int distanceTraveled;
    private int amountOfWheels;

    public Bike(){
        super();
    }

    public Bike(String name, ToySize size, int amountOfWheels,String type) {
        super(name, size, type);
        this.speed = 0;
        this.distanceTraveled = 0;
        this.amountOfWheels = amountOfWheels;
    }


    @Override
    public String play() {
        this.distanceTraveled += Math.abs(speed);
        return this.getName() + " traveled " + distanceTraveled + " miles on route 66!";
    }

    @Override
    public int drive() {
        this.distanceTraveled += speed;
        return distanceTraveled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public int getAmountOfWheels() {
        return amountOfWheels;
    }

    public void setAmountOfWheels(int amountOfWheels) {
        this.amountOfWheels = amountOfWheels;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", speed=" + speed +
                ", distanceTraveled=" + distanceTraveled +
                ", amountOfWheels=" + amountOfWheels +
                '}';
    }
}
