package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.Cliente;
import DIO.gerenciadeestoque.entity.form.FormCliente;
import DIO.gerenciadeestoque.service.Implementation.ServiceImplementationCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerCliente {

    @Autowired
    private ServiceImplementationCliente service;

    final private String nameRouter = "/cliente";

    @PostMapping(nameRouter)
    public Cliente create(@Valid @RequestBody FormCliente formCliente) {
        return service.create(formCliente);
    }

    @GetMapping(nameRouter)
    public List<Cliente> getAll() {
        return service.getAll();
    }

    @GetMapping(nameRouter + "/{id}")
    public Cliente get(@PathVariable(value = "id") Long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(nameRouter + "/{id}")
    public Cliente delete(@PathVariable long id) {
        try {
            Cliente cliente = service.get(id);
            service.delete(cliente);
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(nameRouter + "/{id}")
    public Cliente update(@PathVariable long id, @Valid @RequestBody FormCliente formCliente) {
        return service.update(id, formCliente);
    }

}
