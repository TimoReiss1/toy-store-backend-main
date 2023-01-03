package com.oreilly.persistence.Factory;

import com.oreilly.persistence.Helper.ToyInformation;
import com.oreilly.persistence.entities.AbstractToy;
import com.oreilly.persistence.entities.Bike;
import com.oreilly.persistence.entities.Car;
import com.oreilly.persistence.entities.ToySize;
import org.springframework.stereotype.Component;

@Component
public class ToyFactory implements FactoryBean<AbstractToy>{

    private Integer id;
    private int speed;
    private int distanceTraveled;
    private int amountOfWheels;
    private String toyType;


    public AbstractToy createToy(ToyInformation toyInformation) {
        switch (toyInformation.getType()) {
            case "car":
                Car car = new Car(toyInformation.getName(), toyInformation.getSize(),toyInformation.getAmountOfWheels(), toyInformation.getType());
                car.setSpeed(toyInformation.getSpeed());
                car.setDistanceTraveled(toyInformation.getDistance());
                car.setUuid(toyInformation.getId());
                return car;

            case "bike":
                Bike bike = new Bike(toyInformation.getName(), toyInformation.getSize(), toyInformation.getAmountOfWheels(), toyInformation.getType());
                bike.setSpeed(toyInformation.getSpeed());
                bike.setDistanceTraveled(toyInformation.getDistance());
                bike.setUuid(toyInformation.getId());
                return bike;
            /*
            case "truck" ->
                    new Truck(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate(), toyInformation.getEngine(), toyInformation.getAmountOfWheels());
            case "dozer" ->
                    new Dozer(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate(), toyInformation.getEngine());
            case "helicopter" ->
                    new Helicopter(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate(), toyInformation.getEngine());
            case "hovercraft" ->
                    new Hovercraft(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate(), toyInformation.getEngine());
            case "jet" ->
                    new Jet(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate(), toyInformation.getEngine());
            case "motorboat" ->
                    new Motorboat(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate(), toyInformation.getEngine());
            case "motorcycle" ->
                    new Motorcycle(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate(), toyInformation.getEngine(), toyInformation.getAmountOfWheels());
            case "sailboat" ->
                    new Sailboat(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate());
            case "sailplane" ->
                    new Sailplane(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate(), toyInformation.getEngine());
            case "submarine" ->
                    new Submarine(toyInformation.getName(), toyInformation.getColor(), toyInformation.getSize(), toyInformation.getProducer(), toyInformation.getPurchasePrice(), toyInformation
                            .getSellPrice(), toyInformation.getArrivalDate(), toyInformation.getEngine());

             */
            default:
                return null;
        }
    }

    @Override
    public AbstractToy getObject() throws Exception {
        return new Car("Cars", ToySize.L,4,"car");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
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

    public String getToyType() {
        return toyType;
    }

    public void setToyType(String toyType) {
        this.toyType = toyType;
    }
}