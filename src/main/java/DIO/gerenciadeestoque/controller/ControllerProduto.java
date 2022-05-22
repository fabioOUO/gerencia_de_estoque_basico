package DIO.gerenciadeestoque.controller;


import DIO.gerenciadeestoque.entity.Produto;
import DIO.gerenciadeestoque.entity.form.ProdutoForm;
import DIO.gerenciadeestoque.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerProduto {

    @Autowired
    private ProdutoServiceImpl service;

    @PostMapping("/produto")
    public Produto create(@Valid @RequestBody ProdutoForm produtoForm) {
        return service.create(produtoForm);
    }

    @GetMapping("/produto")
    public List<Produto> getAll() {
        return service.getAll();
    }

    @GetMapping("/produto/{id}")
    public Produto get(@PathVariable long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/produto/{id}")
    public Produto delete(@PathVariable long id) {
        try {
            Produto produto = service.get(id);
            service.delete(produto);
            return produto;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/produto/{id}")
    public Produto create(@PathVariable long id, @Valid @RequestBody ProdutoForm produtoForm) {
        return service.update(id, produtoForm);
    }
}
