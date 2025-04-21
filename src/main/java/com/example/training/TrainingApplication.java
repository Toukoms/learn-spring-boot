package com.example.training;

import com.example.training.data.repository.EmployeeRepository;
import com.example.training.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RoomRepository roomRepository, EmployeeRepository employeeRepository) {
		return args -> {
			System.out.print("**************** ROOMS ******************");
			System.out.println(roomRepository.findAll().isEmpty() ? "No Room in database" : "");
			roomRepository.findAll().forEach(System.out::println);

			System.out.println();
			System.out.print("**************** EMPLOYEES ******************");
			System.out.println(employeeRepository.findAll().isEmpty() ? "No Employee in database" : "");
			employeeRepository.findAll().forEach(System.out::println);
		};
	}

}
