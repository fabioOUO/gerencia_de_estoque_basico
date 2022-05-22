package DIO.gerenciadeestoque.service;


import DIO.gerenciadeestoque.entity.StatusCodeNfe;
import DIO.gerenciadeestoque.entity.form.StatusCodeNfeForm;

import java.util.List;

public interface IStatusCodeNfeService {
    StatusCodeNfe create(StatusCodeNfeForm form);
    StatusCodeNfe get(long codigo);
    List<StatusCodeNfe> getAll();
    StatusCodeNfe delete(StatusCodeNfe statusCodeNfe);
    StatusCodeNfe update(long codigo, StatusCodeNfeForm formUpdate);
}
