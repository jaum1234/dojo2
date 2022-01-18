package src.dojo2;

import src.dojo2.Biblioteca;

import java.util.Scanner;

public class Menu
{
    private static int escolha;
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void call() throws Exception
    {
        menuPrincipal();
    }

    private static void menuPrincipal() throws Exception
    {
        System.out.println("Bem vindo a Biblioteca! ");
        System.out.println("");
        System.out.println("1. Cliente");
        System.out.println("2. Livro");
        System.out.println("3. Locaçao");
        System.out.println("4. Sair");

        escolherOpcao();

        switch (escolha) {
            case 1:
                menuCliente();
                break;
            case 2:
                menuLivro();
                break;
            case 3:
                menuLocacao();
                break;
            default:
                System.out.println("Programa encerrado.");
        }
    }

    private static void menuCliente() throws Exception
    {
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Remover cliente");
        System.out.println("3. Listar clientes");
        System.out.println("4. Voltar");

        escolherOpcao();

        switch (escolha) {
            case 1:
                cadastroCliente();
                break;
            case 2:
                remocaoCliente();
                break;
            case 3:
                listaClientes();
                break;
            default:
                menuPrincipal();
        }
    }

    private static void cadastroCliente() throws Exception
    {
        try {
            biblioteca.cadastrarCliente();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            menuCliente();
            return;
        }
        menuPrincipal();
    }

    private static void remocaoCliente() throws Exception
    {
        try {
            biblioteca.removerCliente();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            menuCliente();
            return;
        }
        menuPrincipal();
    }

    private static void listaClientes() throws Exception
    {
        biblioteca.listarClientes();
        menuPrincipal();
    }

    private static void menuLivro() throws Exception
    {
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Remover livro");
        System.out.println("3. Listar livros");
        System.out.println("4. Voltar");

        escolherOpcao();

        switch (escolha) {
            case 1:
                cadastroLivro();
                break;
            case 2:
                remocaoLivro();
                break;
            case 3:
                listaLivros();
                break;
            default:
                menuPrincipal();
        }
    }

    private static void cadastroLivro() throws Exception
    {

        try {
            biblioteca.cadastrarLivro();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            cadastroLivro();
            return;
        }
        menuPrincipal();
    }

    private static void remocaoLivro() throws Exception
    {
        try {
            biblioteca.removerLivro();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            cadastroLivro();
            return;
        }
        menuPrincipal();
    }

    private static void listaLivros() throws Exception
    {
        biblioteca.listarLivros();
        menuPrincipal();
    }

    private static void menuLocacao() throws Exception
    {
        System.out.println("1. Cadastrar aluguel");
        System.out.println("2. Finalizar aluguel");
        System.out.println("3. Listar aluguel");
        System.out.println("4. Voltar");

        escolherOpcao();

        switch (escolha) {
            case 1:
                cadastroAluguel();
                break;
            case 2:
                finalizacaoAluguel();
                break;
            case 3:
                listaAlugueis();
                break;
            default:
                menuPrincipal();
        }
    }

    private static void cadastroAluguel() throws Exception
    {

        try {
            biblioteca.registrarAluguel();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            menuLocacao();
            return;
        }
        menuPrincipal();
    }

    private static void finalizacaoAluguel() throws Exception
    {
        try {
            biblioteca.removerAluguel();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            menuLocacao();
            return;
        }
        menuPrincipal();
    }

    private static void listaAlugueis() throws Exception
    {
        System.out.println("1. Todos");
        System.out.println("2. Filtrar por data e cliente");
        System.out.println("3. Filtrar por data e livro");
        System.out.println("4. Voltar");

        escolherOpcao();

        switch (escolha) {
            case 1:
                todosAlugueis();
                break;
            case 2:
                filtradoPorDataCliente();
                break;
            case 3:
                filtradoPorDataLivro();
                break;
            default:
                menuPrincipal();
        }
    }

    private static void todosAlugueis() throws Exception
    {
        biblioteca.listarTodosAlugueis();
        menuPrincipal();
    }

    private static void filtradoPorDataCliente() throws Exception
    {
        System.out.println("Forneça o cpf do cliente: ");
        scanner.nextLine();
        String cpf = scanner.nextLine();

        Cliente cliente;

        try {
            cliente = biblioteca.buscarCliente(cpf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            menuLocacao();
            return;
        }

        /// ler data aqui

        biblioteca.listarAlugueisPorDataCliente("17-01-2022", "19-01-2022", cliente);
        menuPrincipal();
    }

    private static void filtradoPorDataLivro() throws Exception
    {
        System.out.println("Forneça o id do livro: ");
        int id = scanner.nextInt();

        Livro livro;

        try {
            livro = biblioteca.buscarLivro(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            menuLocacao();
            return;
        }
        /// ler data aqui

        biblioteca.listarAlugueisPorDataLivro("17-01-2022", "19-01-2022", livro);
        menuPrincipal();
    }


    private static void escolherOpcao()
    {
        while(true) {
            escolha = scanner.nextInt();

            if (escolha >= 1 && escolha <= 4) {
                break;
            }
            System.out.println("Opçao inválida. Tente novamente.");
        }
    }

}
