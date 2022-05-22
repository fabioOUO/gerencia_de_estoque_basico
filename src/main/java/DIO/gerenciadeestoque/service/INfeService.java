package DIO.gerenciadeestoque.service;


import DIO.gerenciadeestoque.entity.Nfe;
import DIO.gerenciadeestoque.entity.form.NfeForm;

import java.util.List;

public interface INfeService {
    Nfe create(NfeForm form);
    Nfe get(long codigo);
    List<Nfe> getAll();
    Nfe delete(Nfe ncm);
    Nfe update(long codigo, NfeForm formUpdate);
}
