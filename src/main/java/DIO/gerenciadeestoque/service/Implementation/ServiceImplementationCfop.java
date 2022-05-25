package DIO.gerenciadeestoque.service.Implementation;

import DIO.gerenciadeestoque.entity.Cfop;
import DIO.gerenciadeestoque.entity.form.FormCfop;
import DIO.gerenciadeestoque.repository.RepositoryCfop;
import DIO.gerenciadeestoque.service.ServiceCfop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceImplementationCfop implements ServiceCfop {

    @Autowired
    RepositoryCfop repository;

    @Override
    public Cfop create(FormCfop form) {
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
    public Cfop update(long codigo, FormCfop formUpdate) {

        Cfop cfop =  repository.getById(codigo);
        cfop.setCodigoCfop(formUpdate.getCodigoCfop());
        cfop.setDescricao(formUpdate.getDescricao());
        cfop.setDataAtualizacao(LocalDateTime.now());

        return repository.save(cfop);
    }
}
