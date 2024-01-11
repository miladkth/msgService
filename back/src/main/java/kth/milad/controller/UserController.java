package kth.milad.controller;

import kth.milad.ViewModels.UserVm;
import kth.milad.entity.Doctor;
import kth.milad.entity.Others;
import kth.milad.entity.Patient;
import kth.milad.entity.User;
import kth.milad.service.IService;
import kth.milad.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;

@RestController
@CrossOrigin
public class UserController {

    private static final AtomicInteger uniqueId = new AtomicInteger(0);

    @Autowired
    private IService<Doctor> doctorService;
    @Autowired
    private IService<Others> othersService;
    @Autowired
    private IService<Patient> patientService;

    @Autowired
    private IService<User> userService;

    @Autowired
    private UserServiceImp userServiceImp;


    @PostMapping("/register")
    public void RegisterUser(@RequestBody UserVm userVm){
        User newUser = new User();
        newUser.setUserId(generateUniqueUserId() ); // Implement your logic to generate unique IDs


        switch (userVm.getUserType()){
            case "DOCTOR": //doctorService.create(new Doctor(userVm.getId(), userVm.getName(), userVm.getEmail(), userVm.getPassword(), newUser));
                Doctor doctor = new Doctor();
                doctor.setUser(newUser);
                doctor.setUserId(userVm.getId()); doctor.setName(userVm.getName()); doctor.setEmail(userVm.getEmail()); doctor.setPassword(userVm.getPassword());
                userServiceImp.createDoctor(doctor);
                System.out.println(userVm.getEmail());break;
            case "OTHERS": userServiceImp.createOthers(new Others(userVm.getId(), userVm.getName(), userVm.getEmail(), userVm.getPassword(), newUser));break;
            case "PATIENT": userServiceImp.createPatient(new Patient(userVm.getId(), userVm.getName(), userVm.getEmail(), userVm.getPassword(), newUser));break;
        }
        //todo return userVm
    }

    private int generateUniqueUserId(){
        return uniqueId.incrementAndGet();
    }

    @PostMapping("/login")
    public UserVm loggInUser(@RequestBody UserVm userVm){
        List<UserVm> userVms = new ArrayList<>();
        List<Doctor> doctors = doctorService.getAll();
        for (Doctor d:doctors) {
            userVms.add(new UserVm(d.getUserId(),d.getName(),"DOCTOR",d.getEmail(),d.getPassword(), d.getUser().getUserId()));
        }

        List<Others> others = othersService.getAll();
        for (Others o:others) {
            userVms.add(new UserVm(o.getUserId(),o.getName(),"OTHERS",o.getEmail(),o.getPassword(), o.getUser().getUserId()));
        }

        List<Patient> patients = patientService.getAll();
        for (Patient p:patients) {
            userVms.add(new UserVm(p.getUserId(), p.getName(), "PATIENT", p.getEmail(),p.getPassword(), p.getUser().getUserId()));
        }


        for (UserVm u:userVms) {
            if (u.getEmail() == null || userVm.getEmail() == null) {
                UserVm errorNoUser = new UserVm();
                errorNoUser.setName("NO USER FOUND");
                continue;
            }
            if (u.getEmail().equals(userVm.getEmail()) && u.getPassword().equals(userVm.getPassword())){
                return u;
            }
        }
        UserVm errorNoUser = new UserVm();
        errorNoUser.setName("NO USER FOUND");
        return errorNoUser;

    }
    @GetMapping("/users")
    public List<UserVm> getAllUsers(){
        List<UserVm> userVms = new ArrayList<>();
        List<Doctor> doctors = doctorService.getAll();
        for (Doctor d:doctors) {
            userVms.add(new UserVm(d.getUserId(),d.getName(),"DOCTOR",d.getEmail(),"HIDDEN", d.getUser().getUserId()));
        }

        List<Others> others = othersService.getAll();
        for (Others o:others) {
            userVms.add(new UserVm(o.getUserId(),o.getName(),"OTHERS",o.getEmail(),"HIDDEN", o.getUser().getUserId()));
        }

        List<Patient> patients = patientService.getAll();
        for (Patient p:patients) {
            userVms.add(new UserVm(p.getUserId(), p.getName(), "PATIENT", p.getEmail(),"HIDDEN", p.getUser().getUserId()));
        }
        System.out.println("userVms = " + userVms);
        return userVms;
    }
}
