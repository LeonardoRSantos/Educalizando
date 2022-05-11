package com.br.educaoqualidade.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "oferta")
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO:Analisar melhor a relação e as estruturas de dados das coleções
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Tecnico instituicaoTecnicos;

    //TODO:Analisar melhor a relação e as estruturas de dados das coleções
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Profissional instituicaoProfissionalizantes;

    //TODO:Analisar melhor a relação e as estruturas de dados das coleções
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Universidade instituicaoUniversidades;

//    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
//    private Instant endMoment;
//
//    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
//    private Instant startMoment;

    @ManyToOne
    @JoinColumn(name = "curso")
    private Curso curso;

    public Oferta() {
    }

    public Oferta(Long id, Tecnico intituicaoTecnicos, Profissional intituicaoProfissionalizantes,
                  Universidade intituicaoUniversidades, Instant endMoment, Instant startMoment, Curso curso) {
        super();
        this.id = id;
        this.instituicaoTecnicos = intituicaoTecnicos;
        this.instituicaoProfissionalizantes = intituicaoProfissionalizantes;
        this.instituicaoUniversidades = intituicaoUniversidades;
//        this.endMoment = endMoment;
////        this.startMoment = startMoment;
        this.curso = curso;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tecnico getInstituicaoTecnicos() {
        return instituicaoTecnicos;
    }

    public void setInstituicaoTecnicos(Tecnico intituicaoTecnicos) {
        this.instituicaoTecnicos = intituicaoTecnicos;
    }

    public Profissional getInstituicaoProfissionalizantes() {
        return instituicaoProfissionalizantes;
    }

    public void setInstituicaoProfissionalizantes(Profissional intituicaoProfissionalizantes) {
        this.instituicaoProfissionalizantes = intituicaoProfissionalizantes;
    }

    public Universidade getInstituicaoUniversidades() {
        return instituicaoUniversidades;
    }

    public void setInstituicaoUniversidades(Universidade intituicaoUniversidades) {
        this.instituicaoUniversidades = intituicaoUniversidades;
    }

//    public Instant getEndMoment() {
//        return endMoment;
//    }
//
//    public void setEndMoment(Instant endMoment) {
//        this.endMoment = endMoment;
//    }
//
//    public Instant getStartMoment() {
//        return startMoment;
//    }
//
//    public void setStartMoment(Instant startMoment) {
//        this.startMoment = startMoment;
//    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Oferta other = (Oferta) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
