package kth.milad.repository;

import kth.milad.entity.Others;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OthersRepository extends JpaRepository<Others,Integer> {
    Others findByEmail(String email);
}
