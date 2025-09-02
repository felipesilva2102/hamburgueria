/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hamburgueria.couxchiken.beans;

import com.hamburgueria.couxchiken.construtores.Material;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Named
@Getter
@Setter
@ViewScoped
public class HamburguerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient List<Material> hamburgueres;
    private transient List<Material> bebidas;
    private transient List<Material> sobremesas;
    private transient List<Material> pasteis;

    private String categoria;

    private boolean hamburguer = true;
    private boolean bebida;
    private boolean sobremesa;
    private boolean pastel;

    @PostConstruct
    public void init() {
        preencherHamburguer();
        preencherBebidas();
        preencherSobremesas();
        preencherCombos();
    }

    public void preencherHamburguer() {
        hamburgueres = new ArrayList<>();
        hamburgueres.add(new Material("Clássico", "imagens/teste.jpg", 18.90, "teste"));
        hamburgueres.add(new Material("Cheddar Bacon", "imagens/teste.jpg", 22.50, "teste"));
        hamburgueres.add(new Material("Duplo Smash", "imagens/teste.jpg", 25.00, "teste"));
        hamburgueres.add(new Material("Clássico", "imagens/teste.jpg", 18.90, "teste"));
        hamburgueres.add(new Material("Cheddar Bacon", "imagens/teste.jpg", 22.50, "teste"));
        hamburgueres.add(new Material("Duplo Smash", "imagens/teste.jpg", 25.00, "teste"));
        hamburgueres.add(new Material("Veggie", "imagens/teste.jpg", 20.00, "teste"));
        hamburgueres.add(new Material("Clássico", "imagens/teste.jpg", 18.90, "teste"));
        hamburgueres.add(new Material("Cheddar Bacon", "imagens/teste.jpg", 22.50, "teste"));
        hamburgueres.add(new Material("Duplo Smash", "imagens/teste.jpg", 25.00, "teste"));
        hamburgueres.add(new Material("Veggie", "imagens/teste.jpg", 20.00, "teste"));
        hamburgueres.add(new Material("Clássico", "imagens/teste.jpg", 18.90, "teste"));
        hamburgueres.add(new Material("Cheddar Bacon", "imagens/teste.jpg", 22.50, "teste"));
        hamburgueres.add(new Material("Duplo Smash", "imagens/teste.jpg", 25.00, "teste"));
        hamburgueres.add(new Material("Veggie", "imagens/teste.jpg", 20.00, "teste"));
        hamburgueres.add(new Material("Cheddar Bacon", "imagens/teste.jpg", 22.50, "teste"));
        hamburgueres.add(new Material("Duplo Smash", "imagens/teste.jpg", 25.00, "teste"));
        hamburgueres.add(new Material("Veggie", "imagens/teste.jpg", 20.00, "teste"));
        hamburgueres.add(new Material("Clássico", "imagens/teste.jpg", 18.90, "teste"));
        hamburgueres.add(new Material("Cheddar Bacon", "imagens/teste.jpg", 22.50, "teste"));
        hamburgueres.add(new Material("Duplo Smash", "imagens/teste.jpg", 25.00, "teste"));
    }

    public void preencherBebidas() {
        bebidas = new ArrayList<>();
        bebidas.add(new Material("Veggie", "imagens/teste.jpg", 20.00, "teste"));

    }

    public void preencherSobremesas() {
        sobremesas = new ArrayList<>();
        sobremesas.add(new Material("Veggie", "imagens/teste.jpg", 20.00, "teste"));
    }

    public void preencherCombos() {
        pasteis = new ArrayList<>();
        pasteis.add(new Material("Clássico", "imagens/teste.jpg", 18.90, "teste"));
    }

    public String aberto() {
        LocalTime agora = LocalTime.now();

        LocalTime abertura = LocalTime.of(18, 30);  // 18:30
        LocalTime fechamento = LocalTime.of(23, 30); // 23:30

        if (!agora.isBefore(abertura) && agora.isBefore(fechamento)) {
            return "Aberto agora até às 23:30";
        } else {
            return "Fechado, abre às 18:30";
        }
    }

    public void filtrarCategoria() {
        this.hamburguer = true;
        this.bebida = false;
        this.sobremesa = false;
        this.pastel = false;
        switch (categoria) {
            case "hamburgueres" -> {
                hamburguer = true;
                bebida = false;
                sobremesa = false;
                pastel = false;
            }
            case "bebidas" -> {
                hamburguer = false;
                bebida = true;
                sobremesa = false;
                pastel = false;
            }
            case "sobremesas" -> {
                hamburguer = false;
                bebida = false;
                sobremesa = true;
                pastel = false;
            }
            case "pasteis" -> {
                hamburguer = false;
                bebida = false;
                sobremesa = false;
                pastel = true;
            }


        }
    }

    public List<Material> getHamburgueres() {
        return hamburgueres;
    }

}
