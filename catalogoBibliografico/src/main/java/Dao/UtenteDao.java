package Dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Utente;

public class UtenteDao {
	private final EntityManager em;

	public UtenteDao(EntityManager em) {
		this.em = em;
	}
//metodo save

	public void saveEvent(Utente ev) {
		EntityTransaction e = em.getTransaction();
		e.begin();
		em.persist(ev);
		e.commit();
		System.out.println("Autore salvato correttamente");
	}

//metodo find	

	public Utente findEventById(UUID id) {

		Utente trova = em.find(Utente.class, id);
		return trova;
	}

//metodo delete

	public void findByIdAndDelete(UUID id) {
		Utente trova = em.find(Utente.class, id);
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
