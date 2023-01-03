package com.oreilly.persistence.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("starship")
public class Starship extends AbstractToy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int speed;
    private int distanceTraveled;

    public Starship(String name, ToySize size, String type) {
        super(name, size,type);
        speed = 0;
        distanceTraveled = 0;
    }

    public Starship() {

    }

    @Override
    public String play() {
        this.distanceTraveled += Math.abs(speed);
        return this.getName() + " traveled " + distanceTraveled + " light years through the galaxy!";
    }

    public void land() {
        this.setSpeed(0);
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
    public void setDistanceTraveled(int distanceTraveled){
        this.distanceTraveled = distanceTraveled;
    }


}
