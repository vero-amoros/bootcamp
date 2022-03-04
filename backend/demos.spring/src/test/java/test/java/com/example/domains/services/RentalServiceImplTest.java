package test.java.com.example.domains.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.domains.contracts.repositories.RentalRepository;
import com.example.domains.entities.Customer;
import com.example.domains.entities.Inventory;
import com.example.domains.entities.Rental;
import com.example.domains.entities.Staff;
import com.example.domains.services.RentalServiceImpl;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

class RentalServiceImplTest {
	List<Rental> listado;
	RentalRepository dao;

	@BeforeEach
	void setUp() throws Exception {
		java.util.Date date = Date.from(Instant.parse("2014-12-12T10:39:40Z"));
		listado = new ArrayList<Rental>();
		listado.add(new Rental(1, date, new Inventory(1), new Customer(1), date, new Staff(1)));
		listado.add(new Rental(2, date, new Inventory(2), new Customer(2), date, new Staff(2)));
		dao = mock(RentalRepository.class);
	}

	@Test
	void testGetAll() {
		when(dao.findAll()).thenReturn(listado);
		var srv = new RentalServiceImpl(dao);

		var rslt = srv.getAll();

		assertNotNull(rslt);
		assertEquals(2, rslt.size());
	}

	@Test
	void testGetOne() throws NotFoundException {
		when(dao.findById(1)).thenReturn(Optional.of(listado.get(0)));
		var srv = new RentalServiceImpl(dao);

		var rslt = srv.getOne(1);
		assertNotNull(rslt);
		assertEquals(1, rslt.getRentalId());
	}

	@Test
	void testGetOneNotFound() throws NotFoundException {
		when(dao.findById(1)).thenReturn(Optional.empty());
		var srv = new RentalServiceImpl(dao);

		assertThrows(NotFoundException.class, () -> srv.getOne(1));
	}

	@Test
	void testAdd() throws NotFoundException, DuplicateKeyException, InvalidDataException {
		when(dao.findById(1)).thenReturn(Optional.empty());
		when(dao.save(any())).thenReturn(listado.get(0));
		var srv = new RentalServiceImpl(dao);

		var rslt = srv.add(listado.get(0));
		assertNotNull(rslt);
		assertEquals(1, rslt.getRentalId());
	}

	@Test
	void testAddNull() {
		var srv = new RentalServiceImpl(dao);

		assertThrows(IllegalArgumentException.class, () -> srv.add(null));
	}

	@Test
	void testAddDuplicateKey() throws NotFoundException, DuplicateKeyException, InvalidDataException {
		when(dao.findById(1)).thenReturn(Optional.of(listado.get(0)));
		var srv = new RentalServiceImpl(dao);

		assertThrows(DuplicateKeyException.class, () -> srv.add(listado.get(0)));
	}

	@Test
	void testAddInvalidData() throws NotFoundException, DuplicateKeyException, InvalidDataException {
		when(dao.findById(1)).thenReturn(Optional.empty());
		var srv = new RentalServiceImpl(dao);

		assertThrows(InvalidDataException.class, () -> srv.add(new Rental(1)));
	}

	@Test
	void testChange() throws NotFoundException, DuplicateKeyException, InvalidDataException {
		when(dao.findById(1)).thenReturn(Optional.of(listado.get(0)));
		when(dao.save(any())).thenReturn(listado.get(0));
		var srv = new RentalServiceImpl(dao);

		var rslt = srv.change(listado.get(0));
		assertNotNull(rslt);
		assertEquals(1, rslt.getRentalId());
	}

	@Test
	void testChangeNull() {
		var srv = new RentalServiceImpl(dao);

		assertThrows(IllegalArgumentException.class, () -> srv.change(null));
	}

	@Test
	void testChangeNotFound() throws NotFoundException, DuplicateKeyException, InvalidDataException {
		when(dao.findById(1)).thenReturn(Optional.empty());
		var srv = new RentalServiceImpl(dao);

		assertThrows(NotFoundException.class, () -> srv.change(listado.get(0)));
	}

	@Test
	void testChangeInvalidData() throws NotFoundException, DuplicateKeyException, InvalidDataException {
		when(dao.findById(1)).thenReturn(Optional.of(listado.get(0)));
		var srv = new RentalServiceImpl(dao);

		assertThrows(InvalidDataException.class, () -> srv.change(new Rental(1)));
	}

	@Test
	void testDelete() {
		doNothing().when(dao).deleteById(1);
		var srv = new RentalServiceImpl(dao);
		srv.delete(new Rental(1));
		verify(dao).deleteById(1);
	}

	@Test
	void testDeleteById() {
		doNothing().when(dao).deleteById(1);
		var srv = new RentalServiceImpl(dao);
		srv.deleteById(1);
		verify(dao).deleteById(1);
	}

}
