package com.everis.hibernate.persistence;

/**
 * Interface Cliente
 * 
 * @author Isabel Orozco Puerto
 * 
 */

import java.util.List;


public interface EverisClientDaoI {

	/** MÉTODOS SUBCEPTIBLES DE DAO GENÉRICO */
	
	/**
	 * Método que inserta un cliente
	 * @param entity
	 */
	public void insert(final EverisClient entity);
	
	/**
	 * Método que busca y saca todos los clientes
	 * @return lista clientes
	 */
	public List<EverisClient> searchAll();
	
	/**
	 * Método que busca un cliente por nombre
	 * @param id
	 * @return
	 */
	public EverisClient searchById(final long id);
	
	/**
	 * Método que elimina un cliente
	 * @param entity
	 */
	public void delete(final EverisClient entity);
	

	/**
	 * Método para hacer un cambio en un cliente
	 * @param entity
	 */
	public void update(EverisClient entity);
	
	
	
	/**METODO PROPIO DE CLIENTE*/
	
	/**
	 * Método para buscar por nombre
	 * @param name
	 * @param firstLastName
	 * @param secondLastName
	 * @return lista de clientes encontrados
	 */
	public List<EverisClient> searchByName(final String name, String firstLastName, String secondLastName);
	
} 

