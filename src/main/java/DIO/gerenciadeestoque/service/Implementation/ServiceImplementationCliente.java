package DIO.gerenciadeestoque.service.Implementation;


import DIO.gerenciadeestoque.entity.Cliente;
import DIO.gerenciadeestoque.entity.form.FormCliente;
import DIO.gerenciadeestoque.repository.RepositoryCliente;
import DIO.gerenciadeestoque.service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceImplementationCliente implements ServiceCliente {

    @Autowired
    private RepositoryCliente repository;

    @Override
    public Cliente create(FormCliente formCliente) {
        Cliente cliente = new Cliente();
        cliente.setNome(formCliente.getNome());
        cliente.setEmail(formCliente.getEmail());
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
    public Cliente update(long codigo, FormCliente formUpdate) {

        Cliente cliente = this.get(codigo);
        cliente.setNome(formUpdate.getNome());
        cliente.setEmail(formUpdate.getEmail());
        cliente.setDataAtualizacao(LocalDateTime.now());

        return repository.save(cliente);
    }
}
