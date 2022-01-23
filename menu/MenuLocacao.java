package src.dojo2.menu;

import src.dojo2.entidades.Cliente;
import src.dojo2.entidades.Livro;

public class MenuLocacao extends Menu
{
    protected static void render() throws Exception
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
                MenuPrincipal.render();
        }
    }

    private static void cadastroAluguel() throws Exception
    {

        try {
            biblioteca.registrarAluguel();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            render();
            return;
        }
        MenuPrincipal.render();
    }

    private static void finalizacaoAluguel() throws Exception
    {
        try {
            biblioteca.removerAluguel();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            render();
            return;
        }
        MenuPrincipal.render();
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
                MenuPrincipal.render();
        }
    }

    private static void todosAlugueis() throws Exception
    {
        biblioteca.listarTodosAlugueis();
        MenuPrincipal.render();
    }

    private static void filtradoPorDataCliente() throws Exception
    {
       try {
            biblioteca.listarAlugueisPorDataCliente();
       } catch (Exception e) {
           System.out.println(e.getMessage());
           listaAlugueis();
           return;
       }
        MenuPrincipal.render();
    }

    private static void filtradoPorDataLivro() throws Exception
    {
        try {
            biblioteca.listarAlugueisPorDataLivro();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            listaAlugueis();
            return;
        }
        MenuPrincipal.render();
    }



}
