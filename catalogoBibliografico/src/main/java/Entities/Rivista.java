package Entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import Enum.Periodicita;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rivista extends Pubblicazione {
	private Periodicita periodicita;

	public Rivista(String titolo, LocalDate anno_pubblicazione, long numero_pagine, Periodicita periodicita) {
		super(titolo, anno_pubblicazione, numero_pagine);
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + "]";
	}

}
