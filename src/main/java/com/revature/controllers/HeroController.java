package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Hero;
import com.revature.models.User;
import com.revature.services.HeroService;

@RestController
@RequestMapping("/hero")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class HeroController {

	private HeroService heroService;

	@Autowired
	public HeroController(HeroService heroService) {
		super();
		this.heroService = heroService;
	}

	@GetMapping
	public ResponseEntity<List<Hero>> getAllHeroes() {
		return ResponseEntity.status(HttpStatus.OK).body(heroService.getAllHeros());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Hero> getHero(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(heroService.findById(id));
	}

	@GetMapping("/{heroname}")
	public ResponseEntity<Hero> getByHeroName(@PathVariable("heroname") String heroname) {
		Hero hero = heroService.findByHeroName(heroname);
		if (hero != null) {
			return ResponseEntity.status(HttpStatus.OK).body(hero);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@PostMapping
	public ResponseEntity<Hero> newHero(@RequestBody Hero hero) {
		heroService.addOrUpdateHero(hero);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<Hero> updateHero(@RequestBody Hero hero) {
		heroService.addOrUpdateHero(hero);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@DeleteMapping
	public ResponseEntity<Hero> deleteHero(@PathVariable("id") int id) {
		heroService.deleteHero(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

}
