package kth.milad.service;

import kth.milad.entity.Observation;
import kth.milad.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservationService {

    @Autowired
    private ObservationRepository observationRepository;

    public Observation createObservation(Observation observation) {
        return observationRepository.save(observation);
    }

    public Observation getObservationById(int observationId) {
        return observationRepository.findById(observationId).orElse(null);
    }
    public Observation getObservationByEncounterId(int encounterId) {
        return observationRepository.findObservationByEncounterId(encounterId);
    }

}