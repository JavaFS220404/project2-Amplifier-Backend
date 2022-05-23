package com.revature.daos;

import java.util.List;

import com.revature.models.Hero;

public interface HeroDAO {
	
	public List<Hero> getAllHeroes();
	public Hero getHeroById(int id);
	public void addHero(Hero hero);
	public void update(Hero hero);
	public void delte(Hero hero);
	

}
