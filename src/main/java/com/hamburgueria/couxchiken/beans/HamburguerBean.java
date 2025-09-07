/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hamburgueria.couxchiken.beans;

import com.hamburgueria.couxchiken.construtores.Materiais;
import com.hamburgueria.couxchiken.entity.Material;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Named
@Getter
@Setter
@ViewScoped
public class HamburguerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String categoria;
    
    private transient List<Material> hamburgueres;
    private transient List<Material> hamburgueresArtesanais;
    private transient List<Material> bebidas;
    private transient List<Material> cachorrosQuente;
    private transient List<Material> pasteis;
    private transient List<Material> batatas;

    private boolean hamburguer = true;
    private boolean bebida;
    private boolean cachorroQuente;
    private boolean hamburguerArtesanal;
    private boolean pastel;
    private boolean batata;
    
    @Inject
    private transient Materiais materiais;

    @PostConstruct
    public void init() {
        this.hamburgueres = materiais.preencherHamburguer();
        this.hamburgueresArtesanais = materiais.preencherHamburguerArtesanal();
        this.batatas = materiais.preencherBatatas();
        this.cachorrosQuente = materiais.preencherCachorroQuente();
        this.pasteis = materiais.preencherPasteis();
        this.bebidas = materiais.preencherBebidas();
    }

    

    public String aberto() {
        // Define o fuso horário de São Paulo (Brasília)
        ZoneId fusoBrasil = ZoneId.of("America/Sao_Paulo");

        // Pega a hora atual nesse fuso
        LocalTime agora = ZonedDateTime.now(fusoBrasil).toLocalTime();

        LocalTime abertura = LocalTime.of(18, 30);   // 18:30
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
        this.hamburguerArtesanal = false;
        this.pastel = false;
        switch (categoria) {
            case "hamburgueres" -> {
                hamburguer = true;
                bebida = false;
                cachorroQuente = false;
                hamburguerArtesanal = false;
                pastel = false;
                batata = false;
            }
            case "bebidas" -> {
                hamburguer = false;
                bebida = true;
                cachorroQuente = false;
                hamburguerArtesanal = false;
                pastel = false;
                batata = false;
            }
            case "hamburgueresArtesal" -> {
                hamburguer = false;
                bebida = false;
                cachorroQuente = false;
                hamburguerArtesanal = true;
                pastel = false;
                batata = false;
            }
            case "pasteis" -> {
                hamburguer = false;
                bebida = false;
                cachorroQuente = false;
                hamburguerArtesanal = false;
                pastel = true;
                batata = false;
            }
            case "cachorroQuente" -> {
                hamburguer = false;
                bebida = false;
                cachorroQuente = true;
                hamburguerArtesanal = false;
                pastel = false;
                batata = false;
            }
            case "batata" -> {
                hamburguer = false;
                bebida = false;
                cachorroQuente = false;
                hamburguerArtesanal = false;
                pastel = false;
                batata = true;
            }
        }
    }

    public List<Material> getHamburgueres() {
        return hamburgueres;
    }

}
