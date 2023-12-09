package com.soulcode.vendas.services;

import com.soulcode.vendas.dtos.ItemDTO;
import com.soulcode.vendas.models.Item;
import com.soulcode.vendas.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    public List<ItemDTO> findByVenda(Long idVenda) {
        List<Item> itens = this.itemRepository.findByIdVenda(idVenda);
        return itens.stream().map(ItemDTO::new).collect(Collectors.toList());
    }
}
