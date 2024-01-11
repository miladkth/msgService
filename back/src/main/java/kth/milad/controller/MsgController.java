package kth.milad.controller;

import kth.milad.ViewModels.UserVm;
import kth.milad.entity.Doctor;
import kth.milad.entity.Msg;
import kth.milad.entity.Others;
import kth.milad.entity.Patient;
import kth.milad.service.IService;
import kth.milad.service.MessageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MsgController {
    @Autowired
    private MessageServiceImp msgService;
    private IService<Doctor> doctorService;
    private IService<Patient> patientService;
    private IService<Others> othersService;

    @GetMapping("/msgs")
    public List<Msg> getAll(){
        List<Msg> list = msgService.getAll();
        return list;
    }

    @PostMapping("/msg")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Msg msg){
        msgService.create(msg);
    }

    @GetMapping("/msgs/user/{userId}")
    public List<Msg> getAllMessagesForUser(@PathVariable int userId) {
        // Assuming you have a method in the service to get all messages for a user
        return msgService.getAllMessagesForUser(userId);
    }

    @GetMapping("/msgs/conversation/{loggedInUserId}/{otherUserId}")
    public List<Msg> getConversationWithUser(@PathVariable int loggedInUserId, @PathVariable int otherUserId) {
        // Assuming you have a method in the service to get a conversation with another user
        // Note: You might need the currently authenticated user ID here
         //loggedInUserId = 1; // todo Replace with your actual mechanism to get the logged-in user ID
        return msgService.getConversationBySenderAndReceiverId(loggedInUserId, otherUserId);
    }


}
