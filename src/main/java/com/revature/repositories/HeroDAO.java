package com.revature.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Hero;
import com.revature.models.User;

public interface HeroDAO extends JpaRepository<Hero, Integer> {

	Optional<Hero> findByName(String heroName);
	
	Optional<Hero> findByCreator(User user);

}
