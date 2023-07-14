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
		// creazione persona
		Libro publica = new Libro("Titotlo 1", LocalDate.now(), 350, "Ivan Iasing", "React");
		PubblicazioneDao p = new PubblicazioneDao(em);
		Rivista rivista = new Rivista("Rivista 1", LocalDate.now(), 600, Periodicita.MENSILE);
		PubblicazioneDao r = new PubblicazioneDao(em);

		p.savePubblicazione(publica);
		r.savePubblicazione(rivista);
		Utente utente = new Utente("invakof", "Moscov", LocalDate.of(1999, 10, 03));
		UtenteDao u = new UtenteDao(em);
		u.saveUtente(utente);

		Prestito pubblicazione = new Prestito(LocalDate.now(), LocalDate.now().minusDays(30),
				LocalDate.now().minusDays(35), utente, rivista);
		PrestitoDao prestito = new PrestitoDao(em);
		prestito.savePrestito(pubblicazione);

		em.close();
		emf.close();
	}

}
