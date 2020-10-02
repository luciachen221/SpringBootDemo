package com.demo.service;

import java.util.List;

import com.demo.model.Patient;

public interface PatientService {
	
	 public List<Patient> getAllPatient();
	 
	 public Patient getPatientById(int id);
	 
	 public Patient addPatient(Patient Patient);
	 
	 public void updatePatient(Patient Patient);
	 
	 public void deletePatient(int id);

}
