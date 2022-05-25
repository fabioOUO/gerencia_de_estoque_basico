package DIO.gerenciadeestoque.service;


import DIO.gerenciadeestoque.entity.StatusCodeNfe;
import DIO.gerenciadeestoque.entity.form.FormStatusCodeNfe;

import java.util.List;

public interface ServiceStatusCodeNfe {
    StatusCodeNfe create(FormStatusCodeNfe form);
    StatusCodeNfe get(long codigo);
    List<StatusCodeNfe> getAll();
    StatusCodeNfe delete(StatusCodeNfe statusCodeNfe);
    StatusCodeNfe update(long codigo, FormStatusCodeNfe formUpdate);
}
