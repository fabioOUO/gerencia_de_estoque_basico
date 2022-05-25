package DIO.gerenciadeestoque.service.Implementation;

import DIO.gerenciadeestoque.entity.StatusCodeNfe;
import DIO.gerenciadeestoque.entity.form.FormStatusCodeNfe;
import DIO.gerenciadeestoque.repository.RepositoryStatusCodeNfe;
import DIO.gerenciadeestoque.service.ServiceStatusCodeNfe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceImplementationStatusCodeNfe implements ServiceStatusCodeNfe {

    @Autowired
    RepositoryStatusCodeNfe repositoryStatusCodeNfe;

    @Override
    public StatusCodeNfe create(FormStatusCodeNfe form) {

        StatusCodeNfe statusCodeNfe = new StatusCodeNfe();
        statusCodeNfe.setCodigoStatusCode(form.getCodigoStatusCode());
        statusCodeNfe.setDescricao(form.getDescricao());
        statusCodeNfe.setDataAtualizacao(LocalDateTime.now());
        statusCodeNfe.setDataCricao(LocalDateTime.now());

        return repositoryStatusCodeNfe.save(statusCodeNfe);
    }

    @Override
    public StatusCodeNfe get(long codigo) {
        return repositoryStatusCodeNfe.getById(codigo);
    }

    @Override
    public List<StatusCodeNfe> getAll() {
        return repositoryStatusCodeNfe.findAll();
    }

    @Override
    public StatusCodeNfe delete(StatusCodeNfe statusCodeNfe) {
        repositoryStatusCodeNfe.delete(statusCodeNfe);
        return statusCodeNfe;
    }

    @Override
    public StatusCodeNfe update(long codigo, FormStatusCodeNfe formUpdate) {

        StatusCodeNfe statusCodeNfe = this.get(codigo);
        statusCodeNfe.setCodigoStatusCode(formUpdate.getCodigoStatusCode());
        statusCodeNfe.setDescricao(formUpdate.getDescricao());
        statusCodeNfe.setDataAtualizacao(LocalDateTime.now());

        return repositoryStatusCodeNfe.save(statusCodeNfe);
    }
}
