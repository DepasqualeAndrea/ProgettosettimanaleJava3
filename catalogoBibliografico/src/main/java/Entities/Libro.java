package Entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Libro extends Pubblicazione {
	private String autore;
	private String genere;

	public Libro(String titolo, LocalDate anno_pubblicazione, long numero_pagine, String autore, String genere) {
		super(titolo, anno_pubblicazione, numero_pagine);
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", Genere=" + genere + "]";
	}

}
