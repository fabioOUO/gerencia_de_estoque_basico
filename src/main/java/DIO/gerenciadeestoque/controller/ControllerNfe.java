package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.Nfe;
import DIO.gerenciadeestoque.entity.form.FormNfe;
import DIO.gerenciadeestoque.service.Implementation.ServiceImplementationNfe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerNfe {



    @Autowired
    ServiceImplementationNfe service;

    final private String nameRouter = "/nfe";

    @PostMapping(nameRouter)
    public Nfe create(@Valid @RequestBody FormNfe formNfe) {
        return service.create(formNfe);
    }

    @GetMapping(nameRouter)
    public List<Nfe> gelAll() {
        return service.getAll();
    }

    @GetMapping(nameRouter + "/{id}")
    public Nfe get(@PathVariable long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(nameRouter + "/{id}")
    public Nfe delete(@PathVariable long id) {
        try {
            Nfe nfe = service.get(id);
            service.delete(nfe);
            return nfe;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(nameRouter + "/{id}")
    public Nfe create(@PathVariable long id, @Valid @RequestBody FormNfe formNfe) {
        return service.update(id, formNfe);
    }
}
