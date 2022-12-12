package com.br.ifam.TodoApp.dto;

import com.br.ifam.TodoApp.model.Categoria;
import com.br.ifam.TodoApp.model.Status;
import com.br.ifam.TodoApp.model.Tarefa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public Tarefa build(Categoria categoria, Status status){
        Tarefa tarefa =new Tarefa();
        tarefa.setTitulo(this.getTitulo());
        tarefa.setDescricao(this.getDescricao());
        tarefa.setDataPrevista(this.dataPrevista);
        tarefa.setDataConclusao(this.dataConclusao);
        tarefa.setCategoria(categoria);
        tarefa.setStatus(status);
        return tarefa;
    }

    @Override
    public String toString() {
        try {
            Date dateP = new SimpleDateFormat("dd/MM/yyyy").parse(dataPrevista);
            Date dateC = new SimpleDateFormat("dd/MM/yyyy").parse(dataConclusao);

            Date date = Calendar.getInstance().getTime();

            String datePtoString = new SimpleDateFormat("dd/MM/yyyy").format(dateP);
            String dateCtoString = new SimpleDateFormat("dd/MM/yyyy").format(dateC);

            setDataPrevista(datePtoString);
            setDataConclusao(dateCtoString);

            return "Tarefa{" +
                    ", titulo='" + titulo + '\'' +
                    ", descricao='" + descricao + '\'' +
                    ", dataPrevista='" + dataPrevista + '\'' +
                    ", dataConclusao='" + dataConclusao + '\'' +
                    ", categoria=" + categoria +
                    ", status=" + status +
                    '}';

        } catch (ParseException e) {
            return "Datas Invalidas";
        }
    }
}
