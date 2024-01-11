package kth.milad.controller;

import kth.milad.entity.Observation;
import kth.milad.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ObservationController {

    private ObservationService observationService;
    @Autowired
    public ObservationController(ObservationService observationService){
        this.observationService = observationService;
    }


    // Endpoint to create a new observation
    @PostMapping("observation")
    public ResponseEntity<Observation> createObservation(@RequestBody Observation observation) {
        Observation createdObservation = observationService.createObservation(observation);
        return ResponseEntity.ok(createdObservation);
    }

    @GetMapping("/observations/encounter/{encounterId}")
    public ResponseEntity<Observation> getObservationByEncounterId(@PathVariable int encounterId) {
        Observation observation = observationService.getObservationByEncounterId(encounterId);
        if (observation != null) {
            return ResponseEntity.ok(observation);
        } else {
            return ResponseEntity.notFound().build(); // Observation not found
        }
    }

    // Endpoint to get an observation by its ID
    @GetMapping("/observations/{observationId}")
    public ResponseEntity<Observation> getObservationById(@PathVariable int observationId) {
        Observation observation = observationService.getObservationById(observationId);
        if (observation != null) {
            return ResponseEntity.ok(observation);
        } else {
            return ResponseEntity.notFound().build(); // Observation not found
        }
    }
}