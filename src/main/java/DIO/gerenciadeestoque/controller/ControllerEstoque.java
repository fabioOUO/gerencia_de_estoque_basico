package DIO.gerenciadeestoque.controller;

import DIO.gerenciadeestoque.entity.Cliente;
import DIO.gerenciadeestoque.entity.Estoque;
import DIO.gerenciadeestoque.entity.form.EstoqueForm;
import DIO.gerenciadeestoque.service.impl.EstoqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ControllerEstoque {

    @Autowired
    EstoqueServiceImpl service;

    @PostMapping("/estoque")
    public Estoque create(@Valid @RequestBody EstoqueForm estoqueForm){
        return service.create(estoqueForm);
    }

    @GetMapping("/estoque")
    public List<Estoque> getAll (){
        return service.getAll();
    }

    @GetMapping("/estoque/{id}")
    public Estoque get (@PathVariable long id){
        try{
            return service.get(id);
        }catch (Exception e){
            return null;
        }
    }

    @DeleteMapping("/estoque/{id}")
    public Estoque delete (@PathVariable long id){
        try {
            Estoque estoque = service.get(id);
            service.delete(estoque);
            return estoque;
        }catch (Exception e){
            return null;
        }
    }

    @PutMapping("/estoque/{id}")
    public Estoque create(@PathVariable long id , @Valid @RequestBody EstoqueForm estoqueForm){
        return service.update(id, estoqueForm);
    }
}
