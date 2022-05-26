package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.InforTrib;
import DIO.gerenciadeestoque.entity.form.FormInforTrib;
import DIO.gerenciadeestoque.service.Implementation.ServiceImplementationInforTrib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerInforTrib {
    @Autowired
    private ServiceImplementationInforTrib service;

    final private String nameRouter = "/inforTrib";

    @PostMapping(nameRouter)
    public InforTrib create(@Valid @RequestBody FormInforTrib formInforTrib) {
        return service.create(formInforTrib);
    }

    @GetMapping(nameRouter)
    public List<InforTrib> getAll() {
        return service.getAll();
    }

    @GetMapping(nameRouter + "/{id}")
    public InforTrib get(@PathVariable(value = "id") Long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(nameRouter + "/{id}")
    public InforTrib delete(@PathVariable long id) {
        try {
            InforTrib inforTrib = service.get(id);
            service.delete(inforTrib);
            return inforTrib;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(nameRouter + "/{id}")
    public InforTrib update(@PathVariable long id, @Valid @RequestBody FormInforTrib formInforTrib) {
        return service.update(id, formInforTrib);
    }
}
