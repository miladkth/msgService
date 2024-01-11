package kth.milad.repository;

import kth.milad.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    @Query("SELECT p.user.userId FROM Patient p WHERE p.id = :id")
    Integer findUserIdById(@Param("id") int id);

    Patient getPatientByEmail(String email);
    @Query("SELECT p FROM Patient p where p.user.userId = :userId")
    Patient getPatientByUserId(@Param("userId") int userId);
}
