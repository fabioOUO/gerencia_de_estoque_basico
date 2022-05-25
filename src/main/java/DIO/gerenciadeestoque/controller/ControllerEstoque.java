package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.Estoque;
import DIO.gerenciadeestoque.entity.form.FormEstoque;
import DIO.gerenciadeestoque.service.Implementation.ServiceImplementationEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerEstoque {

    @Autowired
    ServiceImplementationEstoque service;

    final private String nameRouter = "/estoque";

    @PostMapping(nameRouter)
    public Estoque create(@Valid @RequestBody FormEstoque formEstoque) {
        return service.create(formEstoque);
    }

    @GetMapping(nameRouter)
    public List<Estoque> getAll() {
        return service.getAll();
    }

    @GetMapping(nameRouter + "/{id}")
    public Estoque get(@PathVariable long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(nameRouter + "/{id}")
    public Estoque delete(@PathVariable long id) {
        try {
            Estoque estoque = service.get(id);
            service.delete(estoque);
            return estoque;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(nameRouter + "/{id}")
    public Estoque create(@PathVariable long id, @Valid @RequestBody FormEstoque formEstoque) {
        return service.update(id, formEstoque);
    }
}
