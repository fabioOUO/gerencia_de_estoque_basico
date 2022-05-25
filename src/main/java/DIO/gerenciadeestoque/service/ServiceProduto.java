package DIO.gerenciadeestoque.service;


import DIO.gerenciadeestoque.entity.Produto;
import DIO.gerenciadeestoque.entity.form.FormProduto;

import java.util.List;

public interface ServiceProduto {
    Produto create(FormProduto form);
    Produto get(long codigo);
    List<Produto> getAll();
    Produto delete(Produto ncm);
    Produto update(long codigo, FormProduto formUpdate);
}
