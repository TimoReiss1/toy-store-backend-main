package com.oreilly.persistence;

import com.oreilly.persistence.Factory.ToyFactory;
import com.oreilly.persistence.Helper.ToyInformation;
import com.oreilly.persistence.dao.OfficerRepository;
import com.oreilly.persistence.dao.ToyRepository;
import com.oreilly.persistence.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@CrossOrigin
@RestController
@RequestMapping("/main")
public class PersistenceApplication {

    private final OfficerRepository officerRepository;
    private final ToyRepository toyRepository;
    ToyFactory toyFactory;

    public PersistenceApplication(ToyRepository toyRepository, ToyFactory toyFactory){
        this.officerRepository = null;
        this.toyFactory = toyFactory;
        this.toyRepository = toyRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(PersistenceApplication.class, args);
    }

    @GetMapping("/officers")
    public ResponseEntity<List<Officer>> getOfficers(){
        return ResponseEntity.ok(officerRepository.findAll());
    }

    @GetMapping("/toys")
    public List<AbstractToy> getToys(){
        return toyRepository.findAll();
    }
    /**
     * @deprecated Method returns all listed Cars only. Method was updated to work with
     * any type.
     * Replace with {@link #getToyByType ()}
     */
    @Deprecated
    @GetMapping("/toys/cars")
    public List<AbstractToy> getCars(){
        return toyRepository.getAbstractToyByType("car");
    }

    record NewOfficerRequest(Rank rank,String firstName,String lastName){
    }

    record NewToyRequest(String name, ToySize size, int speed, int distanceTraveled, int amountOfWheels, String type) {

    }

    @PostMapping("/toys/add")
    public ResponseEntity<AbstractToy> addToy(@RequestBody NewToyRequest request) {
        try {
            ToyInformation toyInformation = new ToyInformation();
            toyInformation.setId(UUID.randomUUID());
            toyInformation.setName(request.name());
            toyInformation.setSize(request.size());
            toyInformation.setSpeed(request.speed());
            toyInformation.setDistance(request.distanceTraveled());
            toyInformation.setAmountOfWheels(request.amountOfWheels());
            toyInformation.setType(request.type());
            toyRepository.save(toyFactory.createToy(toyInformation));
            return ResponseEntity.ok(toyFactory.createToy(toyInformation));
        }catch(IllegalArgumentException e){
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/toys/delete/{toyId}")
    public ResponseEntity<String> deleteToy(@PathVariable("toyId") Integer id){
        if(toyRepository.findById(id) != null){
            toyRepository.deleteById(id);
            return ResponseEntity.ok("Worked");
        }
        return ResponseEntity.status(404).body("Error:");
    }

    @GetMapping("/toys/category/{toyType}")
    public ResponseEntity<List<AbstractToy>> getToyByType(@PathVariable("toyType") String type){
        return ResponseEntity.ok(toyRepository.getAbstractToyByType(type));
    }

    @PutMapping("/toys/update/{toyId}")
    public ResponseEntity<String> updateToyName(@PathVariable("toyId") Integer id, @RequestParam(value = "name", required = false) String name){
        Optional<AbstractToy> optionalToy = toyRepository.findById(id);
        if(optionalToy.isPresent()){
            AbstractToy abstractToy = optionalToy.get();
            abstractToy.setName(name);
            toyRepository.save(abstractToy);
            return ResponseEntity.ok("Worked");
        }else{
            return ResponseEntity.status(404).body("Error: Invalid Toy ID");
        }
    }

/*
    @PostMapping
    public ResponseEntity<String> addOfficer(@RequestBody NewOfficerRequest request){
            Officer officer = new Officer();
            officer.setRank(request.rank());
            officer.setFirstName(request.firstName());
            officer.setLastName(request.lastName());
            officerRepository.save(officer);
            return ResponseEntity.ok("Worked");

    }
    @PutMapping("update/{officerId}")
    public ResponseEntity<String> updateOfficerName(@PathVariable("officerId") Integer id, @RequestParam(value = "name", required = false) String name) {
        Optional<Officer> officerOptional = officerRepository.findById(id);
        if (officerOptional.isPresent()) {
            Officer officer = officerOptional.get();
            officer.setFirstName(name);
            officerRepository.save(officer);
            return ResponseEntity.ok("Worked");
        } else {
            return ResponseEntity.status(404).body("Error: Invalid Officer ID");
        }
    }

 */

/*
    @DeleteMapping("delete/{officerId}")
    public ResponseEntity<String> deleteOfficer(@PathVariable("officerId") Integer id){
        if(officerRepository.findById(id) != null){
            officerRepository.deleteById(id);
            return ResponseEntity.ok("Worked");
        }
        return ResponseEntity.status(404).body("Error:");
    }

 */


}
