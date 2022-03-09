package com.example.application.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.application.dtos.FilmDTO;
import com.example.application.dtos.FilmShortDTO;
import com.example.domains.contracts.services.FilmService;
import com.example.domains.entities.Film;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@RestController
@RequestMapping("/api/peliculas")
public class FilmResource {
	@Autowired
	private FilmService srv;

	@GetMapping
	public List<FilmShortDTO> getAll() {
		return srv.getByProjection(FilmShortDTO.class);
	}
	

	

//	@GetMapping(path = "/{id}")
//	public FilmDTO getOne(@PathVariable int id) throws NotFoundException {
//		return FilmDTO.from(srv.getOne(id));
//	}
//	
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody FilmDTO item) throws InvalidDataException, DuplicateKeyException {
		Film Film = FilmDTO.from(item);
		if(Film.isInvalid())
			throw new InvalidDataException(Film.getErrorsMessage());
		Film = srv.add(Film);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(Film.getFilmId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void update(@PathVariable int id, @Valid @RequestBody FilmDTO item) throws InvalidDataException, NotFoundException {
		if(id != item.getFilmId())
			throw new InvalidDataException("No coinciden los identificadore");
		Film Film = FilmDTO.from(item);
		if(Film.isInvalid())
			throw new InvalidDataException(Film.getErrorsMessage());
		srv.change(Film);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		srv.deleteById(id);
	}
}
