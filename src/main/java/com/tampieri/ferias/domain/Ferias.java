package com.tampieri.ferias.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ferias implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Funcionario funcionario;
	private Date PeriodoDeFeriasInicial;
	private Date PeriodoDeFeriasFinal;
	
	public Ferias() {
		super();
	}

	public Ferias(Integer id, Funcionario funcionario, Date periodoDeFeriasInicial, Date periodoDeFeriasFinal) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		PeriodoDeFeriasInicial = periodoDeFeriasInicial;
		PeriodoDeFeriasFinal = periodoDeFeriasFinal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getPeriodoDeFeriasInicial() {
		return PeriodoDeFeriasInicial;
	}

	public void setPeriodoDeFeriasInicial(Date periodoDeFeriasInicial) {
		PeriodoDeFeriasInicial = periodoDeFeriasInicial;
	}

	public Date getPeriodoDeFeriasFinal() {
		return PeriodoDeFeriasFinal;
	}

	public void setPeriodoDeFeriasFinal(Date periodoDeFeriasFinal) {
		PeriodoDeFeriasFinal = periodoDeFeriasFinal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Ferias other = (Ferias) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
