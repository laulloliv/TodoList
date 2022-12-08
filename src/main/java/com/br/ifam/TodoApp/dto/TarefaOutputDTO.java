package com.br.ifam.TodoApp.dto;

import com.br.ifam.TodoApp.model.Categoria;
import com.br.ifam.TodoApp.model.Status;
import com.br.ifam.TodoApp.model.Tarefa;

public class TarefaOutputDTO {

    private Long Id;
    private String titulo;
    private String descricao;
    private String dataPrevista;
    private String dataConclusao;

    private Categoria categoria;

    private Status status;
    public TarefaOutputDTO(Tarefa tarefa) {
       this.setId(tarefa.getId());
       this.setTitulo(tarefa.getTitulo());
       this.setDescricao(tarefa.getDescricao());
       this.setDataPrevista(tarefa.getDataPrevista());
       this.setDataConclusao(tarefa.getDataConclusao());
        this.setCategoria(tarefa.getCategoria());
        this.setStatus(tarefa.getStatus());
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TarefaOutputDTO{" +
                "Id=" + Id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataPrevista='" + dataPrevista + '\'' +
                ", dataConclusao='" + dataConclusao + '\'' +
                ", categoria=" + categoria +
                ", status=" + status +
                '}';
    }
}
