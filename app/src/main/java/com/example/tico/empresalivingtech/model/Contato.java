package com.example.tico.empresalivingtech.model;

/**
 * Created by Tico on 03/06/2017.
 */
public class Contato {

    private int id;
    private String nome;
    private String email;

    public Contato(){
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
