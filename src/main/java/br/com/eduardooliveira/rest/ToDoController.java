package br.com.eduardooliveira.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.eduardooliveira.model.ToDo;
import br.com.eduardooliveira.repository.ToDoRepository;

@RestController
@RequestMapping("/api/to-do")
public class ToDoController {

	@Autowired
	private ToDoRepository toDoRepository;
	
	@PostMapping
	public ToDo save(@RequestBody ToDo toDo) {
		return toDoRepository.save(toDo);
	}
	
	@GetMapping("{id}")
	public ToDo getById(@PathVariable Long id) {
		return toDoRepository
							.findById(id)
							.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
