
package Dao;

import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Prestito;
import Entities.Utente;

public class PrestitoDao {
	private final EntityManager em;

	public PrestitoDao(EntityManager em) {
		this.em = em;
	}
//metodo save

	public void savePrestito(Prestito ev) {
		EntityTransaction e = em.getTransaction();
		e.begin();
		em.persist(ev);
		e.commit();
		System.out.println("Prestito salvato correttamente");
	}

//metodo find	

	public Prestito findPrestitoById(UUID id) {

		Prestito trova = em.find(Prestito.class, id);
		return trova;
	}

//metodo delete

	public void findPrestitoByIdAndDelete(UUID id) {
		Prestito trova = em.find(Prestito.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Prestito eliminato con successo");
		} else {
			System.out.println("Prestito non trovato");
		}
	}

	public Set<Prestito> trovaPerUtente(Utente utente) {
		TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente = :utente",
				Prestito.class);
		query.setParameter("utente", utente);
		return (Set<Prestito>) query.getResultList();
	}

	public Set<Prestito> trovaScadutiNonRestituiti() {
		TypedQuery<Prestito> query = em.createQuery(
				"SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < CURRENT_DATE",
				Prestito.class);
		return (Set<Prestito>) query.getResultList();
	}

}
