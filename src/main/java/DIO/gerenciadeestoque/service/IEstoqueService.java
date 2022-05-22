package DIO.gerenciadeestoque.service;

import DIO.gerenciadeestoque.entity.Estoque;
import DIO.gerenciadeestoque.entity.form.EstoqueForm;

import java.util.List;

public interface IEstoqueService {
    Estoque create(EstoqueForm form);
    Estoque get(long codigo);
    List<Estoque> getAll();
    Estoque delete(Estoque ncm);
    Estoque update(long codigo, EstoqueForm formUpdate);
}
