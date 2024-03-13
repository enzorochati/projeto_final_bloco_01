package produto.model;

public class Roupa extends Produto {
    private String tamanho;

    public Roupa(int id, String nome, double preco, String tamanho) {
        super(id, nome, preco);
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void visualizar() {
        super.visualizar();
        System.out.println("Tamanho da roupa: " + this.tamanho);
    }
}
