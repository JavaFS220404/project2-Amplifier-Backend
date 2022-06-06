package com.revature.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Hero;

public interface HeroDAO extends JpaRepository<Hero, Integer> {

	Optional<Hero> findByName(String heroName);

}
