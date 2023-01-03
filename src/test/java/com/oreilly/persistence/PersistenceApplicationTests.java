package com.oreilly.persistence;

import com.oreilly.persistence.Factory.ToyFactory;
import com.oreilly.persistence.Helper.ToyInformation;
import com.oreilly.persistence.dao.ToyRepository;
import com.oreilly.persistence.entities.AbstractToy;
import com.oreilly.persistence.entities.Car;
import com.oreilly.persistence.entities.ToySize;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersistenceApplicationTests {

    // Create mock toyRepository
    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private PersistenceApplication persistenceApplication;

    @Test
    public void contextLoads() {
    }

    @Test
    public void addToy() {
        ToyInformation request = new ToyInformation();
        ToyFactory toyFactory = new ToyFactory();
        request.setName("Car");
        request.setSize(ToySize.S);
        request.setSpeed(10);
        request.setDistance(100);
        request.setAmountOfWheels(4);
        request.setType("car");

        Car toy = (Car) toyFactory.createToy(request);
        toyRepository.save(toy);
        assertNotNull(toyRepository.getAbstractToyByName("Car"));

        assertNotNull(toy);
        assertEquals(toy.getName(), "Car");
        assertEquals(toy.getSize(), ToySize.S);
        assertEquals(toy.getSpeed(), 10);
        assertEquals(toy.getDistanceTraveled(), 100);
        assertEquals(toy.getAmountOfWheels(), 4);
        assertEquals(toy.getType(), "car");
    }

    @Test
    public void testUpdateToyName() {

        Mockito.doNothing().when(toyRepository).deleteById(Mockito.anyInt());

        // Stub the findById method of toyRepository to return a non-null value
        Mockito.when(toyRepository.findById(Mockito.anyInt())).thenReturn((Optional<AbstractToy>) new Object());

        // Create expected output
        ResponseEntity<String> expectedOutput = ResponseEntity.ok("Worked");

        // Invoke method being tested
        ResponseEntity<String> result = persistenceApplication.deleteToy(1);

        // Compare result with expected output
        assertEquals(expectedOutput, result);

        // Verify that toyRepository.findById was called
        Mockito.verify(toyRepository).findById(Mockito.anyInt());

        // Verify that toyRepository.deleteById was called
        Mockito.verify(toyRepository).deleteById(Mockito.anyInt());
    }

}
