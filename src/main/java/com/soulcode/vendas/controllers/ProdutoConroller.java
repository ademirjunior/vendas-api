package com.soulcode.vendas.controllers;

import com.soulcode.vendas.dtos.ProdutoDTO;
import com.soulcode.vendas.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoConroller {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public ProdutoDTO save(@RequestBody @Valid ProdutoDTO produtoDTO) {
        return produtoService.save(produtoDTO);
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<ProdutoDTO> findAll() {
        return produtoService.findAll();
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ProdutoDTO findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public ProdutoDTO deleteById(@PathVariable Long id) {
        return produtoService.deleteById(id);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.PUT)
    public ProdutoDTO updateById(@PathVariable Long id, @RequestBody @Valid ProdutoDTO produtoDTO) {
        return produtoService.updateById(id, produtoDTO);
    }
}
