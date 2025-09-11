/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hamburgueria.couxchiken.construtores;

import com.hamburgueria.couxchiken.entity.Material;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class Materiais {
    
    private transient List<Material> hamburgueres;
    private transient List<Material> hamburgueresArtesanais;
    private transient List<Material> bebidas;
    private transient List<Material> cachorrosQuente;
    private transient List<Material> pasteis;
    private transient List<Material> batatas;

    public List<Material> preencherHamburguer() {
        hamburgueres = new ArrayList<>();
        hamburgueres.add(new Material("Baurú Tradicional", "hamburguer/bauru.jpg", 08.00, "Carne de hambúrguer, ovo, queijo, presunto, alface, tomate, milho, ervilha e batata palha.", 0));
        hamburgueres.add(new Material("X-Tudo", "hamburguer/x-tudo.jpg", 13.00, "Carne de Hambúrguer, ovo, fatias de bacon, calabresa, queijo, presunto, alface, tomate, milho, ervilha e batata palha.", 0));
        hamburgueres.add(new Material("X-Tudo de Frango", "hamburguer/x-frango.jpg", 13.00, "Carne de hambúrguer de frango, salsicha, ovo, queijo, p resunto, milho, ervilha, alface, tomate e batata palha.", 0));
        hamburgueres.add(new Material("Baguete de Carne de Sol", "hamburguer/baguete-carne.jpg", 16.00, "Carne de sol desfiada, queijo, presunto, milho, ervilha, alface e tomate.", 0));
        hamburgueres.add(new Material("Baguete de Frango", "hamburguer/baguete-frango.jpg", 16.00, "Carne de frango desfiada, queijo, presunto, milho, ervilha, alface e tomate.", 0));
        hamburgueres.add(new Material("Duplo Smash", "hamburguer/smash.jpg", 25.00, "teste", 0));
        hamburgueres.add(new Material("Baguete de Calabresa", "hamburguer/baguete-calabresa.jpg", 16.00, "Calabresa, queijo, presunto, alface, tomate e pão de baguete.", 0));

        return hamburgueres;
    }

    public List<Material> preencherHamburguerArtesanal() {
        hamburgueresArtesanais = new ArrayList<>();
        hamburgueresArtesanais.add(new Material("Hambúrguer Tropical", "hamburguerArtesanal/Tropical.jpg", 15.00, "Carne de hambúrguer artesanal, queijo mussarela, alface, tomate, abacaxi grelhado e pão brioche.", 0));
        hamburgueresArtesanais.add(new Material("Hambúrguer Costela", "hamburguerArtesanal/Costela.jpg", 18.00, "Carne de hambúrger artesanal, carne de costela desfiada, queijo coalho, cebola caramelizada e pão brioche.", 0));
        hamburgueresArtesanais.add(new Material("Hambúrguer Cheddar Bacon", "hamburguerArtesanal/Cheddar-Bacon.jpg", 16.00, "Carne de hambúrguer artesanal, queijo cheddar, fatias de bacon, alface, tomate, cebola caramelizada e pão brioche.", 0));
        hamburgueresArtesanais.add(new Material("Hambúrguer Carne Dupla", "hamburguerArtesanal/Carne-Dupla.jpg", 20.00, "Duas carnes de hambúrguer artesanal, duas fatias de bacon, duas fatias de queijo cheddar, duas porções de cebola empanada e pão brioche.", 0));
        hamburgueresArtesanais.add(new Material("Hambúrguer Escondidinho", "hamburguerArtesanal/Escondidinho.jpg", 16.00, "Carne de hambúrguer artesanal com queijo mussarela dentro, queijo cheddar, fatias de bacon, alface, tomate, cebola caramelizada e pão brioche.", 0));
        hamburgueresArtesanais.add(new Material("Hambúrguer Americano", "hamburguerArtesanal/Americano.jpg", 15.00, "Carne de hambúrguer artesanal, queijo cheddar, picles, alface, tomate e pão brioche.", 0));
        hamburgueresArtesanais.add(new Material("Hambúrguer Tentação", "hamburguerArtesanal/Tentação.jpg", 18.00, "Carne de sol desfiada, ovo, fatias de bacon, queijo mussarea, fatias de picles, alface, tomate, cebola e pão brioche.", 0));
        hamburgueresArtesanais.add(new Material("Hambúrguer 4 Queijos", "hamburguerArtesanal/Queijos.jpg", 18.00, "Duas carnes de hambúrguer artesanal, queijo catupiry, queijo mussarela, queijo gorgonzola, queijo cheddar e pão brioche.", 0));
        hamburgueresArtesanais.add(new Material("Hambúrguer de Frango", "hamburguerArtesanal/Frango.jpg", 13.00, "Carne de frango astesanal, queijo mussarela, alface, tomate, cebola e pão brioche.", 0));
        hamburgueresArtesanais.add(new Material("Baurú Especial", "hamburguerArtesanal/Especial.jpg", 15.00, "Carne de hambúrguer artesanal, ovo, queijo, presunto, requeijão, milho, ervilha, alface, tomate e pão brioche.", 0));

        return hamburgueresArtesanais;
    }

    public List<Material> preencherBebidas() {
        bebidas = new ArrayList<>();
        bebidas.add(new Material("Suco de Mangaba", "bebidas/mangaba.png", 07.00, "teste", 0));
        bebidas.add(new Material("Suco de Graviola", "bebidas/graviola.png", 07.00, "teste", 0));
        bebidas.add(new Material("Suco de Laranja", "bebidas/laranja.png", 07.00, "teste", 0));
        bebidas.add(new Material("Suco de Limão", "bebidas/limao.png", 07.00, "teste", 0));
        bebidas.add(new Material("Suco de Uva", "bebidas/uva.jpg", 07.00, "teste", 0));
        bebidas.add(new Material("Suco de Cajú", "bebidas/caju.jpg", 07.00, "teste", 0));
        bebidas.add(new Material("Suco de Caja", "bebidas/caja.jpg", 07.00, "teste", 0));
        bebidas.add(new Material("Coca Cola Litro", "bebidas/cocacola.jpg", 10.00, "Coca Cola 1 Litro", 0));
        bebidas.add(new Material("Coca Cola Sem Açúcar", "bebidas/cocacolaSemAcucar.jpg", 10.00, "Coca Cola sem açúcar 1 Litro", 0));
        bebidas.add(new Material("Coca Cola Lata", "bebidas/cocalata.jpg", 06.00, "Refrigerante Lata", 0));
        bebidas.add(new Material("Coca Cola Sem Açúcar Lata", "bebidas/cocalatasemacucar.png", 06.00, "Refrigerante Lata", 0));
        bebidas.add(new Material("Guarana Litro", "bebidas/guarana.jpg", 10.00, "Guarana 1 Litro", 0));
        bebidas.add(new Material("Guarana Lata", "bebidas/guaranalata.jpg", 06.00, "Refrigerante Lata", 0));
        bebidas.add(new Material("Fanta Laranja Lata", "bebidas/laranja.jpg", 06.00, "Refrigerante Lata", 0));
        bebidas.add(new Material("Pepsi Litro", "bebidas/pepsi.jpg", 10.00, "Pepsi 1 Litro", 0));
        bebidas.add(new Material("Sprite Lata", "bebidas/sprite.jpg", 06.00, "Refrigerante Lata", 0));

        return bebidas;
    }

    public List<Material> preencherPasteis() {
        pasteis = new ArrayList<>();
        pasteis.add(new Material("Pastel de Frango", "pastel/frango.jpg", 12.00, "Massa de pastel com recheio de frango.", 0));
        pasteis.add(new Material("Pastel de Frango com Catupiry", "pastel/frangoCatupiry.jpg", 12.00, "Massa de pastel com recheio de frango com catupiry.", 0));
        pasteis.add(new Material("Pastel de Calabresa com Mussarela", "pastel/calabresaMussarela.jpg", 12.00, "Massa de pastel com recheio de calabresa com mussarela.", 0));
        pasteis.add(new Material("Pastel de Carne de Sol", "pastel/carneSol.jpg", 12.00, "Massa de pastel com recheio de carne de sol.", 0));
        pasteis.add(new Material("Pastel de Queijo Coalho", "pastel/queijoCoalho.jpg", 12.00, "Massa de pastel com recheio de queijo coalho.", 0));
        pasteis.add(new Material("Pastel de Carne de Sol com Queijo Coalho", "pastel/carneSolCoalho.jpg", 12.00, "Massa de pastel com recheio de carne de sol com queijo coalho.", 0));
        pasteis.add(new Material("Pastel de Queijo Mussarela", "pastel/queijo.jpeg", 12.00, "Massa de pastel com recheio de queijo mussarela.", 0));
        pasteis.add(new Material("Pastel de Queijo e Presunto", "pastel/queijoPresunto.jpg", 12.00, "Massa de pastel com recheio de queijo e presunto.", 0));
        pasteis.add(new Material("Pastel Sertanejo", "pastel/sertanejo.jpg", 13.00, "Massa de pastel com recheio de carne de so, ovo, queijo coalho, milho e ervilha.", 0));

        return pasteis;
    }

    public List<Material> preencherCachorroQuente() {
        cachorrosQuente = new ArrayList<>();
        cachorrosQuente.add(new Material("Cachorro Quente de Carne", "cachorro-quente/carne.jpg", 10.00, "Carne moída, salsicha, milho, ervilha, queijo ralado, tomate, cebola, batata palha, catchup e maionese.", 0));
        cachorrosQuente.add(new Material("Cachorro Quente de Frango", "cachorro-quente/frango.png", 10.00, "Carne de frango, salsicha, milho, ervilha, queijo ralado, alface, tomate, batata palha, catchup e maionese.", 0));

        return cachorrosQuente;
    }

    public List<Material> preencherBatatas() {
        batatas = new ArrayList<>();
        batatas.add(new Material("Batatinha Frita Natural", "batata-frita/natural.jpg", 20.00, "Batata frita", 0));
        batatas.add(new Material("Batatinha Frita Recheada Com Calabresa", "batata-frita/queijoCheddar.jpg", 25.00, "Batata frita com calabresa e cheddar.", 0));
        batatas.add(new Material("Batatinha Frita Recheada Com Bacon", "batata-frita/queijoBacon.jpg", 25.00, "Batata frita com bacon e cheddar.", 0));

        return batatas;
    }
}
