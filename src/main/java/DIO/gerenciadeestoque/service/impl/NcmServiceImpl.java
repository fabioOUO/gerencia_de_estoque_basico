package DIO.gerenciadeestoque.service.impl;

import DIO.gerenciadeestoque.entity.Ncm;
import DIO.gerenciadeestoque.entity.form.NcmForm;
import DIO.gerenciadeestoque.repository.NcmRepository;
import DIO.gerenciadeestoque.service.INcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NcmServiceImpl implements INcmService {

    @Autowired
    private NcmRepository repository;

    @Override
    public Ncm create(NcmForm form) {
        Ncm ncm = new Ncm();
        ncm.setDescricao(form.getDescricao());
        ncm.setDataAtualizacao(LocalDateTime.now());
        ncm.setDataCricao(LocalDateTime.now());

        return repository.save(ncm);
    }


    @Override
    public List<Ncm> getAll() {
        return repository.findAll();
    }

    @Override
    public Ncm delete(Ncm ncm) {
        repository.delete(ncm);
        return ncm;
    }

    @Override
    public Ncm get(long codigo) {
        return repository.getById(codigo);
    }


    @Override
    public Ncm update(long codigo, NcmForm formUpdate) {

        Ncm ncm = this.get(codigo);
        ncm.setDescricao(formUpdate.getDescricao());
        ncm.setDataAtualizacao(LocalDateTime.now());

        return repository.save(ncm);
    }
}
