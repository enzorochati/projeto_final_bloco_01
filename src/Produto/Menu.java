package produto;

import produto.controller.ProdutoController;
import produto.model.Roupa;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {

        Scanner leia = new Scanner(System.in);

        int opcao, id;
        String nomeProduto, tamanhoProduto;
        double precoProduto;

        ProdutoController produtos = new ProdutoController();

        System.out.println("\nCriar Produtos\n");

        Roupa r1 = new Roupa(produtos.gerarId(), "Camisa da Lacoste", 120.00, "M");
        produtos.cadastrar(r1);

        Roupa r2 = new Roupa(produtos.gerarId(), "Camisa da Nike", 82.00, "GG");
        produtos.cadastrar(r2);

        Roupa r3 = new Roupa(produtos.gerarId(), "Tenis da Adidas", 230.00, "32");
        produtos.cadastrar(r3);

        Roupa r4 = new Roupa(produtos.gerarId(), "Calça da Adidas", 56.20, "30");
        produtos.cadastrar(r4);

        produtos.listarTodas();

        while (true) {
            System.out.println("                                                     ");
            System.out.println("                ROUPAS NO PRECINHOOO                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Produto                        ");
            System.out.println("            2 - Listar todos os Produtos             ");
            System.out.println("            3 - Buscar Produto por Id                ");
            System.out.println("            4 - Atualizar Dados do Produto           ");
            System.out.println("            5 - Apagar Produto                       ");
            System.out.println("            6 - Sair                                 ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

            if (opcao == 6) {
                System.out.println("\nROUPAS NO PRECINHOOO - Roupas de qualidade só aqui!");
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:

                    System.out.println("Criar Produtos\n\n");

                    System.out.println("Digite o nome do Produto: ");
                    leia.nextLine();
                    nomeProduto = leia.nextLine();
                    System.out.println("Digite o valor do Produto: ");
                    precoProduto = leia.nextDouble();
                    System.out.println("Digite o tamanho do Produto (P, M, G, GG): ");
                    tamanhoProduto = leia.next().toUpperCase();

                    produtos.cadastrar(new Roupa(produtos.gerarId(), nomeProduto, precoProduto, tamanhoProduto));

                    keyPress(leia);

                    break;

                case 2:

                    System.out.println("Listar todos os Produtos\n\n");

                    produtos.listarTodas();

                    keyPress(leia);

                    break;

                case 3:

                    System.out.println("Buscar Produto por id\n\n");

                    System.out.println("Digite o id do produto: ");
                    id = leia.nextInt();

                    produtos.procurarPorNumero(id);

                    keyPress(leia);

                    break;
                case 4:
                    System.out.println("Atualizar dados do Produto\n\n");

                    System.out.println("Digite o id do Produto: ");
                    id = leia.nextInt();

                    var buscaConta = produtos.buscarNaCollection(id);

                    if (buscaConta != null) {

                        System.out.println("Digite o nome do Produto: ");
                        leia.nextLine();
                        nomeProduto = leia.nextLine();
                        System.out.println("Digite o valor do Produto: ");
                        precoProduto = leia.nextDouble();
                        System.out.println("Digite o tamanho do Produto (P, M, G, GG): ");
                        tamanhoProduto = leia.next().toUpperCase();

                        produtos.atualizar(new Roupa(id, nomeProduto, precoProduto, tamanhoProduto));

                    } else {
                        System.out.println("\nProduto não encontrado!");
                    }

                    keyPress(leia);
                    break;
                case 5:
                    System.out.println("Apagar o Produto\n\n");

                    System.out.println("Digite o id do Produto: ");
                    id = leia.nextInt();

                    produtos.deletar(id);

                    keyPress(leia);
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
                    keyPress(leia);
                    break;
            }
        }
    }

    public static void keyPress(Scanner leia) {

            System.out.println("\n\nPressione Enter para Continuar...");
            leia.nextLine();

    }

}
