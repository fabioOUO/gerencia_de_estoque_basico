package DIO.gerenciadeestoque.service;

import DIO.gerenciadeestoque.entity.Cst;
import DIO.gerenciadeestoque.entity.form.FormCst;

import java.util.List;

public interface ServiceCst {
    Cst create(FormCst form);
    Cst get(long codigo);
    List<Cst> getAll();
    Cst delete(Cst cst);
    Cst update(long codigo, FormCst formUpdate);
}
