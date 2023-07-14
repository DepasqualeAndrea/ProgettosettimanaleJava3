package Dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Pubblicazione;

public class PubblicazioneDao {
	private final EntityManager em;

	public PubblicazioneDao(EntityManager em) {
		this.em = em;
	}
//metodo save

	public void savePubblicazione(Pubblicazione ev) {
		EntityTransaction e = em.getTransaction();
		e.begin();
		em.persist(ev);
		e.commit();
		System.out.println("Pubblicazione salvata correttamente");
	}

//metodo find	

	public Pubblicazione findPubblicazioneById(UUID id) {

		Pubblicazione trova = em.find(Pubblicazione.class, id);
		return trova;
	}

//metodo delete

	public void findPubblicazioneByIdAndDelete(UUID id) {
		Pubblicazione trova = em.find(Pubblicazione.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Pubblicazione eliminata con successo");
		} else {
			System.out.println("Pubblicazione non trovato");
		}
	}
}
