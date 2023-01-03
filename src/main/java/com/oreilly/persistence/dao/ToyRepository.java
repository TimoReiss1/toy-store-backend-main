package com.oreilly.persistence.dao;

import com.oreilly.persistence.entities.AbstractToy;
import com.oreilly.persistence.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToyRepository extends JpaRepository<AbstractToy, Integer> {
    List<AbstractToy> getAbstractToyByType(String type);
    List<AbstractToy> getAbstractToyByName(String name);
}
