package kth.milad.repository;

import kth.milad.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Integer> {
    // Define custom query methods if needed
    List<Observation> findAllByEncounterId(int encounterId);

    Observation findObservationByEncounterId(int encounterId);
}

