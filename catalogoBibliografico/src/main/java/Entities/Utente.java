package Entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Utente")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
	@Id
	@GeneratedValue
	private UUID numero_tessera;
	private String nome;
	private String cognome;
	private LocalDate data_di_nascita;

	@OneToMany(mappedBy = "utente")
	private Set<Prestito> prestito;

	public Utente(String nome, String cognome, LocalDate data_di_nascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_di_nascita = data_di_nascita;
	}

	@Override
	public String toString() {
		return "Utente [numero_tessera=" + numero_tessera + ", nome=" + nome + ", cognome=" + cognome
				+ ", data_di_nascita=" + data_di_nascita + "]";
	}

}
