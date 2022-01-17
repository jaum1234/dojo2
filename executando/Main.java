package src.dojo2.executando;

import src.dojo2.Aluguel;
import src.dojo2.Biblioteca;
import src.dojo2.Cliente;

import java.util.Scanner;

public class Main
{
    private static int escolha;
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo a Biblioteca! ");
        System.out.println("\n");
        System.out.println("1. Cliente");
        System.out.println("2. Livro");
        System.out.println("3. Locaçao");


        int escolha;

        while(true) {
            escolha = scanner.nextInt();

            if (escolha >= 1 && escolha <= 3) {
                break;
            }

            System.out.println("Digite novamente. Lembre-se, o número deve ser sentre 1 e 3. :)");
        }

        if (escolha == 1) {
            menuCliente();
        } else if (escolha == 2) {
            menuLivro();
        } else {
            menuLocacao();
        }
    }

    public static void menuCliente() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Remover cliente");
        System.out.println("3. Listar clientes");

        while(true) {
            escolha = scanner.nextInt();

            if (escolha >= 1 && escolha <= 3) {
                break;
            }

            System.out.println("Digite novamente. Lembre-se, o número deve ser sentre 1 e 3. :)");
        }

        if (escolha == 1) {
            cadastrarCliente();
        } else if (escolha == 2) {
            //removerCliente();
        } else {
            //listarClientes();
        }

    }

    public static void cadastrarCliente()
    {
        while (true) {
            try {
                biblioteca.cadastrarCliente();
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }

            break;
        }
    }

    public static void menuLivro() throws Exception
    {
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Remover livro");
        System.out.println("3. Listar livros");
    }

    public static void menuLocacao() throws Exception
    {
        System.out.println("1. Cadastrar aluguel");
        System.out.println("2. Finalizar aluguel");
        System.out.println("3. Listar aluguel");
    }

}
