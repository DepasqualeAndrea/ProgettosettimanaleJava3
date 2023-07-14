
package Dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Prestito;

public class PrestitoDao {
	private final EntityManager em;

	public PrestitoDao(EntityManager em) {
		this.em = em;
	}
//metodo save

	public void saveEvent(Prestito ev) {
		EntityTransaction e = em.getTransaction();
		e.begin();
		em.persist(ev);
		e.commit();
		System.out.println("Autore salvato correttamente");
	}

//metodo find	

	public Prestito findEventById(UUID id) {

		Prestito trova = em.find(Prestito.class, id);
		return trova;
	}

//metodo delete

	public void findByIdAndDelete(UUID id) {
		Prestito trova = em.find(Prestito.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Autore eliminato con successo");
		} else {
			System.out.println("Autore non trovato");
		}
	}
}
