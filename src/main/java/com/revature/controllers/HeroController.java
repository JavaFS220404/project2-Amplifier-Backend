package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Hero;
import com.revature.services.HeroService;

@RestController
@RequestMapping(value="hero")
@CrossOrigin
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
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Hero> getHero(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(heroService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<List<Hero>> newHero(@RequestBody Hero hero) {
		heroService.addOrUpdateHero(hero);
		return ResponseEntity.status(HttpStatus.OK).body(heroService.getAllHeros());
	}
	
	@PutMapping
	public ResponseEntity<List<Hero>> destroyHero(@PathVariable("id") int id) {
		heroService.destroyHero(id);
		return ResponseEntity.status(HttpStatus.OK).body(heroService.getAllHeros());
	}
	
}
