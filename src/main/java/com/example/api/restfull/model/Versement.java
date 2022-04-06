package com.example.api.restfull.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "versement")

public class Versement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVersement;

    @Column(name = "Montant_Versement",nullable = false)
    private  Integer Montant_Versement;

    @Column(name = "dateVersement", nullable = false)
    private String dateVersement;

    @Column(name = "client", nullable = false)
    private  String client;


    public long getIdVersement() {
        return idVersement;
    }

    public void setIdVersement(long idVersement) {
        this.idVersement = idVersement;
    }

    public Integer getMontant_Versement() {
        return Montant_Versement;
    }

    public String getClient() {
        return client;
    }

    public String getDateVersement() {
        return dateVersement;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setDateVersement(String dateVersement) {
        this.dateVersement = dateVersement;
    }

    public void setMontant_Versement(Integer montant_Versement) {
        Montant_Versement = montant_Versement;
    }

    @Override
    public String toString() {
        return "Versement{" +
                "idVersement=" + idVersement +
                ", Montant_Versement=" + Montant_Versement +
                ", dateVersement='" + dateVersement + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}











































































































