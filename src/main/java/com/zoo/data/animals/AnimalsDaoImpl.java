package com.zoo.data.animals;

import java.util.List;

import javax.persistence.Query;

import com.zoo.data.JpaDao;
import com.zoo.model.animals.Animal;


//@NamedQuery(name = "findAnimalsByDiet", query = "SELECT a FROM Animal a WHERE a.diet = :animDiet")
public class AnimalsDaoImpl extends JpaDao<Integer, Animal> implements AnimalsDao {

	@Override
	public List<Animal> findAnimalsByDiet(String diet) {
		// return entityManager.createNamedQuery("findAnimalsByDiet").setParameter("animDiet",
		// diet).getResultList();

/*		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		 CriteriaQuery<entityClass.getName()> query = cb.createQuery(entityClass.getName().class);
		 Root<entityClass.getName()> animal = query.from(entityClass.getName().class);
		 query.select(animal).where(animal.get("diet"), animDiet);*/

		Query q = entityManager.createQuery("SELECT a FROM " + entityClass.getName() + " a WHERE diet = :animDiet");
		q.setParameter("animDiet", diet);
		return q.getResultList();

	}

}