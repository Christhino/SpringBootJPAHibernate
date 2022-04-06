package com.example.api.restfull.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "retrait")

public class Retrait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRetrait;

    @Column(name = "Num_cheque" ,nullable = false)
    private  String Num_cheque;

    @Column(name = "Num_compte",nullable = false)
    private  String Num_compte;

    @Column(name = "Montant_retrait", nullable = false)
    private  String Montant_retrait;

    @Column(name = "Date_retrait" , nullable = false)
    private  int Date_retrait;

    public Retrait () {
        super();
    }

    public Retrait(String num_cheque, String num_compte, String montant_retrait, int date_retrait) {
        Num_cheque = num_cheque;
        Num_compte = num_compte;
        Montant_retrait = montant_retrait;
        Date_retrait = date_retrait;
    }

    public long getIdRetrait() {
        return idRetrait;
    }

    public void setIdRetrait(long idRetrait) {
        this.idRetrait = idRetrait;
    }

    public String getNum_cheque() {
        return Num_cheque;
    }

    public void setNum_cheque(String num_cheque) {
        Num_cheque = num_cheque;
    }

    public String getNum_compte() {
        return Num_compte;
    }

    public void setNum_compte(String num_compte) {
        Num_compte = num_compte;
    }

    public String getMontant_retrait() {
        return Montant_retrait;
    }

    public void setMontant_retrait(String montant_retrait) {
        Montant_retrait = montant_retrait;
    }

    public int getDate_retrait() {
        return Date_retrait;
    }

    public void setDate_retrait(int date_retrait) {
        Date_retrait = date_retrait;
    }

    @Override
    public String toString() {
        return "Retrait{" +
                "idRetrait=" + idRetrait +
                ", Num_cheque='" + Num_cheque + '\'' +
                ", Num_compte='" + Num_compte + '\'' +
                ", Montant_retrait='" + Montant_retrait + '\'' +
                ", Date_retrait=" + Date_retrait +
                '}';
    }
}
