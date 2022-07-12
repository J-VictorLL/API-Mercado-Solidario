package com.mercado_solidario.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercado_solidario.api.entity.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

	List<Grupo> findAllByNomeContains(String nome);
	
	List<Grupo> findAllByPermissaoNomeContains(String nome_permissao);
	
	List<Grupo> findAllByPermissaoDescricaoContains(String permissao_descricao);
	
}
