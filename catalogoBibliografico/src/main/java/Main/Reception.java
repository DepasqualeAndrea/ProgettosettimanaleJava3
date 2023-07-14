package Main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Dao.PrestitoDao;
import Dao.PubblicazioneDao;
import Dao.UtenteDao;
import Entities.Libro;
import Entities.Prestito;
import Entities.Rivista;
import Entities.Utente;
import Enum.Periodicita;
import Util.JPAutil;

public class Reception {
	private static EntityManagerFactory emf = JPAutil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		// creazione Utente
		Utente utente = new Utente("invakof", "Moscov", LocalDate.of(1999, 10, 03));
		UtenteDao u = new UtenteDao(em);

		Utente utente2 = new Utente("alberto", "Angela", LocalDate.of(1959, 12, 03));
		UtenteDao u2 = new UtenteDao(em);

		// Creazione Libro/Rivista Pubblicazione
		Libro publica = new Libro("Titotlo 1", LocalDate.now(), 350, "Ivan Iasing", "React");
		PubblicazioneDao p = new PubblicazioneDao(em);

		Libro publica1 = new Libro("One Peace red", LocalDate.now().minusDays(200), 150, "Elkirio Ooda", "Anime");
		PubblicazioneDao p1 = new PubblicazioneDao(em);

		Libro publica2 = new Libro("Java manual", LocalDate.now().minusDays(600), 100, "Manuel Centini",
				"JavaDevaloper");
		PubblicazioneDao p2 = new PubblicazioneDao(em);

		Libro publica3 = new Libro("Angular Manual", LocalDate.now().minusDays(600), 200, "Dario del Giudica",
				"FronEnder");
		PubblicazioneDao p3 = new PubblicazioneDao(em);

		Rivista rivista = new Rivista("Focus", LocalDate.now().minusDays(7), 90, Periodicita.SETTIMANALE);
		PubblicazioneDao r = new PubblicazioneDao(em);

		Rivista rivista2 = new Rivista("Panini collection", LocalDate.now().minusDays(30), 600, Periodicita.MENSILE);
		PubblicazioneDao r2 = new PubblicazioneDao(em);

		Rivista rivista3 = new Rivista("Borsa online", LocalDate.now().minusDays(180), 600, Periodicita.SEMESTRALE);
		PubblicazioneDao r3 = new PubblicazioneDao(em);

		// Creazione Prestito
		Prestito pubblicazione = new Prestito(LocalDate.now().minusDays(50), LocalDate.now().minusDays(20),
				LocalDate.now(), utente, rivista);
		PrestitoDao prestito = new PrestitoDao(em);

		Prestito pubblicazione1 = new Prestito(LocalDate.now().minusDays(50), LocalDate.now().minusDays(20),
				LocalDate.now(), utente2, rivista2);
		PrestitoDao prestito1 = new PrestitoDao(em);

		p.savePubblicazione(publica);
		p1.savePubblicazione(publica1);
		p2.savePubblicazione(publica2);
		p3.savePubblicazione(publica3);
		r.savePubblicazione(rivista);
		r2.savePubblicazione(rivista2);
		r3.savePubblicazione(rivista3);

		u.saveUtente(utente);
		u2.saveUtente(utente2);
		prestito.savePrestito(pubblicazione);
		prestito1.savePrestito(pubblicazione1);

		em.close();
		emf.close();
	}

}
