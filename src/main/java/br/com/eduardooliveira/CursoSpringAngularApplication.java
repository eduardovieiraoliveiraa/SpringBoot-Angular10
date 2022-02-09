package br.com.eduardooliveira;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.eduardooliveira.model.ToDo;
import br.com.eduardooliveira.repository.ToDoRepository;

@SpringBootApplication
public class CursoSpringAngularApplication {
	
	@Autowired
	private ToDoRepository toDoRepository;
	
	@Bean
	public CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				ToDo todo = new ToDo();
				todo.setDescription("Estudar Spring");
				todo.setCreatedDate(LocalDateTime.now());
				
				toDoRepository.save(todo);
				
			}
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringAngularApplication.class, args);
	}
}
