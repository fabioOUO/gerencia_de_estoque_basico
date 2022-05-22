package DIO.gerenciadeestoque.service.impl;

import DIO.gerenciadeestoque.entity.StatusCodeNfe;
import DIO.gerenciadeestoque.entity.form.StatusCodeNfeForm;
import DIO.gerenciadeestoque.repository.StatusCodeNfeRepository;
import DIO.gerenciadeestoque.service.IStatusCodeNfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatusCodeNfeServiceImpl implements IStatusCodeNfeService {

    @Autowired
    StatusCodeNfeRepository statusCodeNfeRepository;

    @Override
    public StatusCodeNfe create(StatusCodeNfeForm form) {

        StatusCodeNfe statusCodeNfe = new StatusCodeNfe();
        statusCodeNfe.setCodigoStatusCode(form.getCodigoStatusCode());
        statusCodeNfe.setDescricao(form.getDescricao());
        statusCodeNfe.setDataAtualizacao(LocalDateTime.now());
        statusCodeNfe.setDataCricao(LocalDateTime.now());

        return statusCodeNfeRepository.save(statusCodeNfe);
    }

    @Override
    public StatusCodeNfe get(long codigo) {
        return statusCodeNfeRepository.getById(codigo);
    }

    @Override
    public List<StatusCodeNfe> getAll() {
        return statusCodeNfeRepository.findAll();
    }

    @Override
    public StatusCodeNfe delete(StatusCodeNfe statusCodeNfe) {
        statusCodeNfeRepository.delete(statusCodeNfe);
        return statusCodeNfe;
    }

    @Override
    public StatusCodeNfe update(long codigo, StatusCodeNfeForm formUpdate) {

        StatusCodeNfe statusCodeNfe = this.get(codigo);
        statusCodeNfe.setCodigoStatusCode(formUpdate.getCodigoStatusCode());
        statusCodeNfe.setDescricao(formUpdate.getDescricao());
        statusCodeNfe.setDataAtualizacao(LocalDateTime.now());

        return statusCodeNfeRepository.save(statusCodeNfe);
    }
}
