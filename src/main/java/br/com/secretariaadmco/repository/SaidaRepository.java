package br.com.secretariaadmco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.secretariaadmco.model.Saidas;

@Repository
public interface SaidaRepository extends JpaRepository<Saidas, Integer> {
	
	@Query(value="SELECT * FROM SAIDAS WHERE DATA BETWEEN ?1 AND ?2", nativeQuery = true)
	public List<Saidas> relatorioMensal(String data1, String data2);

}
