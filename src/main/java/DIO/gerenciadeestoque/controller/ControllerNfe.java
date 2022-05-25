package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.Nfe;
import DIO.gerenciadeestoque.entity.form.NfeForm;
import DIO.gerenciadeestoque.service.impl.NfeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerNfe {



    @Autowired
    NfeServiceImpl service;

    final private String nameRouter = "/nfe";

    @PostMapping(nameRouter)
    public Nfe create(@Valid @RequestBody NfeForm nfeForm) {
        return service.create(nfeForm);
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
    public Nfe create(@PathVariable long id, @Valid @RequestBody NfeForm nfeForm) {
        return service.update(id, nfeForm);
    }
}
