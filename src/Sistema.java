import entities.EletroDomestico;
import entities.Movel;
import entities.Produto;
import exceptions.InvalidCategoryTypeException;
import exceptions.InvalidPriceValueException;
import exceptions.ProductNotCreatedException;

import java.util.ArrayList;
import java.util.Scanner;


public class Sistema {

    private ArrayList<Produto> produtos;

    public Sistema() {
        this.produtos = new ArrayList<Produto>();
    }

    public void cadastrar(Scanner scanner) throws InvalidPriceValueException, InvalidCategoryTypeException {
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o preço do produto: ");
        Double preco = scanner.nextDouble();

        if (preco <= 0) {
            throw new InvalidPriceValueException("Valor de preço inválido!");
        }

        System.out.println("Digite a quantidade em estoque do produto: ");
        Double qnt = scanner.nextDouble();

        System.out.println("Digite o tipo do produto");
        System.out.println("1- Móvel");
        System.out.println("2- Eletro");
        int opcaoTipo = scanner.nextInt();
        scanner.nextLine();

        if(opcaoTipo == 1) {
            cadastrarMovel(scanner, nome, preco, qnt);
        }else if(opcaoTipo == 2) {
            cadastrarEletro(scanner, nome, preco, qnt);
        }else {
            throw new InvalidCategoryTypeException("Valor do tipo do produto inválido!");
        }
    }

    private void cadastrarMovel(Scanner scanner, String nome, double preco, double quantidade) {
        System.out.println("Digite a categoria:");
        String categoria = scanner.nextLine();
        Movel movel = new Movel(nome, preco, quantidade, categoria);
        produtos.add(movel);
    }

    private void cadastrarEletro(Scanner scanner, String nome, double preco, double quantidade) {
        System.out.println("Digite a voltagem:");
        int voltagem = scanner.nextInt();
        EletroDomestico eletro = new EletroDomestico(nome, preco, quantidade, voltagem);
        produtos.add(eletro);
    }

    public void listar() {
        if(produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados");
        }else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public Produto buscar(Scanner scanner) throws ProductNotCreatedException {
        System.out.println("Digite o nome do produto procurado:");
        String nomeProduto = scanner.nextLine();

        for(int i=0; i <produtos.size(); i++) {
            if(produtos.get(i).getNome().equalsIgnoreCase(nomeProduto)) {
                System.out.println("Produto Encontrado");
                System.out.println(produtos.get(i));
                return produtos.get(i);
            }
        }
        throw new ProductNotCreatedException("Produto não cadastrado!");
    }

    public void remover(Scanner scanner) throws ProductNotCreatedException{
        Produto prod = buscar(scanner);
        if(prod == null) {
            System.out.println("Produto não cadastrado!");
        }else {
            produtos.remove(prod);
            System.out.println("Produto removido!");
        }
    }

}

