package Dao;

import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Libro;
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

	public Pubblicazione trovaPerIsbn(UUID isbn) {
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT e FROM Elemento e WHERE e.isbn = :isbn",
				Pubblicazione.class);
		query.setParameter("isbn", isbn);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public Set<Pubblicazione> trovaPerAnnoPubblicazione(int anno) {
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT e FROM Elemento e WHERE e.annoPubblicazione = :anno",
				Pubblicazione.class);
		query.setParameter("anno", anno);
		return (Set<Pubblicazione>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Set<Libro> trovaPerAutore(String autore) {
		TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class);
		query.setParameter("autore", autore);
		return (Set<Libro>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Set<Pubblicazione> trovaPerTitolo(String titolo) {
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo",
				Pubblicazione.class);
		query.setParameter("titolo", "%" + titolo + "%");
		return (Set<Pubblicazione>) query.getResultList();
	}

}
