package org.spring.orm.dao;

import java.util.List;

//import javax.transaction.Transactional;

import org.spring.orm.entities.Cake;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


public class CakeDao {

	private  HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Cake cake) {
		Integer i =(Integer) this.hibernateTemplate.save(cake);
		return i;
	}
	
	//getting a single data
	public Cake get(int cakeId) {
		Cake cake = this.hibernateTemplate.get(Cake.class, cakeId);
		return cake;
	}
	
	//getting the entire data
	public List<Cake> getAllCakes() {
		List<Cake> cakes = this.hibernateTemplate.loadAll(Cake.class);
		return cakes;
	}
	
	//updating a data
	@Transactional
	public void updateCake(Cake cake) {
		this.hibernateTemplate.update(cake);
	}
	
	//deleting a data
	@Transactional
	public void deleteCake(int cakeId) {
		Cake cake = this.hibernateTemplate.get(Cake.class, cakeId);
		this.hibernateTemplate.delete(cake);
	}

}
