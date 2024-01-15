package kth.milad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
