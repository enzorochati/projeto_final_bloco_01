package produto.controller;

import produto.model.Produto;
import produto.repository.ProdutoRepository;

import java.util.ArrayList;

public class ProdutoController implements ProdutoRepository {

    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    int id = 0;
    @Override
    public void procurarPorNumero(int id) {
        var produto = buscarNaCollection(id);

        if (produto != null)
            produto.visualizar();
        else
            System.out.println("\nA Conta número: " + id + " não foi encontrada!");
    }

    @Override
    public void listarTodas() {
        for (var produto : listaProdutos) {
            produto.visualizar();
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("\nO número do produto: " + produto.getId() + " foi criada com sucesso!");
    }

    @Override
    public void atualizar(Produto produto) {
        var buscaConta = buscarNaCollection(produto.getId());

        if (buscaConta != null) {
            listaProdutos.set(listaProdutos.indexOf(buscaConta), produto);
            System.out.println("\nO id do produto: " + produto.getId() + " foi atualizada com sucesso!");
        }else
            System.out.println("\nO id do produto: " + produto.getId() + " não foi encontrada!");
    }

    @Override
    public void deletar(int id) {
        var produto = buscarNaCollection(id);

        if (produto != null) {
            if(listaProdutos.remove(produto))
                System.out.println("\nA Conta numero: " + id + " foi deletada com sucesso!");
        }else
            System.out.println("\nA Conta numero: " + id + " não foi encontrada!");
    }


    public Produto buscarNaCollection(int id) {
        for (var produto : listaProdutos) {
            if (produto.getId() == id) {
                return produto;
            }
        }

        return null;
    }

    public int gerarId() {

        return ++ id;

    }
}
