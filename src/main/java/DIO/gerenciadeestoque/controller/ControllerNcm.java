package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.Ncm;
import DIO.gerenciadeestoque.entity.form.NcmForm;
import DIO.gerenciadeestoque.service.impl.NcmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerNcm {

    @Autowired
    private NcmServiceImpl service;

    @GetMapping("/ncm")
    public List<Ncm> getAll() {
        return service.getAll();
    }

    @GetMapping("/ncm/{id}")
    public Ncm get(@PathVariable(value = "id") Long id) {
        try {
            return service.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/ncm/{id}")
    public Ncm delete(@PathVariable long id) {
        try {
            Ncm ncm = service.get(id);
            service.delete(ncm);
            return ncm;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/ncm")
    public Ncm create(@Valid @RequestBody NcmForm ncmForm) {
        return service.create(ncmForm);
    }

    @PutMapping("/ncm/{id}")
    public Ncm update(@PathVariable long id, @Valid @RequestBody NcmForm ncmForm) {
        return service.update(id, ncmForm);
    }
}
