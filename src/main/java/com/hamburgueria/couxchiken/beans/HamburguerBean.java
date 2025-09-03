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
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
    private transient List<Material> hamburgueresArtesanais;
    private transient List<Material> bebidas;
    private transient List<Material> cachorrosQuente;
    private transient List<Material> pasteis;
    private transient List<Material> batatas;

    private String categoria;

    private boolean hamburguer = true;
    private boolean bebida;
    private boolean cachorroQuente;
    private boolean hamburguerArtesanal;
    private boolean pastel;
    private boolean batata;

    @PostConstruct
    public void init() {
        preencherHamburguer();
        preencherHamburguerArtesanal();
        preencherBebidas();
        preencherPasteis();
        preencherCachorroQuente();
        preencherBatatas();
        //redirecionarCardapio();
    }

    public void preencherHamburguer() {
        hamburgueres = new ArrayList<>();
        hamburgueres.add(new Material("Baurú Tradicional", "hamburguer/bauru.jpg", 08.00, "Carne de hambúrguer, ovo, queijo, presunto, alface, tomate, milho, ervilha e batata palha."));
        hamburgueres.add(new Material("X-Tudo", "hamburguer/x-tudo.jpg", 13.00, "Carne de Hambúrguer, ovo, fatias de bacon, calabresa, queijo, presunto, alface, tomate, milho, ervilha e batata palha."));
        hamburgueres.add(new Material("X-Tudo de Frango", "hamburguer/x-frango.jpg", 13.00, "Carne de hambúrguer de frango, salsicha, ovo, queijo, p resunto, milho, ervilha, alface, tomate e batata palha."));
        hamburgueres.add(new Material("Baguete de Carne de Sol", "hamburguer/baguete-carne.jpg", 16.00, "Carne de sol desfiada, queijo, presunto, milho, ervilha, alface e tomate."));
        hamburgueres.add(new Material("Baguete de Frango", "hamburguer/baguete-frango.jpg", 16.00, "Carne de frango desfiada, queijo, presunto, milho, ervilha, alface e tomate."));
        hamburgueres.add(new Material("Duplo Smash", "hamburguer/smash.jpg", 25.00, "teste"));
        hamburgueres.add(new Material("Baguete de Calabresa", "hamburguer/baguete-calabresa.jpg", 16.00, "Calabresa, queijo, presunto, alface, tomate e pão de baguete."));
    }

    public void preencherHamburguerArtesanal() {
        hamburgueresArtesanais = new ArrayList<>();
        hamburgueresArtesanais.add(new Material("Hambúrguer Tropical", "hamburguerArtesanal/Tropical.jpg", 15.00, "Carne de hambúrguer artesanal, queijo mussarela, alface, tomate, abacaxi grelhado e pão brioche."));
        hamburgueresArtesanais.add(new Material("Hambúrguer Costela", "hamburguerArtesanal/Costela.jpg", 18.00, "Carne de hambúrger artesanal, carne de costela desfiada, queijo coalho, cebola caramelizada e pão brioche."));
        hamburgueresArtesanais.add(new Material("Hambúrguer Cheddar Bacon", "hamburguerArtesanal/Cheddar-Bacon.jpg", 16.00, "Carne de hambúrguer artesanal, queijo cheddar, fatias de bacon, alface, tomate, cebola caramelizada e pão brioche."));
        hamburgueresArtesanais.add(new Material("Hambúrguer Carne Dupla", "hamburguerArtesanal/Carne-Dupla.jpg", 20.00, "Duas carnes de hambúrguer artesanal, duas fatias de bacon, duas fatias de queijo cheddar, duas porções de cebola empanada e pão brioche."));
        hamburgueresArtesanais.add(new Material("Hambúrguer Escondidinho", "hamburguerArtesanal/Escondidinho.jpg", 16.00, "Carne de hambúrguer artesanal com queijo mussarela dentro, queijo cheddar, fatias de bacon, alface, tomate, cebola caramelizada e pão brioche."));
        hamburgueresArtesanais.add(new Material("Hambúrguer Americano", "hamburguerArtesanal/Americano.jpg", 15.00, "Carne de hambúrguer artesanal, queijo cheddar, picles, alface, tomate e pão brioche."));
        hamburgueresArtesanais.add(new Material("Hambúrguer Tentação", "hamburguerArtesanal/Tentação.jpg", 18.00, "Carne de sol desfiada, ovo, fatias de bacon, queijo mussarea, fatias de picles, alface, tomate, cebola e pão brioche."));
        hamburgueresArtesanais.add(new Material("Hambúrguer 4 Queijos", "hamburguerArtesanal/Queijos.jpg", 18.00, "Duas carnes de hambúrguer artesanal, queijo catupiry, queijo mussarela, queijo gorgonzola, queijo cheddar e pão brioche."));
        hamburgueresArtesanais.add(new Material("Hambúrguer de Frango", "hamburguerArtesanal/Frango.jpg", 13.00, "Carne de frango astesanal, queijo mussarela, alface, tomate, cebola e pão brioche."));
        hamburgueresArtesanais.add(new Material("Baurú Especial", "hamburguerArtesanal/Especial.jpg", 15.00, "Carne de hambúrguer artesanal, ovo, queijo, presunto, requeijão, milho, ervilha, alface, tomate e pão brioche."));
    }

    public void preencherBebidas() {
        bebidas = new ArrayList<>();
        bebidas.add(new Material("Suco de Mangaba", "bebidas/mangaba.png", 07.00, "teste"));
        bebidas.add(new Material("Suco de Graviola", "bebidas/graviola.png", 07.00, "teste"));
        bebidas.add(new Material("Suco de Laranja", "bebidas/laranja.png", 07.00, "teste"));
        bebidas.add(new Material("Suco de Limão", "bebidas/limao.png", 07.00, "teste"));
        bebidas.add(new Material("Suco de Uva", "bebidas/uva.jpg", 07.00, "teste"));
        bebidas.add(new Material("Suco de Cajú", "bebidas/caju.jpg", 07.00, "teste"));
        bebidas.add(new Material("Suco de Caja", "bebidas/caja.jpg", 07.00, "teste"));
    }

    public void preencherPasteis() {
        pasteis = new ArrayList<>();
        pasteis.add(new Material("Pastel de Frango", "pastel/frango.jpg", 12.00, "Massa de pastel com recheio de frango."));
        pasteis.add(new Material("Pastel de Frango com Catupiry", "pastel/frangoCatupiry.jpg", 12.00, "Massa de pastel com recheio de frango com catupiry."));
        pasteis.add(new Material("Pastel de Calabresa com Mussarela", "pastel/calabresaMussarela.jpg", 12.00, "Massa de pastel com recheio de calabresa com mussarela."));
        pasteis.add(new Material("Pastel de Carne de Sol", "pastel/carneSol.jpg", 12.00, "Massa de pastel com recheio de carne de sol."));
        pasteis.add(new Material("Pastel de Queijo Coalho", "pastel/queijoCoalho.jpg", 12.00, "Massa de pastel com recheio de queijo coalho."));
        pasteis.add(new Material("Pastel de Carne de Sol com Queijo Coalho", "pastel/carneSolCoalho.jpg", 12.00, "Massa de pastel com recheio de carne de sol com queijo coalho."));
        pasteis.add(new Material("Pastel de Queijo Mussarela", "pastel/queijo.jpeg", 12.00, "Massa de pastel com recheio de queijo mussarela."));
        pasteis.add(new Material("Pastel de Queijo e Presunto", "pastel/queijoPresunto.jpg", 12.00, "Massa de pastel com recheio de queijo e presunto."));
        pasteis.add(new Material("Pastel Sertanejo", "pastel/sertanejo.jpg", 12.00, "Massa de pastel com recheio de carne de so, ovo, queijo coalho, milho e ervilha."));
    }

    public void preencherCachorroQuente() {
        cachorrosQuente = new ArrayList<>();
        cachorrosQuente.add(new Material("Cachorro Quente de Carne", "cachorro-quente/carne.jpg", 10.00, "Carne moída, salsicha, milho, ervilha, queijo ralado, tomate, cebola, batata palha, catchup e maionese."));
        cachorrosQuente.add(new Material("Cachorro Quente de Frango", "cachorro-quente/frango.png", 10.00, "Carne de frango, salsicha, milho, ervilha, queijo ralado, alface, tomate, batata palha, catchup e maionese."));
    }

    public void preencherBatatas() {
        batatas = new ArrayList<>();
        batatas.add(new Material("Batatinha Frita Natural", "batata-frita/natural.jpg", 20.00, "Batata frita"));
        batatas.add(new Material("Batatinha Frita Recheada", "batata-frita/queijoCheddar.jpg", 25.00, "Batata frita com calabresa e cheddar."));
        batatas.add(new Material("Batatinha Frita Recheada", "batata-frita/queijoBacon.jpg", 25.00, "Batata frita com bacon e cheddar."));

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

//    public String redirecionarCardapio() {
//        return "cardapio.xhtml?faces-redirect=true";
//    }

}
