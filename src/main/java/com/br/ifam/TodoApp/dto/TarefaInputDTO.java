package com.br.ifam.TodoApp.dto;

import com.br.ifam.TodoApp.model.Categoria;
import com.br.ifam.TodoApp.model.Status;
import com.br.ifam.TodoApp.model.Tarefa;

import java.util.Calendar;

public class TarefaInputDTO {

    private String titulo;
    private String descricao;
    private String dataPrevista;
    private String dataConclusao;

    private Categoria categoria;
    private Status status;

    public TarefaInputDTO() {
    }

    public TarefaInputDTO(String titulo) {
        this.titulo = titulo;
    }

    public TarefaInputDTO(String titulo, String descricao, String dataPrevista, String dataConclusao, Categoria categoria, Status status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPrevista = dataPrevista;
        this.dataConclusao = dataConclusao;
        this.categoria = categoria;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public Tarefa build(){
        Tarefa tarefa =new Tarefa();
        tarefa.setTitulo(this.getTitulo());
        tarefa.setDescricao(this.getDescricao());
        tarefa.setDataPrevista(this.dataPrevista);
        tarefa.setDataConclusao(this.dataConclusao);
        tarefa.setCategoria(this.categoria);
        tarefa.setStatus(this.status);
        return tarefa;
    }

    @Override
    public String toString() {
        return "TarefaInputDTO{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataPrevista='" + dataPrevista + '\'' +
                ", dataConclusao='" + dataConclusao + '\'' +
                ", categoria=" + categoria +
                ", status=" + status +
                '}';
    }
}
