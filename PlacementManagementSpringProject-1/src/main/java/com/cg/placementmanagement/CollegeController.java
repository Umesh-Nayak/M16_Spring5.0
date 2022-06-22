package com.cg.placementmanagement;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {
 
    @Autowired
    private CollegeService service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/college")
    public List<College> list() {
        return service.listAll();
    }
    @GetMapping("/college/{id}")
    public ResponseEntity<College> get(@PathVariable Integer id) {
        try {
        	College College = service.get(id);
            return new ResponseEntity<College>(College, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Create operation
    @PostMapping("/college")
    public void add(@RequestBody College College) {
        service.save(College);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/college/{id}")
    public ResponseEntity<?> update(@RequestBody College College, @PathVariable Integer id) {
        try {
        	College existCollege = service.get(id);
            service.save(College);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Delete operation
    @DeleteMapping("/college/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    
   


}
