package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.Ncm;
import DIO.gerenciadeestoque.entity.form.FormNcm;
import DIO.gerenciadeestoque.service.Implementation.ServiceImplementationNcm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerNcm {

    @Autowired
    private ServiceImplementationNcm service;

    final private String nameRouter = "/ncm";

    @GetMapping(nameRouter)
    public List<Ncm> getAll() {
        return service.getAll();
    }

    @GetMapping(nameRouter + "/{id}")
    public Ncm get(@PathVariable(value = "id") Long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(nameRouter + "/{id}")
    public Ncm delete(@PathVariable long id) {
        try {
            Ncm ncm = service.get(id);
            service.delete(ncm);
            return ncm;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(nameRouter)
    public Ncm create(@Valid @RequestBody FormNcm formNcm) {
        return service.create(formNcm);
    }

    @PutMapping(nameRouter + "/{id}")
    public Ncm update(@PathVariable long id, @Valid @RequestBody FormNcm formNcm) {
        return service.update(id, formNcm);
    }
}
