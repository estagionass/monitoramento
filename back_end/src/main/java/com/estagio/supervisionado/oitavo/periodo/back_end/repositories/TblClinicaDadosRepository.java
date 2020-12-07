package com.estagio.supervisionado.oitavo.periodo.back_end.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.TblClinicaDados;

// Camada de acesso ao banco de dados
@Repository
public interface TblClinicaDadosRepository extends JpaRepository<TblClinicaDados, Integer> {

	// Receber por parâmetro o id_clinica e somente a data
	@Query(nativeQuery = true, value = "SELECT * FROM monitoramento.tbl_clinica_dados WHERE id_clinica= :id AND dt_hr_dados BETWEEN CONCAT(:dthrini, ' 00:00:00') AND CONCAT(:dthrfim, ' 23:59:59')")
	List<TblClinicaDados> findAverage(@Param("id")Integer id, @Param("dthrini")String dthrini, @Param("dthrfim")String dthrfim);
}