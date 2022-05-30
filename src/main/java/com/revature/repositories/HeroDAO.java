package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Hero;

public interface HeroDAO extends JpaRepository<Hero, Integer> {

}
