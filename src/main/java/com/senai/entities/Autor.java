package com.senai.entities;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Autor")
public class Autor {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idAutor;
	
	private String nome;
	
	private String pais;

	public Autor(Long idAutor, String nome, String pais) {
		super();
		this.idAutor = idAutor;
		this.nome = nome;
		this.pais = pais;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="livro",
				joinColumns= @JoinColumn(name="idAutor"),
				inverseJoinColumns= @JoinColumn(name="idCategoria"))
	private List<Categoria> categoria;

}
