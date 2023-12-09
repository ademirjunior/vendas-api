package com.soulcode.vendas.dtos;

import com.soulcode.vendas.models.Item;
import com.soulcode.vendas.models.Produto;
import com.soulcode.vendas.models.Venda;
import jakarta.validation.constraints.NotNull;

public class ItemDTO {

    private Long id;

    @NotNull(message = "O valor deve ser preenchido!")
    private Float valorParcial;

    @NotNull(message = "A quantidade deve ser preenchida!")
    private Integer quantidade;

    private Long idVenda;

    @NotNull(message = "O id do produto deve ser preenchido")
    private Long idProduto;

    public ItemDTO(){
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.valorParcial = item.getValorParcial();
        this.quantidade = item.getQuantidade();
        this.idVenda = item.getVenda().getId();
        this.idProduto = item.getProduto().getId();
    }

    public static Item convert(ItemDTO dto) {
        Item item = new Item();
        item.setId(dto.getId());
        item.setQuantidade(dto.getQuantidade());
        item.setValorParcial(dto.getValorParcial());
        item.setVenda(new Venda(dto.getIdVenda()));
        item.setProduto(new Produto(dto.getIdProduto()));
        return item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(Float valorParcial) {
        this.valorParcial = valorParcial;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
}
