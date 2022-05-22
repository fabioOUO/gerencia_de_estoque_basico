package DIO.gerenciadeestoque.service;

import DIO.gerenciadeestoque.entity.Cliente;
import DIO.gerenciadeestoque.entity.form.ClienteForm;

import java.util.List;

public interface IClienteService {
    Cliente create(ClienteForm form);
    Cliente get(long codigo);
    List<Cliente> getAll();
    Cliente delete(Cliente ncm);
    Cliente update(long codigo, ClienteForm formUpdate);
}
