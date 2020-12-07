package com.estagio.supervisionado.oitavo.periodo.back_end.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

//Entidade responsável pelos dados da clínica
@Entity
@Table(name = "tbl_clinica_dados")
public class TblClinicaDados implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private Integer idClinica;
	@NotNull
	private Double temperatura;
	@NotNull
	private Double umidade;
	@NotNull
	@Column(insertable = false)
	// Formata a exibição da hora no recebimento do JSON
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private ZonedDateTime dtHrDados;

	public TblClinicaDados() {
	}

	public TblClinicaDados(@NotNull Integer idClinica, @NotNull Double temperatura, @NotNull Double umidade) {
		this.idClinica = idClinica;
		this.temperatura = temperatura;
		this.umidade = umidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ZonedDateTime getDtHrDados() {
		return dtHrDados;
	}

	public void setDtHrDados(ZonedDateTime dtHrDados) {
		this.dtHrDados = dtHrDados;
	}

}
