package com.betha.agendaempresas.agenda.model;

import com.betha.agendaempresas.agenda.enterprise.AbstractID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Agenda extends AbstractID {

    //add o campo serviço, porem ele não está gravando no banco
    @ManyToOne
    @JoinColumn(name = "I_SERVICO", referencedColumnName = "id")
    private Servico servico;
    @ManyToOne
    @JoinColumn(name = "I_empresa", referencedColumnName = "id")
    private PessoaJuridica empresa;
//    @Column(name = "TITULO")
    private String titulo;
    private String title;
    //alteramos o nome da data inicial para start
    @Column(name = "DATA_INICIAL")
    private LocalDateTime start;
    //alteramos o nome da data final para end
    @Column(name = "DATA_FINAL")
    private LocalDateTime end;
    //@Column(name = "cor")
    private String backgroundColor;

    //aparentemente tá dando erro nos get e set?
//    public Servico getServico() {
//        return servico;
//    }
//
//    public void setServico(Servico servico) {
//        this.servico = servico;
//    }


    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public void setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getTitulo() {
        return title;
    }

    public void setTitulo(String titulo) {
        this.title = titulo;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "servico=" + servico +
                ", titulo='" + titulo + '\'' +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", backgroundColor='" + backgroundColor + '\'' +
                '}';
    }
}
