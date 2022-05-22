package DIO.gerenciadeestoque.service;

import DIO.gerenciadeestoque.entity.Ncm;
import DIO.gerenciadeestoque.entity.form.NcmForm;

import java.util.List;

public interface INcmService {
    Ncm create(NcmForm form);
    Ncm get(long codigo);
    List<Ncm> getAll();
    Ncm delete(Ncm ncm);
    Ncm update(long codigo, NcmForm formUpdate);
}
