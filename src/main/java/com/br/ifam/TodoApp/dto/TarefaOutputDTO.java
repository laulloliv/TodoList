package com.br.ifam.TodoApp.dto;

import com.br.ifam.TodoApp.model.Tarefa;

public class TarefaOutputDTO {

    private Long Id;
    private String titulo;
    private String descricao;
    private String dataPrevista;
    private String dataConclusao;

    public TarefaOutputDTO(Tarefa tarefa) {
       this.setId(tarefa.getId());
       this.setTitulo(tarefa.getTitulo());
       this.setDescricao(tarefa.getDescricao());
       this.setDataPrevista(tarefa.getDataPrevista());
       this.setDataConclusao(tarefa.getDataConclusao());
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

    @Override
    public String toString() {
        return "tarefaOutputDTO{" +
                "Id=" + Id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataPrevista='" + dataPrevista + '\'' +
                ", dataConclusao='" + dataConclusao + '\'' +
                '}';
    }
}
