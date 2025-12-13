/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hamburgueria.couxchiken.entity;

/**
 *
 * @author Felipe
 */
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Material {

    private String nome;

    private String imagem;

    private double preco;

    private String descricao;

    private int quantidade;

    public Material() {
    }

    public Material(String nome, String imagem, double preco, String descricao, int quantidade) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Material(Material outro) {
        this.nome = outro.nome;
        this.imagem = outro.imagem;
        this.preco = outro.preco;
        this.descricao = outro.descricao;
        this.quantidade = outro.quantidade;
    }

    public Material(String nome, String imagem, double preco, String descricao) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = 0; // inicializa em 0
    }
    
}
