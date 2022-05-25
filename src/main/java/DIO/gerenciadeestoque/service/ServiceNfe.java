package DIO.gerenciadeestoque.service;


import DIO.gerenciadeestoque.entity.Nfe;
import DIO.gerenciadeestoque.entity.form.FormNfe;

import java.util.List;

public interface ServiceNfe {
    Nfe create(FormNfe form);
    Nfe get(long codigo);
    List<Nfe> getAll();
    Nfe delete(Nfe ncm);
    Nfe update(long codigo, FormNfe formUpdate);
}
