package com.example.api.restfull.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    @Column(name = "Num_compte" ,nullable = false)
    private  String Num_compte;

    @Column(name = "Nom",nullable = false)
    private  String Nom;

    @Column(name = "Prenom", nullable = false)
    private  String Prenom;

    @Column(name = "Solde" , nullable = false)
    private  int Solde;

    @Column(name = "Adress", nullable = false)
    private  String Adress;

    @Column(name = "numero_phone", nullable = false)
    private  String numero_phone;

    public Client (){
        super();
    }

    public Client(String num_compte, String nom, String prenom, int solde, String adress, String numero_phone) {
        Num_compte = num_compte;
        Nom = nom;
        Prenom = prenom;
        Solde = solde;
        Adress = adress;
        this.numero_phone = numero_phone;
    }

    public long getIdClient(){
        return idClient;
    }
    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }
    public String getNum_compte() {
        return Num_compte;
    }
    public String getNom() {
        return Nom;
    }
    public String getPrenom(){
        return Prenom;
    }

    public String getNumero_phone() {
        return numero_phone;
    }

    public String getAdress() {
        return Adress;
    }

    public int getSolde() {
        return Solde;
    }

    public void setNum_compte(String num_compte) {
        Num_compte = num_compte;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public void setSolde(int solde) {
        Solde = solde;
    }

    public void setNumero_phone(String numero_phone) {
        this.numero_phone = numero_phone;
    }

    @Override
    public String toString() {
        return "Client [idClient=" + idClient + "," +
                " num_compte=" + Num_compte + ", " +
                " nom=" + Nom +
                " Prenom=" + Prenom +
                " Adress=" +Adress+
                "numero_phone =" +numero_phone+
                "Solde=" +Solde+ "]";
    }
}
