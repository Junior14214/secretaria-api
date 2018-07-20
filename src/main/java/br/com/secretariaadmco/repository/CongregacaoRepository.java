package br.com.secretariaadmco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.secretariaadmco.model.Congregacoes;

@Repository
public interface CongregacaoRepository extends JpaRepository<Congregacoes, Integer> {

}
