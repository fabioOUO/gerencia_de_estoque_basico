package DIO.gerenciadeestoque.service.impl;

import DIO.gerenciadeestoque.entity.Cfop;
import DIO.gerenciadeestoque.entity.form.CfopForm;
import DIO.gerenciadeestoque.repository.CfopRepository;
import DIO.gerenciadeestoque.service.ICfopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CfopServiceImpl implements ICfopService {

    @Autowired
    CfopRepository repository;

    @Override
    public Cfop create(CfopForm form) {
        Cfop cfop =  new Cfop();
        cfop.setCodigoCfop(form.getCodigoCfop());
        cfop.setDescricao(form.getDescricao());
        cfop.setDataAtualizacao(LocalDateTime.now());
        cfop.setDataCricao(LocalDateTime.now());

        return repository.save(cfop);
    }

    @Override
    public Cfop get(long codigo) {
        return repository.getById(codigo);
    }

    @Override
    public List<Cfop> getAll() {
        return repository.findAll();
    }

    @Override
    public Cfop delete(Cfop cfop) {
        repository.delete(cfop);
        return cfop;
    }

    @Override
    public Cfop update(long codigo, CfopForm formUpdate) {

        Cfop cfop =  repository.getById(codigo);
        cfop.setCodigoCfop(formUpdate.getCodigoCfop());
        cfop.setDescricao(formUpdate.getDescricao());
        cfop.setDataAtualizacao(LocalDateTime.now());

        return repository.save(cfop);
    }
}
