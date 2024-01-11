package kth.milad.service;

import kth.milad.entity.Msg;
import kth.milad.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements IService<Msg> {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Msg> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Msg getById(int entity) {
        return null;
    }

    @Override
    public Msg create(Msg entity) {
        return messageRepository.save(entity);
    }

    public List<Msg> getAllMessagesForUser(int userId) {
        // Placeholder: Implement the actual logic to get all messages for a user
        // For example, you might want to find messages where the user is the sender or receiver
        return messageRepository.findAllBySenderOrReceiver(userId, userId);
    }

    public List<Msg> getConversationBySenderAndReceiverId(int loggedInUserId, int otherUserId) {
        // Placeholder: Implement the actual logic to get a conversation between two users
        // For example, you might want to find messages where the sender is either the logged-in user or the other user,
        // and the receiver is either the logged-in user or the other user
        return messageRepository.findMsgBySenderAndReceiver(loggedInUserId, otherUserId);
    }
}
