package com.estagio.supervisionado.oitavo.periodo.back_end.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "vw_tbl_clinica_dados")
public class VwTblClinicaDados implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomeClinica;
	private String nomeVeterinario;
	private Double temperatura;
	private Double umidade;
	// Formata a exibição da hora no recebimento do JSON
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private ZonedDateTime dtHrDados;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeClinica() {
		return nomeClinica;
	}
	public void setNomeClinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;
	}
	public String getNomeVeterinario() {
		return nomeVeterinario;
	}
	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
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
