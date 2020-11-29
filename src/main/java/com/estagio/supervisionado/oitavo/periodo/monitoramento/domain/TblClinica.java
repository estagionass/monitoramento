package com.estagio.supervisionado.oitavo.periodo.monitoramento.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_clinica")
public class TblClinica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idClinica;
	private String nomeClinica;
	private String nomeVeterinario;
	
	public TblClinica() {
	}

	public Integer getIdClinica() {
		return idClinica;
	}
	
	public String getnomeClinica() {
		return nomeClinica;
	}

	public String getnomeVeterinario() {
		return nomeVeterinario;
	}

}