package com.br.ifam.TodoApp.model;

import javax.persistence.*;

@Entity
public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column
    private String descricao;
    @Column
    private String dataPrevista;
    @Column
    private String dataConclusao;
//    @ManyToOne
//    private Categoria categoria;
  //  @ManyToOne
    //private Status status;


    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, String dataPrevista, String dataConclusao) {
        setTitulo(titulo);
        setDescricao(descricao);
        setDataPrevista(dataPrevista);
        setDataConclusao(dataConclusao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

//    public Categoria getCategoria() {
//        return categoria;
//    }

//    public void setCategoria(Categoria categoria) {
//        this.categoria = categoria;
//    }

//    public Status getStatus() {
//        return status;
//    }

//    public void setStatus(Status status) {
//        this.status = status;
//    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataPrevista='" + dataPrevista + '\'' +
                ", dataConclusao='" + dataConclusao + '\'' +
                '}';
    }
}
