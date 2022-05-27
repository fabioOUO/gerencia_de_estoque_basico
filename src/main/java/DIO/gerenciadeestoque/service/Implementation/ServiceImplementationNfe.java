package DIO.gerenciadeestoque.service.Implementation;

import DIO.gerenciadeestoque.entity.*;
import DIO.gerenciadeestoque.entity.form.FormNfe;
import DIO.gerenciadeestoque.repository.*;
import DIO.gerenciadeestoque.service.ServiceNfe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ServiceImplementationNfe implements ServiceNfe {

    @Autowired
    private RepositoryNfe repositoryNfe;

    @Autowired
    private RepositoryProduto repositoryProduto;

    @Autowired
    private RepositoryCliente repositoryCliente;

    @Autowired
    private RepositoryStatusCodeNfe repositoryStatusCodeNfe;

    @Autowired
    private RepositoryEstoque repositoryEstoque;

    @Autowired
    RepositoryInforTrib repositoryInforTrib;

    @Override
    public Nfe create(FormNfe formNfe) {

        Nfe nfe = new Nfe();

        try {

            Produto produto = repositoryProduto.getById(formNfe.getProdutoCodigo());
            Cliente cliente = repositoryCliente.getById(formNfe.getClienteCodigo());
            InforTrib inforTrib = repositoryInforTrib.getById(formNfe.getInforTribCodigo());
            StatusCodeNfe statusCodeNfe = repositoryStatusCodeNfe.getById(formNfe.getStatusCodeNfeCodigo());

            nfe.setStatusCodeNfe(statusCodeNfe);
            nfe.setProduto(produto);
            nfe.setCliente(cliente);
            nfe.setInforTrib(inforTrib);
            nfe.setChave(formNfe.getChave());
            nfe.setQuantidade(formNfe.getQuantidade());
            nfe.setValorTotal(formNfe.getValorTotal());
            nfe.setDataEmissao(LocalDateTime.now());

            //Atualiza estoque
            this.updateEstoque(produto, nfe.getQuantidade());

            return repositoryNfe.save(nfe);

        }catch (Exception e){
            //Atualiza estoque
            Produto produto = repositoryProduto.getById(formNfe.getProdutoCodigo());

            this.updateEstoque(produto, (-1 * formNfe.getQuantidade()));
        }
        return nfe;
    }

    @Override
    public Nfe get(long codigo) {
        return repositoryNfe.getById(codigo);
    }

    @Override
    public List<Nfe> getAll() {
        return repositoryNfe.findAll();
    }

    @Override
    public Nfe delete(Nfe nfe) {

        repositoryNfe.delete(nfe);

        Produto produto = nfe.getProduto();
        long quantidade = (-1 * nfe.getQuantidade());

        //Atualiza estoque
        this.updateEstoque(produto, quantidade);

        return nfe;
    }

    @Override
    public Nfe update(long codigo, FormNfe formUpdate) {

        Nfe nfe = this.get(codigo);
        Produto produto = repositoryProduto.getById(formUpdate.getProdutoCodigo());
        Cliente cliente = repositoryCliente.getById(formUpdate.getClienteCodigo());
        InforTrib inforTrib = repositoryInforTrib.getById(formUpdate.getInforTribCodigo());
        StatusCodeNfe statusCodeNfe = repositoryStatusCodeNfe.getById(formUpdate.getStatusCodeNfeCodigo());
        long quantidadeDiferenca = formUpdate.getQuantidade() - nfe.getQuantidade();

        nfe.setStatusCodeNfe(statusCodeNfe);
        nfe.setProduto(produto);
        nfe.setCliente(cliente);
        nfe.setInforTrib(inforTrib);
        nfe.setChave(formUpdate.getChave());
        nfe.setQuantidade(formUpdate.getQuantidade());
        nfe.setValorTotal(formUpdate.getValorTotal());

        //Atualiza estoque
        if(nfe != null){
            this.updateEstoque(produto, quantidadeDiferenca);
        }

        return repositoryNfe.save(nfe);
    }

    public void updateEstoque(Produto produto, long quantidade){
        List<Estoque> estoqueProdutos = repositoryEstoque.findAll();
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

        repositoryEstoque.save(estoqueProduto);
    }
}
