package kth.milad.repository;

import kth.milad.entity.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncounterRepository extends JpaRepository<Encounter,Integer> {
    List<Encounter> findAllByUserId(int userId);
    Encounter findEncounterByUserId(int userId);

    List<Encounter> findAllIdsByUserId(int userId);
}
