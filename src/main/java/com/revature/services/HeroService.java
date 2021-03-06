package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Hero;
import com.revature.models.User;
import com.revature.repositories.HeroDAO;

@Service
public class HeroService {

	private HeroDAO heroDao;

	@Autowired
	public HeroService(HeroDAO heroDao) {
		super();
		this.heroDao = heroDao;
	}

	public List<Hero> getAllHeros() {
		return heroDao.findAll();
	}

	public Hero findById(int id) {
		Optional<Hero> opt = heroDao.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public Hero findByHeroName(String heroname) {
		Optional<Hero> opt = heroDao.findByName(heroname);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	public Hero findByCreator(User user) {	
		Optional<Hero> opt = heroDao.findByCreator(user);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public Hero addHero(Hero hero,User user) {
		hero.setCreator(user);
		hero.setId(0);
		Hero dbhero = heroDao.save(hero);
		return dbhero;
	}
	
	public Hero updateHero(Hero hero, User user) {
		Optional<Hero> opt = heroDao.findByCreator(user);
		if (opt.isPresent()) {
			hero.setCreator(user);
			System.out.println(hero);
			return heroDao.save(hero);
		}else
			return null;
		
	
	}

	public void deleteHero(int id) {
		Hero hero = findById(id);
		heroDao.delete(hero);
	}

}
