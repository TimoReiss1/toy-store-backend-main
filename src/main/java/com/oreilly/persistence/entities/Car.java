package com.oreilly.persistence.entities;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue("car")
public class Car extends AbstractToy implements Drivable {

    private int speed;
    private int distanceTraveled;
    private int amountOfWheels;

    public Car(String name, ToySize size, int amountOfWheels, String type) {
        super(name, size, type);
        this.speed = 0;
        this.distanceTraveled = 0;
        this.amountOfWheels = amountOfWheels;

    }

    public Car() {
        super();
    }

    @Override
    public String play() {
        this.distanceTraveled += Math.abs(speed);
        return this.getName() + " traveled " + distanceTraveled + " miles on route 66!";
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setDistanceTraveled(int distance) {
        this.distanceTraveled = distance;
    }
    public int getDistanceTraveled() {
        return distanceTraveled;
    }
    public int getAmountOfWheels(){
        return this.amountOfWheels;
    }
    public void setAmountOfWheels(int amountOfWheels){
        this.amountOfWheels = amountOfWheels;
    }

    @Override
    public int drive() {
        this.distanceTraveled += speed;
        return distanceTraveled;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", speed=" + speed +
                ", distanceTraveled=" + distanceTraveled +
                ", amountOfWheels=" + amountOfWheels +
                '}';
    }
}
