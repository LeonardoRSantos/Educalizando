package com.br.educaoqualidade.model;

import com.br.educaoqualidade.model.Instituicao;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_univer")
@DiscriminatorValue(value = "U")
public class Universidade extends Instituicao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<@NotEmpty Oferta> ofertas = new LinkedHashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Set<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOferta(Set<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
}
