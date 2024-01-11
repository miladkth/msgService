package kth.milad.service;



import jakarta.transaction.Transactional;
import kth.milad.entity.Doctor;
import kth.milad.entity.Others;
import kth.milad.entity.Patient;
import kth.milad.entity.User;

import kth.milad.repository.DoctorRepository;
import kth.milad.repository.OthersRepository;
import kth.milad.repository.PatientRepository;
import kth.milad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IService<User>{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository; // Inject your PatientRepository here

    @Autowired
    private OthersRepository othersRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<User> getAll() {

        List<User> list = userRepository.findAll();
        System.out.println("patientList = in service imp " + list);
        return list;
    }

    @Override
    public User getById(int entity) {
        return userRepository.findById(entity).get();
    }

    public User create(User entity){
        System.out.println("in service");
        return userRepository.save(entity);
    }



    public Patient createPatient( Patient patient) {
        // Create a new User entity
        User newUser = new User();
        userRepository.save(newUser); // Save the User entity to generate userId

        // Set the obtained userId in the Patient entity
        patient.setUser(newUser);

        // Save the Patient entity with the associated User
        return patientRepository.save(patient);
    }

    @Transactional
    public Doctor createDoctor( Doctor doctor) {
        // Create a new User entity
        User newUser = new User();
        // Save the user to obtain the generated userId
        userRepository.save(newUser);

        // Set the user for the doctor entity
        doctor.setUser(newUser);

        // Save the Doctor entity with the associated User
        return doctorRepository.save(doctor);
    }

    public Others createOthers( Others others) {
        // Create a new User entity
        User newUser = new User();
       userRepository.save(newUser); // Save the User entity to generate userId

        // Set the obtained userId in the Patient entity
        others.setUser(newUser);

        // Save the Patient entity with the associated User
        return othersRepository.save(others);
    }

}
