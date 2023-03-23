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

import com.example.demo.models.Services;
import com.example.demo.repository.ServicesRepository;

@Controller
@RequestMapping("/service")
public class ServicesController {

	@Autowired
	private ServicesRepository servicesRepository;

	@GetMapping("/getAll")
	public String getAllServices(Model model) {
		List<Services> services = servicesRepository.findAll();
		model.addAttribute("services", services);
		return "service-list";
	}

	@GetMapping("/{id}")
	public String getServicesById(@PathVariable("id") Long id, Model model) {
		Optional<Services> optionalService = servicesRepository.findById(id);
		if (optionalService.isPresent()) {
			Services service = optionalService.get();
			model.addAttribute("service", service);
			return "service-details";
		}
		return "Error";
	}

	@GetMapping("/new")
	public String showServiceForm(Model model) {
		model.addAttribute("service", new Services());
		return "service-form";
	}

	@PostMapping("/save")
	public String saveService(Services services) {
		servicesRepository.save(services);
		return "redirect:/service/getAll";
	}
}
