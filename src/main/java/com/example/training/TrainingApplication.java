package com.example.training;

import com.example.training.repository.RoomRepository;
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
	public CommandLineRunner run(RoomRepository roomRepository) {
		return args -> {
			roomRepository.findAll().forEach(System.out::println );
		};
	}

}
