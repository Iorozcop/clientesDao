package com.everis.hibernate.persistence;

/**
 * Clase de implementación de Cliente.
 * 
 * @author Isabel Orozco Puerto
 * 
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EverisClientDaoImpl implements EverisClientDaoI {

	/** Manejador de entidades */

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insert(EverisClient entity) {

		// Abrir sesión
		Session currentSession = entityManager.unwrap(Session.class);

		// insert
		currentSession.save(entity);
	}

	@Override
	@Transactional
	public List<EverisClient> searchAll() {

		// Abrir sesión
		Session currentSession = entityManager.unwrap(Session.class);

		// Búsqueda
		List<EverisClient> list = currentSession.createQuery("FROM EverisClient").list();

		return list;
	}

	@Override
	@Transactional
	public EverisClient searchById(long id) {

		// Abrir sesión
		Session currentSession = entityManager.unwrap(Session.class);

		// Búsqueda por id
		EverisClient result = currentSession.get(EverisClient.class, id);

		return result;
	}

	@Override
	public void delete(final EverisClient entity) {

		// insert
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	@Override
	@Transactional
	public void update(EverisClient entity) {

		// Abrir sesión
		Session currentSession = entityManager.unwrap(Session.class);

		// insert
		currentSession.update(entity);
		System.out.println("\n---------- Datos modificados ---------\n");

	}

	@Override
	@Transactional
	public List<EverisClient> searchByName(String name, String firstLastName, String secondLastName) {

		// Abrir sesión
		Session currentSession = entityManager.unwrap(Session.class);

		// Búsqueda
		List<EverisClient> list = currentSession.createQuery("FROM EverisClient WHERE c_name like '%" 
		+ name + "%' AND c_first_last_name = '"+ firstLastName +"' AND c_second_last_name = '"+ secondLastName +"'").list();

		return list;
	}

}
