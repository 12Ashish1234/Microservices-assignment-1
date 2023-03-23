package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Patient;
import com.example.demo.models.Services;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.ServicesRepository;

@SpringBootApplication
public class PatientManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientManagementApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(PatientRepository patientRepository, ServicesRepository serviceRepository) {
        return args -> {
            // Initialize patients
            patientRepository.saveAll(Arrays.asList(
                    new Patient("John", "Doe"),
                    new Patient("Jane", "Doe"),
                    new Patient("Bob", "Smith")));

            // Initialize services
            serviceRepository.saveAll(Arrays.asList(
                    new Services("OPD", 50),
                    new Services("X-ray", 100),
                    new Services("ECG", 75)));
        };

}
}
