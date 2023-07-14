package Entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pubblicazione")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pubblicazione {
	@Id
	@GeneratedValue
	private UUID isbn;
	private String Titolo;
	private LocalDate Anno_pubblicazione;
	private long numero_pagine;

	@OneToMany(mappedBy = "pubblicazione")
	private Set<Prestito> prestito;

	public Pubblicazione(String titolo, LocalDate anno_pubblicazione, long numero_pagine) {
		super();
		Titolo = titolo;
		Anno_pubblicazione = anno_pubblicazione;
		this.numero_pagine = numero_pagine;
	}

	@Override
	public String toString() {
		return "Pubblicazione [isbn=" + isbn + ", Titolo=" + Titolo + ", Anno_pubblicazione=" + Anno_pubblicazione
				+ ", numero_pagine=" + numero_pagine + "]";
	}

}
