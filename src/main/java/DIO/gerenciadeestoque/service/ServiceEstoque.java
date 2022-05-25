package DIO.gerenciadeestoque.service;

import DIO.gerenciadeestoque.entity.Estoque;
import DIO.gerenciadeestoque.entity.form.FormEstoque;

import java.util.List;

public interface ServiceEstoque {
    Estoque create(FormEstoque form);
    Estoque get(long codigo);
    List<Estoque> getAll();
    Estoque delete(Estoque ncm);
    Estoque update(long codigo, FormEstoque formUpdate);
}
