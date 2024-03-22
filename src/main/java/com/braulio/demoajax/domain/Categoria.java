package com.braulio.demoajax.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, unique = true)
    private String titulo;

    @OneToMany(mappedBy =  "categoria")
    private List<Promocao> promocoes;

}
