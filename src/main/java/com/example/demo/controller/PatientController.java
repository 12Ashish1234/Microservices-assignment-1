package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Patient;
import com.example.demo.repository.PatientRepository;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	@GetMapping("/getAll")
	public String getAllPatients(Model model) {
		List<Patient> patients = patientRepository.findAll();
		model.addAttribute("patients", patients);
		return "patient-list";
	}

	@GetMapping("/{id}")
	public String getPatientById(@PathVariable("id") Long patientId, Model model) {
		Optional<Patient> optionalPatient = patientRepository.findById(patientId);

		if (optionalPatient.isPresent()) {
			Patient patient = optionalPatient.get();
			model.addAttribute("patient", patient);
			return "patient-details";
		}

		return "Error";

	}

	@GetMapping("/new")
	public String showPatientForm(Model model) {
		model.addAttribute("patient", new Patient());
		return "patient-form";
	}

	@PostMapping("/save")
	public String savePatient(Patient patient) {
		patientRepository.save(patient);
		return "redirect:/patient/getAll";
	}

}
