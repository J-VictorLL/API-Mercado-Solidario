package com.mercado_solidario.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Fornecedor {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToOne
	@JoinColumn
	private Endereço endereço;
	
	//@JsonIgnore
	@ManyToMany
  /*  @JoinTable(name = "fornecedor_produto",
        joinColumns = { @JoinColumn(name = "fk_fornecedor") },
        inverseJoinColumns = { @JoinColumn(name = "fk_produto") })*/
    private List<Produto> produtos = new ArrayList<>();
	
}