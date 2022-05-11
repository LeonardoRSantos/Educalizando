package com.br.educaoqualidade.model;

import com.br.educaoqualidade.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "comprovacaoRenda")
public class ComprovacaoRenda implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Status status;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "Aluno")
    @MapsId
    private Aluno aluno;

    @NotBlank
    private String estadoCivil;

    @NotBlank
    private String nomePai;

    @NotBlank
    private String nomeMae;

    @NotNull
    @Column(name = "renda_familiar")
    @DecimalMin(value = "0.00")
    private BigDecimal rendaFamiliar;

    private Status statusSituacao;

    public ComprovacaoRenda() {

    }

    public ComprovacaoRenda(Long id, Status status, Aluno aluno, String estadoCivil, String nomePai, String nomeMae,
                            BigDecimal rendaFamiliar, Status statusSituacao) {
        super();
        this.id = id;
        this.status = status;
        this.aluno = aluno;
        this.estadoCivil = estadoCivil;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.rendaFamiliar = rendaFamiliar;
        this.statusSituacao = statusSituacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public BigDecimal getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(BigDecimal rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }

    public Status getStatusSituacao() {
        return statusSituacao;
    }

    public void setStatusSituacao(Status statusSituacao) {
        this.statusSituacao = statusSituacao;
    }
}
