package com.everis.hibernate.services;

/**
 * Clase de implementación de Servicio
 * 
 * @author Isabel Orozco Puerto
 * 
 */

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.hibernate.persistence.EverisClient;
import com.everis.hibernate.persistence.EverisClientDaoI;

@Service
public class EverisClientServiceImpl implements EverisClientServiceI {

	@Autowired
	private EverisClientDaoI clientDaoI;

	@Override
	@Transactional
	public void insert(EverisClient entity) {

		clientDaoI.insert(entity);
	}

	@Override
	@Transactional
	public void searchAll() {

		final List<EverisClient> clientList = clientDaoI.searchAll();
		System.out.println("\n----------------------- LISTA DE CLIENTES --------------------------\n");
		if (clientList.size() > 0) {
			for (EverisClient client : clientList) {
				System.out.println(client.toString());
			}
		} else {
			System.out.println("No existen clientes");
		}
		System.out.println("-------------------------------------------------");
	}

	@Override
	@Transactional
	public void searchById(long id) {

		final EverisClient client = clientDaoI.searchById(id);

		if (client != null) {
			System.out.println("El cliente con id: " + client.getIdCLient() + " es: " + client.getName() + " " + client.getFirstLastName() + " " + client.getSecondLastName());
		}
	}

	@Override
	@Transactional
	public void delete(EverisClient entity) {

		clientDaoI.delete(entity);

	}

	@Override
	@Transactional
	public void update(EverisClient entity) {

		clientDaoI.update(entity);

	}

	@Override
	@Transactional
	public void searchByName(String name, String firstLastName, String secondLastName) {

		final List<EverisClient> clientList = clientDaoI.searchByName(name, firstLastName, secondLastName);

		if (clientList.size() > 0) {
			for (EverisClient client : clientList) {
				System.out.println("\n---------- Cliente encontrado ---------\n");
				System.out.println(client.toString());
				System.out.println("-------------------------------------------------");
			}
		} else {
			System.out.println("-------------------------------------------------");
			System.out.println("No existen clientes con el nombre: " + name + " " + firstLastName + " " + secondLastName );
		}
	}

}
