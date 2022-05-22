package DIO.gerenciadeestoque.service;


import DIO.gerenciadeestoque.entity.Produto;
import DIO.gerenciadeestoque.entity.form.ProdutoForm;

import java.util.List;

public interface IProdutoService {
    Produto create(ProdutoForm form);
    Produto get(long codigo);
    List<Produto> getAll();
    Produto delete(Produto ncm);
    Produto update(long codigo, ProdutoForm formUpdate);
}
