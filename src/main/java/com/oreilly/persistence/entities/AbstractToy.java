package com.oreilly.persistence.entities;

import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "test", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractToy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private UUID uuid;
    private String name;
    private String type;

    @Enumerated(EnumType.STRING)
    private ToySize size;

    public AbstractToy(String name, ToySize size, String type) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public AbstractToy() {

    }

    public abstract String play();

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid){
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public ToySize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "uuid=" + uuid.toString() +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public ResponseEntity<String> setName(String name) {
        this.name = name;
        return ResponseEntity.ok().body("Worked");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(ToySize size) {
        this.size = size;
    }
}
