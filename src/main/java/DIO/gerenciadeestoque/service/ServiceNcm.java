package DIO.gerenciadeestoque.service;

import DIO.gerenciadeestoque.entity.Ncm;
import DIO.gerenciadeestoque.entity.form.FormNcm;

import java.util.List;

public interface ServiceNcm {
    Ncm create(FormNcm form);
    Ncm get(long codigo);
    List<Ncm> getAll();
    Ncm delete(Ncm ncm);
    Ncm update(long codigo, FormNcm formUpdate);
}
