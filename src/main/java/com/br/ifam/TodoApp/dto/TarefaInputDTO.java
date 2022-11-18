package com.br.ifam.TodoApp.dto;

import com.br.ifam.TodoApp.model.Tarefa;

public class TarefaInputDTO {

    private String titulo;
    private String descricao;
    private String dataPrevista;
    private String dataConclusao;

/*    private String categoria;
    private String status;*/

    public TarefaInputDTO() {
    }

    public TarefaInputDTO(String titulo) {
        this.titulo = titulo;
    }

    public TarefaInputDTO(String titulo, String descricao, String dataPrevista, String dataConclusao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPrevista = dataPrevista;
        this.dataConclusao = dataConclusao;
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

  /*  public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }*/

    public Tarefa build(){
        Tarefa tarefa =new Tarefa();
        tarefa.setTitulo(this.getTitulo());
        tarefa.setDescricao(this.getDescricao());
        tarefa.setDataPrevista(this.dataPrevista);
        tarefa.setDataConclusao(this.dataConclusao);
        return tarefa;
    }

    @Override
    public String toString() {
        return "tarefaInputDTO{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataPrevista='" + dataPrevista + '\'' +
                ", dataConclusao='" + dataConclusao + '\'' +
                '}';
    }
}
