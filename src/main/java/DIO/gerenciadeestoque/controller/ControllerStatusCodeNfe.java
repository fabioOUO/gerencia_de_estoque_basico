package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.StatusCodeNfe;
import DIO.gerenciadeestoque.entity.form.StatusCodeNfeForm;
import DIO.gerenciadeestoque.service.impl.StatusCodeNfeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerStatusCodeNfe {
    @Autowired
    private StatusCodeNfeServiceImpl service;

    final private String nameRouter = "/statusCode";

    @GetMapping(nameRouter)
    public List<StatusCodeNfe> getAll() {
        return service.getAll();
    }

    @GetMapping(nameRouter + "/{id}")
    public StatusCodeNfe get(@PathVariable(value = "id") Long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(nameRouter + "/{id}")
    public StatusCodeNfe delete(@PathVariable long id) {
        try {
            StatusCodeNfe ncm = service.get(id);
            service.delete(ncm);
            return ncm;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(nameRouter)
    public StatusCodeNfe create(@Valid @RequestBody StatusCodeNfeForm statusCodeNfeForm) {
        return service.create(statusCodeNfeForm);
    }

    @PutMapping(nameRouter + "/{id}")
    public StatusCodeNfe update(@PathVariable long id, @Valid @RequestBody StatusCodeNfeForm statusCodeNfeForm) {
        return service.update(id, statusCodeNfeForm);
    }
}
