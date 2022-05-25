package DIO.gerenciadeestoque.controller;


import DIO.gerenciadeestoque.entity.Cfop;
import DIO.gerenciadeestoque.entity.form.FormCfop;
import DIO.gerenciadeestoque.service.Implementation.ServiceImplementationCfop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerCfop {

    @Autowired
    private ServiceImplementationCfop service;

    final private String nameRouter = "/cfop";

    @PostMapping(nameRouter)
    public Cfop create(@Valid @RequestBody FormCfop formCfop) {
        return service.create(formCfop);
    }

    @GetMapping(nameRouter)
    public List<Cfop> getAll() {
        return service.getAll();
    }

    @GetMapping(nameRouter + "/{id}")
    public Cfop get(@PathVariable(value = "id") Long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(nameRouter + "/{id}")
    public Cfop delete(@PathVariable long id) {
        try {
            Cfop cfop = service.get(id);
            service.delete(cfop);
            return cfop;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(nameRouter + "/{id}")
    public Cfop update(@PathVariable long id, @Valid @RequestBody FormCfop formCfop) {
        return service.update(id, formCfop);
    }
}
