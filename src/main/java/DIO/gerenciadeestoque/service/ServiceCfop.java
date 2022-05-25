package DIO.gerenciadeestoque.service;


import DIO.gerenciadeestoque.entity.Cfop;
import DIO.gerenciadeestoque.entity.form.FormCfop;

import java.util.List;

public interface ServiceCfop {
    Cfop create(FormCfop form);
    Cfop get(long codigo);
    List<Cfop> getAll();
    Cfop delete(Cfop cfop);
    Cfop update(long codigo, FormCfop formUpdate);
}
