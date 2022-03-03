package com.example.application.resources;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.dtos.RentalDetailsDTO;
import com.example.application.dtos.RentalEditDTO;
import com.example.application.dtos.RentalShortDTO;
import com.example.domains.contracts.services.RentalService;
import com.example.exceptions.NotFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/rental")
public class RentalResource {
	@Autowired
	private RentalService srv;

	@GetMapping
	public List<RentalShortDTO> getAll() {
		return srv.getAll().stream().map(rental -> RentalShortDTO.from(rental)).toList();
	}
	
//	@GetMapping(params = "page")
//	@ApiOperation(value = "Listado paginable de los alquileres")
//	public Page<RentalShortDTO> getAll(@ApiParam(required = false) Pageable page) {
//		return srv.getByProjection(page, RentalShortDTO.class);
//	}
	
	@GetMapping(path = "/{id}")
	public RentalDetailsDTO getOneDetails(@PathVariable int id, @RequestParam(required = false, defaultValue = "details") String mode)
			throws NotFoundException {
			return RentalDetailsDTO.from(srv.getOne(id));
	}
	
//	@GetMapping(path = "/{id}", params = "mode=edit")
//	@ApiOperation(value = "Recupera una película")
//	@ApiResponses({
//		@ApiResponse(code = 200, message = "Película encontrada"),
//		@ApiResponse(code = 404, message = "Película no encontrada")
//	})
//	
//	public RentalEditDTO getOneEdit(@ApiParam(value = "Identificador de la película") @PathVariable int id, 
//			@ApiParam(value = "Versión completa o editable", required = false, allowableValues = "details,edit", defaultValue = "edit") @RequestParam() String mode)
//			throws NotFoundException {
//			return RentalEditDTO.from(srv.getOne(id));
//	}
	@GetMapping(path = "/{id}", params = "mode=edit")
	public RentalEditDTO getOneEdit(@PathVariable int id, @RequestParam(required = true) String mode)
	throws NotFoundException {
	return RentalEditDTO.from(srv.getOne(id));
	}
	
	
	
//	@PostMapping
//	@Transactional
//	@ApiOperation(value = "Añadir una nueva película")
//	@ApiResponses({
//		@ApiResponse(code = 201, message = "Película añadida"),
//		@ApiResponse(code = 400, message = "Error al validar los datos o clave duplicada"),
//		@ApiResponse(code = 404, message = "Película no encontrada")
//	})
//	public ResponseEntity<Object> create(@Valid @RequestBody PeliculaEditDTO item)
//			throws InvalidDataException, DuplicateKeyException, NotFoundException {
//		var entity = PeliculaEditDTO.from(item);
//		if (entity.isInvalid())
//			throw new InvalidDataException(entity.getErrorsMessage());
//		entity = srv.add(entity);
//		item.update(entity);
//		srv.change(entity);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(entity.getFilmId()).toUri();
//		return ResponseEntity.created(location).build();
//
//	}
}
