package kth.milad.repository;

import kth.milad.entity.Patient;
import kth.milad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {}
