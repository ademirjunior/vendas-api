package com.soulcode.vendas.services;

import com.soulcode.vendas.dtos.ProdutoDTO;
import com.soulcode.vendas.models.Produto;
import com.soulcode.vendas.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        Produto produto = ProdutoDTO.convert(produtoDTO);
        produto = this.produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public ProdutoDTO findById(Long id) {
        Optional<Produto> resultado = this.produtoRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("O produto não foi encontrado!");
        } else {
            return new ProdutoDTO(resultado.get());
        }
    }

    public ProdutoDTO deleteById(Long id) {
        ProdutoDTO produtoDTO = findById(id);
        this.produtoRepository.deleteById(id);
        return produtoDTO;
    }

    public ProdutoDTO updateById(Long id, ProdutoDTO produtoDTO) {
        this.findById(id);
        Produto produto = ProdutoDTO.convert(produtoDTO);
        produto.setId(id);
        produto = this.produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }
}
