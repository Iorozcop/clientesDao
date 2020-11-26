package com.everis.hibernate.services;

/**
 * Interface de servicio
 * 
 * @author Isabel Orozco Puerto
 * 
 */

import com.everis.hibernate.persistence.EverisClient;


public interface EverisClientServiceI {
	
	
	/**
	 * Método que llama a EverisClientDaoI para insertar un cliente
	 * @param entity
	 */
	public void insert(EverisClient entity);
	
	/**
	 * Método que llama a EverisClientDaoI para mostrar todos los clientes
	 */
	public void searchAll();
	
	/**
	 * Método que llama a EverisClientDaoI para buscar por id
	 * @param id
	 */
	public void searchById(long id);
	
	/**
	 * Método que llama a EverisClientDaoI para eliminar un cliente
	 * @param entity
	 */
	public void delete(EverisClient entity);
	
	
	/**
	 * Método que llama a EverisClientDaoI para realizar un cambio en un cliente
	 * @param entity
	 */
	public void update(EverisClient entity);
	
	/**METODO PROPIO DE CLIENTE*/
	
	/**
	 * Método llama a EverisClientDaoI para poder buscar por nombre y apellidos del cliente
	 * @param name
	 * @param firstLastName
	 * @param secondLastName
	 */
	public void searchByName(final String name, String firstLastName, String secondLastName);
}
