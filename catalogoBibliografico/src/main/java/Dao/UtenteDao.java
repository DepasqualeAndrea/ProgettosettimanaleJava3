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

	public void saveUtente(Utente ev) {
		EntityTransaction e = em.getTransaction();
		e.begin();
		em.persist(ev);
		e.commit();
		System.out.println("Utente salvato correttamente");
	}

//metodo find	

	public Utente findUtenteById(UUID id) {

		Utente trova = em.find(Utente.class, id);
		return trova;
	}

//metodo delete

	public void findUtenteByIdAndDelete(UUID id) {
		Utente trova = em.find(Utente.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Utente eliminato con successo");
		} else {
			System.out.println("Utente non trovato");
		}
	}
}
