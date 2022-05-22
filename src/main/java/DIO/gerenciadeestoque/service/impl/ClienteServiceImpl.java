package DIO.gerenciadeestoque.service.impl;


import DIO.gerenciadeestoque.entity.Cliente;
import DIO.gerenciadeestoque.entity.form.ClienteForm;
import DIO.gerenciadeestoque.repository.ClienteRepository;
import DIO.gerenciadeestoque.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente create(ClienteForm clienteForm) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteForm.getNome());
        cliente.setEmail(clienteForm.getEmail());
        cliente.setDataAtualizacao(LocalDateTime.now());
        cliente.setDataCricao(LocalDateTime.now());

        return repository.save(cliente);
    }


    @Override
    public List<Cliente> getAll() {
         return repository.findAll();
    }

    @Override
    public Cliente delete(Cliente cliente) {
        repository.delete(cliente);
        return cliente;
    }

    @Override
    public Cliente get(long codigo) {
        return repository.getById(codigo);
    }


    @Override
    public Cliente update(long codigo, ClienteForm formUpdate) {

        Cliente cliente = this.get(codigo);
        cliente.setNome(formUpdate.getNome());
        cliente.setEmail(formUpdate.getEmail());
        cliente.setDataAtualizacao(LocalDateTime.now());

        return repository.save(cliente);
    }
}
