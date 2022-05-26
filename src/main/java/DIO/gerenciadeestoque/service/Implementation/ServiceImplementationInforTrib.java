package DIO.gerenciadeestoque.service.Implementation;

import DIO.gerenciadeestoque.entity.Cfop;
import DIO.gerenciadeestoque.entity.Cst;
import DIO.gerenciadeestoque.entity.InforTrib;
import DIO.gerenciadeestoque.entity.form.FormInforTrib;
import DIO.gerenciadeestoque.repository.RepositoryCfop;
import DIO.gerenciadeestoque.repository.RepositoryCst;
import DIO.gerenciadeestoque.repository.RepositoryInforTrib;
import DIO.gerenciadeestoque.service.ServiceInforTrib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceImplementationInforTrib implements ServiceInforTrib {

    @Autowired
    RepositoryInforTrib repository;

    @Autowired
    RepositoryCst repositoryCst;

    @Autowired
    RepositoryCfop repositoryCfop;

    @Override
    public InforTrib create(FormInforTrib form) {

        InforTrib inforTrib =  new InforTrib();
        Cst cst = repositoryCst.getById(form.getCstCodigo());
        Cfop cfop = repositoryCfop.getById(form.getCfopCodigo());

        inforTrib.setCst(cst);
        inforTrib.setCfop(cfop);
        inforTrib.setDataAtualizacao(LocalDateTime.now());
        inforTrib.setDataCricao(LocalDateTime.now());

        return repository.save(inforTrib);
    }

    @Override
    public InforTrib get(long codigo) {
        return repository.getById(codigo);
    }

    @Override
    public List<InforTrib> getAll() {
        return repository.findAll();
    }

    @Override
    public InforTrib delete(InforTrib inforTrib) {
        repository.delete(inforTrib);
        return inforTrib;
    }

    @Override
    public InforTrib update(long codigo, FormInforTrib formUpdate) {

        InforTrib inforTrib =  repository.getById(codigo);
        Cst cst = repositoryCst.getById(formUpdate.getCstCodigo());
        Cfop cfop = repositoryCfop.getById(formUpdate.getCfopCodigo());

        inforTrib.setCst(cst);
        inforTrib.setCfop(cfop);
        inforTrib.setDataAtualizacao(LocalDateTime.now());

        return repository.save(inforTrib);
    }
}
