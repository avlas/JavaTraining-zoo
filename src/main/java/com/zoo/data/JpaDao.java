package com.zoo.data;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class JpaDao<K, E> implements Dao<K, E> {

	@Inject
	protected EntityManager entityManager;

	protected Class<E> entityClass;

	public JpaDao() {
		Class<?> genericSuperclass = getClass();
		while(!ParameterizedType.class.isAssignableFrom(genericSuperclass.getGenericSuperclass().getClass())) {
			genericSuperclass = genericSuperclass.getSuperclass();
		}
//		System.err.println(genericSuperclass);
		ParameterizedType genericSuperclass2 = (ParameterizedType) genericSuperclass.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass2.getActualTypeArguments()[1];
	}

	@Override
	public void persist(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public void remove(E entity) {
		entityManager.remove(entity);
	}

	@Override
	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public List<E> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(this.entityClass);
        Root<E> root = cq.from(this.entityClass);
        cq.select(root);
        TypedQuery<E> q = entityManager.createQuery(cq);
        List<E> allEntities = q.getResultList();
        return allEntities;
	}
}
