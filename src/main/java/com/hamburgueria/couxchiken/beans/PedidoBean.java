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
import java.io.IOException;
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

    private boolean entrega = true;

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

    public boolean finalizarPedido() {

        if (pedido.getItens().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Atenção", "Nenhum item selecionado no pedido."));
            return false;
        }

        // Nome é sempre obrigatório
        if (pedido.getNome() == null || pedido.getNome().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro", "Informe seu nome para finalizar o pedido."));
            return false;
        }

        // Se for entrega, telefone e endereço são obrigatórios
        if (entrega) {
            if (pedido.getTelefone() == null || pedido.getTelefone().isBlank()
                    || pedido.getEndereco() == null || pedido.getEndereco().isBlank()) {

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Erro", "Para entrega, informe telefone e endereço."));
                return false;
            }
        }

        resumo = new StringBuilder(); 

        DecimalFormat df = new DecimalFormat("0.00");
        double total = pedido.calcularTotal();

        resumo.append("📋 *Resumo do Pedido*\n\n");

        for (Material item : pedido.getItens()) {
            double subtotal = item.getPreco() * item.getQuantidade();
            resumo.append("🍔 ").append(item.getNome())
                    .append(" - Qtd: ").append(item.getQuantidade())
                    .append(" - R$ ").append(df.format(subtotal)).append("\n");
        }
        if(entrega) {
            total = total + 2;
        }
        resumo.append("\n💰 *Total:* R$ ").append(df.format(total)).append("\n\n");
        resumo.append("👤 *Nome:* ").append(pedido.getNome()).append("\n");
        
        if(pedido.getTelefone() != null || !"".equals(pedido.getTelefone()))
            resumo.append("📱 *Telefone:* ").append(pedido.getTelefone()).append("\n");
        
        if(pedido.getEndereco()!= null || !"".equals(pedido.getEndereco()))
            resumo.append("🏠 *Endereço:* ").append(pedido.getEndereco()).append("\n");

        if (pedido.getObservacao() != null && !pedido.getObservacao().isBlank()) {
            resumo.append("📝 *Observações:* ").append(pedido.getObservacao()).append("\n");
        }
        
        if(entrega == true) {
            resumo.append("🚚 *Entrega* ").append("+ R$02,00").append("\n");
        }

        return true;
    }

    public void abrirWhatsapp() throws IOException {

        if (!finalizarPedido()) {
            return; // ❌ não abre WhatsApp
        }

        String url = "https://wa.me/5584994537977?text="
                + URLEncoder.encode(resumo.toString(), StandardCharsets.UTF_8);

        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect(url);
    }

    public Double calcularTotal() {
        double valor = 0;
        if(entrega) valor = 2;
        return pedido.calcularTotal() + valor;
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
