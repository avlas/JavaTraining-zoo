package com.zoo.data.animals;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import com.zoo.data.JpaDao;
import com.zoo.model.animals.Animal;

@ApplicationScoped
//@NamedQuery(name = "findAnimalsByFamily", query = "SELECT a FROM Animal a WHERE a.family = :animFamily")
public class AnimalsDaoImpl extends JpaDao<Integer, Animal> implements AnimalsDao {

	@Override
	public List<Animal> findAnimalsByFamily(String family) {
		// return
		// entityManager.createNamedQuery("findAnimalsByFamily").setParameter("animFamily",
		// family).getResultList();

		// CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		// CriteriaQuery<Animal> query = cb.createQuery(Animal.class);
		// Root<Animal> animal = query.from(Animal.class);
		// query.select(animal).where(animal.get("family"), family);

		Query q = entityManager
				.createQuery("SELECT e FROM " + entityClass.getName() + " e WHERE family >= :anim_family");
		q.setParameter("anim_family", family);
		return (List<Animal>) q.getResultList();

	}

}