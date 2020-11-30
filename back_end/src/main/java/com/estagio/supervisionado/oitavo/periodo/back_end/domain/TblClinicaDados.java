package com.estagio.supervisionado.oitavo.periodo.back_end.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

// Entidade responsável pelos dados
@Entity
@Table(name="tbl_clinica_dados")
public class TblClinicaDados implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private Integer idClinica;
	@NotNull
	private Double temperatura;
	@NotNull
	private Double umidade;
	// Formata a exibição da hora no envio do JSON
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	// Recebe a data atual do envio em milissegundos e diminui três horas, horário do Brasil
	private Date dtHrDados = new Date(System.currentTimeMillis()-10800000);
	
	
	public TblClinicaDados() {
	}

	public TblClinicaDados(Integer idClinica, Double temperatura, Double umidade) {
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

	public void setDtHrDados(Date dtHrDados) {
		this.dtHrDados = dtHrDados;
	}
	
}