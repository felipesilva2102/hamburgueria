package com.hamburgueria.couxchiken.beans;

import com.hamburgueria.couxchiken.construtores.Materiais;
import com.hamburgueria.couxchiken.entity.Pedido;
import com.hamburgueria.couxchiken.entity.Material;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Named
@Getter
@Setter
@ViewScoped
public class PedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient Pedido pedido;

    private transient List<Material> hamburgueres;
    private transient List<Material> hamburgueresArtesanais;
    private transient List<Material> bebidas;
    private transient List<Material> cachorrosQuente;
    private transient List<Material> pasteis;
    private transient List<Material> batatas;
    
    StringBuilder resumo = new StringBuilder();

    @Inject
    private transient Materiais materiais;

    @PostConstruct
    public void init() {
        pedido = new Pedido();
        hamburgueres = materiais.preencherHamburguer();
        hamburgueresArtesanais = materiais.preencherHamburguerArtesanal();
        batatas = materiais.preencherBatatas();
        cachorrosQuente = materiais.preencherCachorroQuente();
        pasteis = materiais.preencherPasteis();
        bebidas = materiais.preencherBebidas();
    }

    public void adicionarItem(Material wrapper) {
        if (wrapper.getQuantidade() > 0) {
            Material m = new Material(
                    wrapper.getNome(),
                    wrapper.getImagem(),
                    wrapper.getPreco(),
                    wrapper.getDescricao(),
                    wrapper.getQuantidade()
            );
            pedido.adicionarItem(m);
            wrapper.setQuantidade(0);
        }
    }

    public void finalizarPedido() {
        if (pedido.getItens().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Nenhum item selecionado no pedido."));
            return;
        }
        
        if (pedido.getNome() == null || pedido.getNome().isBlank()
                || pedido.getTelefone() == null || pedido.getTelefone().isBlank()
                || pedido.getEndereco() == null || pedido.getEndereco().isBlank()) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Por favor, preencha seus dados antes de finalizar o pedido."));
            return;
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double total = pedido.calcularTotal();
        
        resumo.append("📋 *Resumo do Pedido*\n\n");

        for (Material item : pedido.getItens()) {
            double subtotal = item.getPreco() * item.getQuantidade();
            resumo.append("🍔 ").append(item.getNome())
                    .append(" - Qtd: ").append(item.getQuantidade())
                    .append(" - R$ ").append(df.format(subtotal)).append("\n");
        }

        resumo.append("\n💰 *Total:* R$ ").append(df.format(total)).append("\n\n");
        resumo.append("👤 Nome: ").append(pedido.getNome()).append("\n");
        resumo.append("📱 Telefone: ").append(pedido.getTelefone()).append("\n");
        resumo.append("🏠 Endereço: ").append(pedido.getEndereco()).append("\n");

        if (pedido.getObservacao() != null && !pedido.getObservacao().isBlank()) {
            resumo.append("📝 Observações: ").append(pedido.getObservacao()).append("\n");
        }

        // Mensagem JSF
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido Finalizado", resumo.toString()));
    }

    public Double calcularTotal() {
        return pedido.calcularTotal();
    }

    public String getMensagemWhatsapp() {
        finalizarPedido(); // garante que resumo foi montado e validado
        try {
            return URLEncoder.encode(resumo.toString(), StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            return "Erro ao gerar mensagem.";
        }
    }

}
