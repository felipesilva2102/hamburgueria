/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hamburgueria.couxchiken.construtores;

/**
 *
 * @author Felipe
 */
public class Material {

    private final String nome;
    private final String imagem;
    private final double preco;
    private final String descricao;

    public Material(String nome, String imagem, double preco, String descricao) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}
