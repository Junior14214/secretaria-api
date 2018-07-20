package br.com.secretariaadmco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.secretariaadmco.model.Entradas;

@Repository
public interface EntradasRepository extends JpaRepository<Entradas, Integer> {
	
	@Query(value="SELECT * FROM ENTRADAS WHERE DATA BETWEEN ?1 AND ?2", nativeQuery = true)
	public List<Entradas> relatorioEntradas(String data1, String data2);

}
