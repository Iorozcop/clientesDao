package com.everis.hibernate;

/**
 * Clase Principal main
 * 
 * @author Isabel Orozco Puerto
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.everis.hibernate.persistence.EverisClient;
import com.everis.hibernate.services.EverisClientServiceI;

@SpringBootApplication
public class EverisMain implements CommandLineRunner{

	/**Servicio cliente*/
	
	@Autowired
	private EverisClientServiceI clientService;
	
	public static void main(String[] args) {
		SpringApplication.run(EverisMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Creación de clientes
		EverisClient client1 = new EverisClient();
		client1.setName("José Manuel");
		client1.setFirstLastName("Orozco");
		client1.setSecondLastName("Puerto");
		client1.setDni("76688559K");
		
		EverisClient client2 = new EverisClient();
		client2.setName("Isabel");
		client2.setFirstLastName("Orozco");
		client2.setSecondLastName("Puerto");
		client2.setDni("75755887N");
		
		EverisClient client3 = new EverisClient();
		client3.setName("Noelia");
		client3.setFirstLastName("Galindo");
		client3.setSecondLastName("García");
		client3.setDni("76654569K");
		
		EverisClient client4 = new EverisClient();
		client4.setName("Dani");
		client4.setFirstLastName("Mateo");
		client4.setSecondLastName("Nogal");
		client4.setDni("76656769K");
		
		//Inserción de clientes
		clientService.insert(client1);
		clientService.insert(client2);
		clientService.insert(client3);
		clientService.insert(client4);
		
		//Muestra todos los clientes
		clientService.searchAll();
		
		//Búsqueda por id
		clientService.searchById(3);
		
		//Elimina cliente
		clientService.delete(client2);
		
		//Actualización de clientes
		client3.setName("José Luís");
		client3.setSecondLastName("Mascareña");
		client3.setDni("31209545S");
		
		//Modifica cliente3
		clientService.update(client3);
		clientService.searchById(3);
		
		//Busca por nombre
		clientService.searchByName("José Manuel", "orozco", "Puerto");
	}

}
