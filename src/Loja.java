import exceptions.InvalidCategoryTypeException;
import exceptions.InvalidMainOptionException;
import exceptions.InvalidPriceValueException;
import exceptions.ProductNotCreatedException;

import java.util.Scanner;

class Loja {

    public static void main(String[] args) throws InvalidMainOptionException{

        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Remover");
            System.out.println("5 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        try {
                            sistema.cadastrar(scanner);
                        } catch (InvalidPriceValueException | InvalidCategoryTypeException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        sistema.listar();
                        break;
                    case 3:
                        try {
                            sistema.buscar(scanner);
                        } catch (ProductNotCreatedException e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    case 4:try {
                        sistema.remover(scanner);
                    } catch (ProductNotCreatedException e) {
                        System.out.println(e.getMessage());
                    }
                        break;
                    case 5:
                        break;
                    default:
                        throw new InvalidMainOptionException("Opção inválida, tente novamente!");
                }
            } catch (InvalidMainOptionException e) {
                System.out.println(e.getMessage());
            }
        } while (opcao != 5);

        System.out.println("Saindo do Sistema!");



    }

}
