package com.estagio.supervisionado.oitavo.periodo.monitoramento.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_clinica_dados")
public class Monitoramento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer idClinica;
	private Double temperatura;
	private Double umidade;
	private Date dtHrDados;
	
	public Monitoramento() {
	}

	public Monitoramento(Integer idClinica, Double temperatura, Double umidade) {
		this.idClinica = idClinica;
		this.temperatura = temperatura;
		this.umidade = umidade;
	}

	public Integer getId() {
		return id;
	}

	public Integer getIdClinica() {
		return idClinica;
	}

	public void setIdClinica(Integer idClinica) {
		this.idClinica = idClinica;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Double getUmidade() {
		return umidade;
	}

	public void setUmidade(Double umidade) {
		this.umidade = umidade;
	}

	public Date getDtHrDados() {
		return dtHrDados;
	}
	
}