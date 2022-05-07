package com.br.educaoqualidade.model;

public abstract class Instituicao {
    private Long id;
    private String nome;
    private String telefone;
    private String sigla;
    private String cnpj;
    private String pais;
    private String tipoInstituicao;
    private Endereco endereco;
    private Aluno aluno;
}
