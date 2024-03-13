package produto.model;

public abstract class Produto {

    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void visualizar() {

        System.out.println("\n\n*********************************************************************");
        System.out.println("Dados do Produto:");
        System.out.println("*********************************************************************");
        System.out.println("Número da Produto: " + this.id);
        System.out.println("Nome do Produto: " + this.nome);
        System.out.println("Preço do Produto: " + this.preco);

    }

}