package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.Cst;
import DIO.gerenciadeestoque.entity.form.FormCst;
import DIO.gerenciadeestoque.service.Implementation.ServiceImplementationCst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerCst {
    @Autowired
    private ServiceImplementationCst service;

    final private String nameRouter = "/cst";

    @PostMapping(nameRouter)
    public Cst create(@Valid @RequestBody FormCst formCst) {
        return service.create(formCst);
    }

    @GetMapping(nameRouter)
    public List<Cst> getAll() {
        return service.getAll();
    }

    @GetMapping(nameRouter + "/{id}")
    public Cst get(@PathVariable(value = "id") Long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(nameRouter + "/{id}")
    public Cst delete(@PathVariable long id) {
        try {
            Cst cst = service.get(id);
            service.delete(cst);
            return cst;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(nameRouter + "/{id}")
    public Cst update(@PathVariable long id, @Valid @RequestBody FormCst formCst) {
        return service.update(id, formCst);
    }
}
