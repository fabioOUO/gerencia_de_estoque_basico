package DIO.gerenciadeestoque.service.impl;

import DIO.gerenciadeestoque.entity.Estoque;
import DIO.gerenciadeestoque.entity.Produto;
import DIO.gerenciadeestoque.entity.form.EstoqueForm;
import DIO.gerenciadeestoque.repository.EstoqueRepository;
import DIO.gerenciadeestoque.repository.ProdutoRepository;
import DIO.gerenciadeestoque.service.IEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EstoqueServiceImpl implements IEstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Estoque create(EstoqueForm estoqueForm) {
        Estoque estoque = new Estoque();
        Produto produto = produtoRepository.getById(estoqueForm.getProdutoCodigo());

        estoque.setProduto(produto);
        estoque.setQuantidade(estoqueForm.getQuantidade());
        estoque.setDataAtualizacao(LocalDateTime.now());
        estoque.setDataCricao(LocalDateTime.now());

        return estoqueRepository.save(estoque);
    }

    @Override
    public Estoque get(long codigo) {
        return estoqueRepository.getById(codigo);
    }

    @Override
    public List<Estoque> getAll() {
        return estoqueRepository.findAll();
    }

    @Override
    public Estoque delete(Estoque estoque) {
        estoqueRepository.delete(estoque);
        return null;
    }

    @Override
    public Estoque update(long codigo, EstoqueForm formUpdate) {
        Estoque estoque = this.get(codigo);
        Produto produto = produtoRepository.getById(formUpdate.getProdutoCodigo());

        estoque.setProduto(produto);
        estoque.setQuantidade(formUpdate.getQuantidade());
        estoque.setDataAtualizacao(LocalDateTime.now());

        return estoqueRepository.save(estoque);
    }
}
