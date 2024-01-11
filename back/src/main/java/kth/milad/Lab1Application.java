package kth.milad;

import kth.milad.controller.PatientController;
import kth.milad.entity.Doctor;
import kth.milad.entity.Encounter;
import kth.milad.entity.Msg;
import kth.milad.entity.Patient;
import kth.milad.repository.PatientRepository;
import kth.milad.service.IService;
import kth.milad.service.PatientServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Lab1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);

		/*List<Msg> msgList = new ArrayList<>();
		List<Encounter> encounters = new ArrayList<>();
		Patient p = new Patient(1,"milad hård kodad",msgList,encounters);

		PatientServiceImp patientServiceImp = new PatientServiceImp();
		patientServiceImp.createPatient(p);*/
	}

}
