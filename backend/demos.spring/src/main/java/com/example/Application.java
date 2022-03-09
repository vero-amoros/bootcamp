package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.domains.contracts.repositories.ActorRepositoy;
import com.example.domains.contracts.services.ActorService;
import com.example.domains.entities.Actor;
import com.example.ioc.Servicio;
import com.example.jdbc.ConsultaSQL;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

@EnableOpenApi
@EnableEurekaClient
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	@Qualifier("despliegue")
	Servicio srv;

	@Autowired(required = false)
	@Qualifier("manual")
	Servicio srv1;

	@Autowired
	ConsultaSQL jdbc;

	@Autowired
	ActorRepositoy dao;

	@Autowired
	ActorService srvActor;

	@Override
	@Transactional
	public void run(String... args) {

	}

	@Transactional
	private void crud() {
		System.out.println("Create <-----------------------");
		var a = new Actor("Pepito", "Grillo");
		dao.save(a);
		System.out.println(a);
		a.addFilmActor(1);
		a.addFilmActor(2);
		a.addFilmActor(14);
		dao.save(a);

		System.out.println("Read <-----------------------");
		var newId = a.getActorId();
		a = dao.getById(newId);
		System.out.println(a);
		a.getFilmActors().forEach(item -> System.out.println(item.getFilm().getTitle()));

		System.out.println("Update <-----------------------");
		a.setFirstName(a.getFirstName().toUpperCase());
		a.removeFilmActor(a.getFilmActors().get(1));
		a.addFilmActor(3);
		dao.save(a);
		a = dao.getById(newId);
		System.out.println(a);
		a.getFilmActors().forEach(item -> System.out.println(item.getFilm().getTitle()));

		System.out.println("Delete <-----------------------");
		dao.deleteById(newId);
		if (dao.findById(newId).isEmpty())
			System.out.println("Ya no está");
		else
			System.out.println("ERROR: no se ha borrado");

		System.out.println("Fin CRUD <-----------------------");
	}

}
