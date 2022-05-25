package DIO.gerenciadeestoque.controller;


import DIO.gerenciadeestoque.entity.Produto;
import DIO.gerenciadeestoque.entity.form.FormProduto;
import DIO.gerenciadeestoque.service.Implementation.ServiceImplementationProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerProduto {


    @Autowired
    private ServiceImplementationProduto service;

    final private String nameRouter = "/produto";

    @PostMapping(nameRouter)
    public Produto create(@Valid @RequestBody FormProduto formProduto) {
        return service.create(formProduto);
    }

    @GetMapping(nameRouter)
    public List<Produto> getAll() {
        return service.getAll();
    }

    @GetMapping(nameRouter + "/{id}")
    public Produto get(@PathVariable long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(nameRouter + "/{id}")
    public Produto delete(@PathVariable long id) {
        try {
            Produto produto = service.get(id);
            service.delete(produto);
            return produto;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(nameRouter + "/{id}")
    public Produto create(@PathVariable long id, @Valid @RequestBody FormProduto formProduto) {
        return service.update(id, formProduto);
    }
}
