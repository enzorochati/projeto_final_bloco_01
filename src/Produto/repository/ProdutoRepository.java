package produto.repository;

import produto.model.Produto;

public interface ProdutoRepository {

    public void procurarPorNumero(int id);
    public void listarTodas();
    public void cadastrar(Produto produto);
    public void atualizar(Produto produto);
    public void deletar(int id);
}
