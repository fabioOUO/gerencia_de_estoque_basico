package DIO.gerenciadeestoque.service;


import DIO.gerenciadeestoque.entity.Cfop;
import DIO.gerenciadeestoque.entity.form.CfopForm;

import java.util.List;

public interface ICfopService {
    Cfop create(CfopForm form);
    Cfop get(long codigo);
    List<Cfop> getAll();
    Cfop delete(Cfop cfop);
    Cfop update(long codigo, CfopForm formUpdate);
}
