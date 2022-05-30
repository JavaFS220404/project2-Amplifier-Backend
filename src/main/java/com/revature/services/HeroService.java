package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Hero;
import com.revature.repositories.HeroDAO;

public class HeroService {
	
	
private HeroDAO heroDao;
	
	@Autowired
	public HeroService(HeroDAO heroDao) {
		super();
		this.heroDao=heroDao;
	}
	
	public List<Hero> getAllHeros(){
		return heroDao.findAll();
	}
	
	public Hero findById(int id) {
		Optional<Hero> opt = heroDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	public Hero addOrUpdateHero (Hero trainer) {
		Hero hero = heroDao.save(trainer); 
		return hero;
	}
	
	public void destroyHero(int id) {
		Hero hero = findById(id);
		heroDao.delete(hero);
	}
	
}
