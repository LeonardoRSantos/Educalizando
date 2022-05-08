package com.br.educaoqualidade.model;

import java.io.Serializable;

import com.br.educaoqualidade.model.Instituicao;

public class Universidade extends Instituicao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String nome;
}
