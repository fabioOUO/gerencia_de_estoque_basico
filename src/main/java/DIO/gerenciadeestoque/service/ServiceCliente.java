package DIO.gerenciadeestoque.service;

import DIO.gerenciadeestoque.entity.Cliente;
import DIO.gerenciadeestoque.entity.form.FormCliente;

import java.util.List;

public interface ServiceCliente {
    Cliente create(FormCliente form);
    Cliente get(long codigo);
    List<Cliente> getAll();
    Cliente delete(Cliente ncm);
    Cliente update(long codigo, FormCliente formUpdate);
}
