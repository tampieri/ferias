package com.tampieri.ferias.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer matricula;
	private String nome;
	private Date dataDeNascimento;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	private Date dataDeContratacao;
	private String fotoDoFuncionario;
	
	@JsonBackReference
	private Equipe equipe;
	
	
	public Funcionario() {
		super();
	}

	public Funcionario(Integer matricula, String nome, Date dataDeNascimento, Endereco endereco, Date dataDeContratacao,
			String fotoDoFuncionario, Equipe equipe) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.endereco = endereco;
		this.dataDeContratacao = dataDeContratacao;
		this.fotoDoFuncionario = fotoDoFuncionario;
		this.equipe = equipe;
	}



	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataDeContratacao() {
		return dataDeContratacao;
	}

	public void setDataDeContratacao(Date dataDeContratacao) {
		this.dataDeContratacao = dataDeContratacao;
	}

	public String getFotoDoFuncionario() {
		return fotoDoFuncionario;
	}

	public void setFotoDoFuncionario(String fotoDoFuncionario) {
		this.fotoDoFuncionario = fotoDoFuncionario;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
