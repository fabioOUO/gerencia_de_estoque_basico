package DIO.gerenciadeestoque.service.impl;

import DIO.gerenciadeestoque.entity.Cliente;
import DIO.gerenciadeestoque.entity.Nfe;
import DIO.gerenciadeestoque.entity.Produto;
import DIO.gerenciadeestoque.entity.StatusCodeNfe;
import DIO.gerenciadeestoque.entity.form.NfeForm;
import DIO.gerenciadeestoque.repository.ClienteRepository;
import DIO.gerenciadeestoque.repository.NfeRepository;
import DIO.gerenciadeestoque.repository.ProdutoRepository;
import DIO.gerenciadeestoque.repository.StatusCodeNfeRepository;
import DIO.gerenciadeestoque.service.INfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class NfeServiceImpl implements INfeService {

    @Autowired
    private NfeRepository nfeRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private StatusCodeNfeRepository statusCodeNfeRepository;
    @Override
    public Nfe create(NfeForm nfeForm) {

        Nfe nfe = new Nfe();

        Produto produto = produtoRepository.getById(nfeForm.getProdutoCodigo());
        Cliente cliente = clienteRepository.getById(nfeForm.getClienteCodigo());
        StatusCodeNfe statusCodeNfe = statusCodeNfeRepository.getById(nfeForm.getStatusCodeNfeCodigo());

        nfe.setStatusCodeNfe(statusCodeNfe);
        nfe.setProduto(produto);
        nfe.setCliente(cliente);
        nfe.setChave(nfeForm.getChave());
        nfe.setQuantidade(nfeForm.getQuantidade());
        nfe.setValorTotal(nfeForm.getValorTotal());
        nfe.setDataEmissao(LocalDateTime.now());

        return nfeRepository.save(nfe);
    }

    @Override
    public Nfe get(long codigo) {
        return nfeRepository.getById(codigo);
    }

    @Override
    public List<Nfe> getAll() {
        return nfeRepository.findAll();
    }

    @Override
    public Nfe delete(Nfe nfe) {
        nfeRepository.delete(nfe);
        return nfe;
    }

    @Override
    public Nfe update(long codigo, NfeForm formUpdate) {

        Nfe nfe = this.get(codigo);
        Produto produto = produtoRepository.getById(formUpdate.getProdutoCodigo());
        Cliente cliente = clienteRepository.getById(formUpdate.getClienteCodigo());
        StatusCodeNfe statusCodeNfe = statusCodeNfeRepository.getById(formUpdate.getStatusCodeNfeCodigo());

        nfe.setStatusCodeNfe(statusCodeNfe);
        nfe.setProduto(produto);
        nfe.setCliente(cliente);
        nfe.setChave(formUpdate.getChave());
        nfe.setQuantidade(formUpdate.getQuantidade());
        nfe.setValorTotal(formUpdate.getValorTotal());

        return nfeRepository.save(nfe);
    }
}
