package kth.milad.controller;

import kth.milad.entity.Patient;
import kth.milad.service.IService;
import kth.milad.service.PatientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PatientController {
    private IService<Patient> patientService;
    private PatientServiceImp patientServiceImp;


    @Autowired
    public PatientController(IService<Patient> patientService, PatientServiceImp patientServiceImp) {
        this.patientService = patientService;
        this.patientServiceImp = patientServiceImp;
    }

    @GetMapping("/patients")
    public List<Patient> fetchPatientList(){
        System.out.println("get patients called");
        List<Patient> list = patientService.getAll();
        return list;
    }

    @GetMapping("/patient/{id}/userId")
    public int getUserIdByPatientId(@PathVariable int id) {
        return patientServiceImp.getUserIdByPatientId(id);
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getById(id);
    }

    @GetMapping("/patient/userId/{userId}")
    public Patient getPatientByUserId(@PathVariable int userId) { return patientServiceImp.getPatientByUserId(userId);}

    @GetMapping("/patient/email/{email}")
    public Patient getPatientByEmail(@PathVariable String email) {
        return patientServiceImp.getPatientByEmail(email);
    }

    @PostMapping("patient")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPatient(@RequestBody Patient patient){
        System.out.println("patient = " + patient);
        patientService.create(patient);
    }
}
