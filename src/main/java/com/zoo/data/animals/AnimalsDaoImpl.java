package com.zoo.data.animals;

import java.util.List;

import javax.persistence.Query;

import com.zoo.data.JpaDao;
import com.zoo.model.animals.Animal;

public class AnimalsDaoImpl extends JpaDao<Integer, Animal> implements AnimalsDao {

	@Override
	public List<Animal> findAnimalsByDiet(String diet) {
//		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		 CriteriaQuery<entityClass.getName()> query = cb.createQuery(entityClass.getName().getClass());
//		 Root<entityClass.getName()> animal = query.from(entityClass.getName());
//		 query.select(animal).where(animal.get("diet"), animDiet);

		Query q = entityManager.createQuery("SELECT a FROM " + entityClass.getName() + " a WHERE a.diet = :animDiet");
		q.setParameter("animDiet", diet);
		return q.getResultList();

	}

}