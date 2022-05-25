package DIO.gerenciadeestoque.service.Implementation;

import DIO.gerenciadeestoque.entity.Ncm;
import DIO.gerenciadeestoque.entity.Produto;
import DIO.gerenciadeestoque.entity.form.FormProduto;
import DIO.gerenciadeestoque.repository.RepositoryNcm;
import DIO.gerenciadeestoque.repository.RepositoryProduto;
import DIO.gerenciadeestoque.service.ServiceProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ServiceImplementationProduto implements ServiceProduto {

    @Autowired
    private RepositoryProduto repositoryProduto;
    @Autowired
    private RepositoryNcm repositoryNcm;

    @Override
    public Produto create(FormProduto formProduto) {
        Produto produto = new Produto();
        Ncm ncm = repositoryNcm.getById(formProduto.getNcmCodigo());

        produto.setNCM(ncm);
        produto.setDescricao(formProduto.getDescricao());
        produto.setValorUnitario(formProduto.getValorUnitario());
        produto.setPesoBruto(formProduto.getPesoBruto());
        produto.setPesoLiquido(formProduto.getPesoLiquido());
        produto.setDataAtualizacao(LocalDateTime.now());
        produto.setDataCricao(LocalDateTime.now());

        return repositoryProduto.save(produto);
    }

    @Override
    public Produto get(long codigo) {
        return repositoryProduto.getById(codigo);
    }

    @Override
    public List<Produto> getAll() {
        return repositoryProduto.findAll();
    }

    @Override
    public Produto delete(Produto produto) {
        repositoryProduto.delete(produto);
        return produto;
    }

    @Override
    public Produto update(long codigo, FormProduto formUpdate) {
        Produto produto = this.get(codigo);
        Ncm ncm = repositoryNcm.getById(formUpdate.getNcmCodigo());

        produto.setNCM(ncm);
        produto.setDescricao(formUpdate.getDescricao());
        produto.setValorUnitario(formUpdate.getValorUnitario());
        produto.setPesoBruto(formUpdate.getPesoBruto());
        produto.setPesoLiquido(formUpdate.getPesoLiquido());
        produto.setDataAtualizacao(LocalDateTime.now());
        produto.setDataCricao(LocalDateTime.now());

        return repositoryProduto.save(produto);
    }
}
