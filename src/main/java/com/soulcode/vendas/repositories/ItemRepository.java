package com.soulcode.vendas.repositories;

import com.soulcode.vendas.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM Item WHERE venda_id = :idVenda", nativeQuery = true)
    List<Item> findByIdVenda(Long idVenda);
}
