package DIO.gerenciadeestoque.service.impl;

import DIO.gerenciadeestoque.entity.*;
import DIO.gerenciadeestoque.entity.form.NfeForm;
import DIO.gerenciadeestoque.repository.*;
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

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public Nfe create(NfeForm nfeForm) {

        Nfe nfe = new Nfe();

        try {

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

            //Atualiza estoque
            this.updateEstoque(produto, nfe.getQuantidade());

            return nfeRepository.save(nfe);

        }catch (Exception e){
            //Atualiza estoque
            Produto produto = produtoRepository.getById(nfeForm.getProdutoCodigo());

            this.updateEstoque(produto, (-1 * nfeForm.getQuantidade()));
        }
        return nfe;
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

        Produto produto = nfe.getProduto();
        long quantidade = (-1 * nfe.getQuantidade());

        //Atualiza estoque
        this.updateEstoque(produto, quantidade);

        return nfe;
    }

    @Override
    public Nfe update(long codigo, NfeForm formUpdate) {

        Nfe nfe = this.get(codigo);
        Produto produto = produtoRepository.getById(formUpdate.getProdutoCodigo());
        Cliente cliente = clienteRepository.getById(formUpdate.getClienteCodigo());
        StatusCodeNfe statusCodeNfe = statusCodeNfeRepository.getById(formUpdate.getStatusCodeNfeCodigo());
        long quantidadeDiferenca = formUpdate.getQuantidade() - nfe.getQuantidade();

        nfe.setStatusCodeNfe(statusCodeNfe);
        nfe.setProduto(produto);
        nfe.setCliente(cliente);
        nfe.setChave(formUpdate.getChave());
        nfe.setQuantidade(formUpdate.getQuantidade());
        nfe.setValorTotal(formUpdate.getValorTotal());

        //Atualiza estoque
        if(nfe != null){
            this.updateEstoque(produto, quantidadeDiferenca);
        }

        return nfeRepository.save(nfe);
    }

    public void updateEstoque(Produto produto, long quantidade){
        List<Estoque> estoqueProdutos = estoqueRepository.findAll();
        Estoque estoqueProduto = new Estoque();

        //Se nao existir cria um novo registro de estoque
        estoqueProduto.setProduto(produto);
        estoqueProduto.setQuantidade(quantidade);
        estoqueProduto.setDataAtualizacao(LocalDateTime.now());
        estoqueProduto.setDataCricao(LocalDateTime.now());

        for (Estoque e: estoqueProdutos){
            //Busco produto no estoque
            if(e.getProduto().getCodigo() == produto.getCodigo()){
                //Atualiza quantidade
                long novaQuantidade = e.getQuantidade() + quantidade;
                estoqueProduto = e;

                estoqueProduto.setDataAtualizacao(LocalDateTime.now());
                estoqueProduto.setQuantidade(novaQuantidade);
            }
        }

        estoqueRepository.save(estoqueProduto);
    }
}
