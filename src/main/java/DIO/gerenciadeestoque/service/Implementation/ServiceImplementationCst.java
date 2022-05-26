package DIO.gerenciadeestoque.service.Implementation;

import DIO.gerenciadeestoque.entity.Cst;
import DIO.gerenciadeestoque.entity.form.FormCst;
import DIO.gerenciadeestoque.repository.RepositoryCst;
import DIO.gerenciadeestoque.service.ServiceCst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceImplementationCst implements ServiceCst {

    @Autowired
    RepositoryCst repository;

    @Override
    public Cst create(FormCst form) {
        Cst cst = new Cst();
        cst.setOrigem(form.getOrigem());
        cst.setIcms(form.getIcms());
        cst.setIpi(form.getIpi());
        cst.setPis(form.getPis());
        cst.setCofins(form.getCofins());
        cst.setDataAtualizacao(LocalDateTime.now());
        cst.setDataCricao(LocalDateTime.now());

        return repository.save(cst);
    }

    @Override
    public Cst get(long codigo) {
        return repository.getById(codigo);
    }

    @Override
    public List<Cst> getAll() {
        return repository.findAll();
    }

    @Override
    public Cst delete(Cst cst) {
        repository.delete(cst);
        return cst;
    }

    @Override
    public Cst update(long codigo, FormCst formUpdate) {
        Cst cst = repository.getById(codigo);
        cst.setOrigem(formUpdate.getOrigem());
        cst.setIcms(formUpdate.getIcms());
        cst.setIpi(formUpdate.getIpi());
        cst.setPis(formUpdate.getPis());
        cst.setCofins(formUpdate.getCofins());
        cst.setDataAtualizacao(LocalDateTime.now());
        cst.setDataCricao(LocalDateTime.now());

        return repository.save(cst);
    }
}
