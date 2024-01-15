package kth.milad.repository;

import kth.milad.entity.Msg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Msg, Integer> {
    List<Msg> findAllBySenderOrReceiver(int userId, int userId1);
    List<Msg> findMsgBySenderAndReceiver(int loggedInUserId, int otherUserId);
}
