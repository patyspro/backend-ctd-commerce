package com.ctd.commerce.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 4, max = 50)
    private String titulo;

    @NotNull
    @DecimalMin(value = "0")
    private Double preco;

    @NotNull
    @Size(min = 5, max = 255)
    private String descricao;

    @NotNull
    @Size(min = 10, max = 255)
    private String image;


<<<<<<< HEAD
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
=======
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
>>>>>>> a9ca61d76086e247e9fed9e03a100b9de1ccd123
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
