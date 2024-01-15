package kth.milad.service;

import kth.milad.entity.Encounter;
import kth.milad.entity.Msg;
import kth.milad.entity.Observation;
import kth.milad.repository.EncounterRepository;
import kth.milad.repository.MessageRepository;
import kth.milad.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EncounterServiceImp implements IService<Encounter>{

    @Autowired
    private EncounterRepository encounterRepository;
    @Autowired
    private ObservationRepository observationRepository;


    @Override
    public List<Encounter> getAll() {
        return encounterRepository.findAll();
    }

    @Override
    public Encounter getById(int entity) {
        return null;
    }

    @Override
    public Encounter create(Encounter entity) {
        return encounterRepository.save(entity);
    }


    public List<Encounter> getAllEncountersByUserId(int userId) {
        return encounterRepository.findAllByUserId(userId);
    }

    public List<Encounter> getAllEncounterIdsByUserId(int userId) { return encounterRepository.findAllIdsByUserId(userId);}


    public void addObservationByUserId(int userId, Observation observation) {
        Encounter encounter = encounterRepository.findEncounterByUserId(userId);

        if (encounter != null) {

            observation.setEncounter(encounter); // Associate the observation with the encounter

            if (encounter.getObservations() == null) {
                encounter.setObservations(new ArrayList<>());
            }

            encounter.getObservations().add(observation);

            encounterRepository.save(encounter);
        } else {
            System.out.println("Observation couldn't be added because encounter is null: " + userId);
        }
    }

    public ResponseEntity<String> addObservationToEncounter(int encounterId, Observation observation){
        Optional<Encounter> optionalEncounter = encounterRepository.findById(encounterId);

        if (optionalEncounter.isPresent()) {
            Encounter encounter = optionalEncounter.get();

            observation.setEncounter(encounter); // Set the encounter for the observation
            encounter.getObservations().add(observation); // Add the observation to the encounter's list

            observationRepository.save(observation); // Save the observation with the encounter reference
            encounterRepository.save(encounter); // Save the updated encounter

            return ResponseEntity.ok("Observation added to encounter successfully");
        } else {
            return ResponseEntity.notFound().build(); // Handle encounter not found
        }
    }
}
