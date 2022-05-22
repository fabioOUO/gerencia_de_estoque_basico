package DIO.gerenciadeestoque.service.impl;

import DIO.gerenciadeestoque.entity.Ncm;
import DIO.gerenciadeestoque.entity.Produto;
import DIO.gerenciadeestoque.entity.form.ProdutoForm;
import DIO.gerenciadeestoque.repository.NcmRepository;
import DIO.gerenciadeestoque.repository.ProdutoRepository;
import DIO.gerenciadeestoque.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private NcmRepository ncmRepository;

    @Override
    public Produto create(ProdutoForm produtoForm) {
        Produto produto = new Produto();
        Ncm ncm = ncmRepository.getById(produtoForm.getNcmCodigo());

        produto.setNCM(ncm);
        produto.setDescricao(produtoForm.getDescricao());
        produto.setValor(produtoForm.getValor());
        produto.setPesoBruto(produtoForm.getPesoBruto());
        produto.setPesoLiquido(produtoForm.getPesoLiquido());
        produto.setDataAtualizacao(LocalDateTime.now());
        produto.setDataCricao(LocalDateTime.now());

        return produtoRepository.save(produto);
    }

    @Override
    public Produto get(long codigo) {
        return produtoRepository.getById(codigo);
    }

    @Override
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto delete(Produto produto) {
        produtoRepository.delete(produto);
        return produto;
    }

    @Override
    public Produto update(long codigo, ProdutoForm formUpdate) {
        Produto produto = this.get(codigo);
        Ncm ncm = ncmRepository.getById(formUpdate.getNcmCodigo());

        produto.setNCM(ncm);
        produto.setDescricao(formUpdate.getDescricao());
        produto.setValor(formUpdate.getValor());
        produto.setPesoBruto(formUpdate.getPesoBruto());
        produto.setPesoLiquido(formUpdate.getPesoLiquido());
        produto.setDataAtualizacao(LocalDateTime.now());
        produto.setDataCricao(LocalDateTime.now());

        return produtoRepository.save(produto);
    }
}
