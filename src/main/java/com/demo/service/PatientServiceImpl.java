package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.demo.model.Patient;

@Component
public class PatientServiceImpl implements PatientService {

	private static List<Patient> patients = new ArrayList<>();

	static {
	  Patient jack1 = new Patient(1, "John Lee", "jlee@test.com", "This is John");
	  Patient jack2 = new Patient(2, "Tim Wood", "twood@test.com", "This is Tim");
	  Patient jack3 = new Patient(3, "Amy King", "ayoung@test.com", "This is Amy");
	  
	  patients.add(jack1);
	  patients.add(jack2);
	  patients.add(jack3);
	}

	@Override
	public List<Patient> getAllPatient() {
		return patients;
	}

	@Override
	public Patient getPatientById(int id) {
		for (Patient patient: patients) {
			if (patient.getId() == id) {
				return patient;
			}
		}
		return null;
	}

	@Override
	public Patient addPatient(Patient patient) {
		Random random = new Random();
		int nextId = random.nextInt(1000) + 10;
		
		patient.setId(nextId);
		patients.add(patient);
		
		return patient;
	}

	@Override
	public void updatePatient(Patient patient) {
		for (Patient oldPatient: patients) {
			if (oldPatient.getId() == patient.getId()) {
				oldPatient.setName(patient.getName());
				oldPatient.setEmail(patient.getEmail());
				oldPatient.setDescription(patient.getDescription());
			}
		}
		
	}

	@Override
	public void deletePatient(int id) {
		for (Patient patient: patients) {
			if (patient.getId() == id) {
				patients.remove(patient);
				break;
			}
		}
		
	}
	
}
