package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.model.Patient;
import com.demo.service.PatientServiceImpl;

@RestController
public class PatientController {

	@Autowired
	private PatientServiceImpl patientService;

	@GetMapping("/patient/")
	public List<Patient> getAllPatient() {
		return patientService.getAllPatient();
	}

	@GetMapping("/patient/{patientId}")
	public Patient getPatientById(@PathVariable int patientId) {
		return patientService.getPatientById(patientId);
	}

	@PostMapping("/patient/")
	public ResponseEntity<Void> addCustomer(@RequestBody Patient newPatient, UriComponentsBuilder builder) {
		Patient patient = patientService.addPatient(newPatient);

		if (patient == null) {
			return ResponseEntity.noContent().build();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/customer/{id}").buildAndExpand(patient.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/patient/")
	public ResponseEntity<Patient> updateCustomer(@RequestBody Patient patient) {
		Patient p = patientService.getPatientById(patient.getId());

		if (p == null) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}

		p.setName(patient.getName());
		p.setEmail(patient.getEmail());
		p.setDescription(patient.getDescription());

		patientService.updatePatient(p);
		return new ResponseEntity<Patient>(p, HttpStatus.OK);
	}

	@DeleteMapping("/patient/{patientId}")
	public ResponseEntity<Patient> deleteCustomer(@PathVariable int patientId) {
		Patient p = patientService.getPatientById(patientId);

		if (p == null) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}

		patientService.deletePatient(patientId);
		return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
	}

}
