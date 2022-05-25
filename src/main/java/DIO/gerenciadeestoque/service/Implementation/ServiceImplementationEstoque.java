package DIO.gerenciadeestoque.service.Implementation;

import DIO.gerenciadeestoque.entity.Estoque;
import DIO.gerenciadeestoque.entity.Produto;
import DIO.gerenciadeestoque.entity.form.FormEstoque;
import DIO.gerenciadeestoque.repository.RepositoryEstoque;
import DIO.gerenciadeestoque.repository.RepositoryProduto;
import DIO.gerenciadeestoque.service.ServiceEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceImplementationEstoque implements ServiceEstoque {

    @Autowired
    RepositoryEstoque repositoryEstoque;

    @Autowired
    RepositoryProduto repositoryProduto;

    @Override
    public Estoque create(FormEstoque formEstoque) {
        Estoque estoque = new Estoque();
        Produto produto = repositoryProduto.getById(formEstoque.getProdutoCodigo());

        estoque.setProduto(produto);
        estoque.setQuantidade(formEstoque.getQuantidade());
        estoque.setDataAtualizacao(LocalDateTime.now());
        estoque.setDataCricao(LocalDateTime.now());

        return repositoryEstoque.save(estoque);
    }

    @Override
    public Estoque get(long codigo) {
        return repositoryEstoque.getById(codigo);
    }

    @Override
    public List<Estoque> getAll() {
        return repositoryEstoque.findAll();
    }

    @Override
    public Estoque delete(Estoque estoque) {
        repositoryEstoque.delete(estoque);
        return estoque;
    }

    @Override
    public Estoque update(long codigo, FormEstoque formUpdate) {
        Estoque estoque = this.get(codigo);
        Produto produto = repositoryProduto.getById(formUpdate.getProdutoCodigo());

        estoque.setProduto(produto);
        estoque.setQuantidade(formUpdate.getQuantidade());
        estoque.setDataAtualizacao(LocalDateTime.now());

        return repositoryEstoque.save(estoque);
    }
}
