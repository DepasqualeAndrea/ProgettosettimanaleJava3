package Entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Prestito")
@Getter
@Setter
@NoArgsConstructor
public class Prestito {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate data_inizio_prestito;
	private LocalDate dataRestituzionePrevista;
	private LocalDate dataRestituzioneEffettiva;

	@ManyToOne
	@JoinColumn(name = "utente_id", referencedColumnName = "numero_tessera")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "publicazione_id", referencedColumnName = "isbn")
	private Pubblicazione pubblicazione;

	public Prestito(LocalDate data_inizio_prestito, LocalDate dataRestituzionePrevista,
			LocalDate dataRestituzioneEffettiva, Utente utente, Pubblicazione pubblicazione) {
		this.data_inizio_prestito = data_inizio_prestito;
		this.dataRestituzionePrevista = dataRestituzionePrevista;
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
		this.utente = utente;
		this.pubblicazione = pubblicazione;
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", data_inizio_prestito=" + data_inizio_prestito + ", dataRestituzionePrevista="
				+ dataRestituzionePrevista + ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
	}

}
