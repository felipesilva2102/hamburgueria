/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hamburgueria.couxchiken.entity;

/**
 *
 * @author Felipe
 */
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, length = 500)
    private String endereco;

    @Column(length = 500)
    private String observacao;
    
    @Column(length = 500)
    private Double total;

    @ElementCollection
    @CollectionTable(name = "pedido_itens", joinColumns = @JoinColumn(name = "pedido_id"))
    private List<Material> itens = new ArrayList<>();

    // Adiciona item ao pedido
    public void adicionarItem(Material material) {
        itens.add(material);
    }

    // Calcula o valor total do pedido
    public double calcularTotal() {
        return total = itens.stream().mapToDouble(item -> item.getPreco() * item.getQuantidade()).sum();
    }
}
