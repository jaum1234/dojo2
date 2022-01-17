package src.dojo2.testes.Biblioteca;

import src.dojo2.Aluguel;
import src.dojo2.Biblioteca;
import src.dojo2.Cliente;
import src.dojo2.Livro;

public class ListarTeste {

    public static void main(String[] args) throws Exception
    {
        //testeBibliotecaDeveListarTodosOsClientes();
        //testeBibliotecaDeveListarTodosOsLivros();
        //testeBibliotecaDeveListarTodasAsLocacoes();
        //testeDeveListarLocacoesFiltradasPorData();
        //testeDeveListarLocacoesFiltradasPorDataECliente();
        //testeDeveListarLocacoesFiltradasPorDataLivro();
    }

    public static void testeBibliotecaDeveListarTodasAsLocacoes() throws Exception
    {
        Cliente cliente = new Cliente("joao", "12345678913");
        Cliente cliente2 = new Cliente("pedro", "12345678912");
        Cliente cliente3 = new Cliente("antonio", "12345678911");

        Livro livro = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25/5/2002");
        Livro livro2 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25/5/2002");
        Livro livro3 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25/5/2002");
        Livro livro4 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25/5/2002");

        Aluguel aluguel1 = new Aluguel(cliente, livro);
        Aluguel aluguel2 = new Aluguel(cliente2, livro2);
        Aluguel aluguel3 = new Aluguel(cliente3, livro3);
        Aluguel aluguel4 = new Aluguel(cliente, livro4);

        Biblioteca biblioteca = new Biblioteca();

        //biblioteca.cadastrarCliente(cliente);
        //biblioteca.cadastrarCliente(cliente2);
        //biblioteca.cadastrarCliente(cliente3);

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);
        biblioteca.cadastrarLivro(livro4);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);
        biblioteca.registrarAluguel(aluguel3);
        biblioteca.registrarAluguel(aluguel4);

        biblioteca.listarTodosAlugueis();

        System.out.println("Teste passou!------------------------\n");
    }

    public static void testeBibliotecaDeveListarTodosOsClientes()
    {
        Cliente cliente = new Cliente("joao", "12345678913");
        Cliente cliente2 = new Cliente("pedro", "12345678912");
        Cliente cliente3 = new Cliente("antonio", "12345678911");

        Biblioteca biblioteca = new Biblioteca();

        //biblioteca.cadastrarCliente(cliente);
        //biblioteca.cadastrarCliente(cliente2);
        //biblioteca.cadastrarCliente(cliente3);

        biblioteca.listarClientes();

        System.out.println("Teste passou!------------------------\n");
    }

    public static void testeBibliotecaDeveListarTodosOsLivros()
    {
        Livro livro = new Livro("Livro 1", "Autor 1", "Editora 1", "25/5/2001");
        Livro livro2 = new Livro("Livro 2", "Autor 2", "Editora 2", "25/5/2002");
        Livro livro3 = new Livro("Livro 3", "Autor 3", "Editor 3", "25/5/2003");
        Livro livro4 = new Livro("Livro 4", "Autor 4", "Editora 4", "25/5/2004");

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);

        biblioteca.listarLivros();
        System.out.println("Teste passou!------------------------\n");
    }

    public static void testeDeveListarLocacoesFiltradasPorData() throws Exception
    {
        Cliente cliente = new Cliente("joao", "12345678913");
        Cliente cliente2 = new Cliente("pedro", "12345678912");
        Cliente cliente3 = new Cliente("antonio", "12345678911");

        Livro livro = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2002");
        Livro livro2 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2003");
        Livro livro3 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2004");
        Livro livro4 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2005");

        Aluguel aluguel1 = new Aluguel(cliente, livro);
        Aluguel aluguel2 = new Aluguel(cliente2, livro2);
        Aluguel aluguel3 = new Aluguel(cliente3, livro3);
        Aluguel aluguel4 = new Aluguel(cliente, livro4);

        Biblioteca biblioteca = new Biblioteca();

        //biblioteca.cadastrarCliente(cliente);
        //biblioteca.cadastrarCliente(cliente2);
        //biblioteca.cadastrarCliente(cliente3);

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);
        biblioteca.cadastrarLivro(livro4);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);
        biblioteca.registrarAluguel(aluguel3);
        biblioteca.registrarAluguel(aluguel4);

        biblioteca.listarAlugueisPorData("17-01-2022", "18-01-2022");
    }

    public static void testeDeveListarLocacoesFiltradasPorDataECliente() throws Exception
    {
        Cliente cliente = new Cliente("joao", "12345678913");
        Cliente cliente2 = new Cliente("pedro", "12345678912");
        Cliente cliente3 = new Cliente("antonio", "12345678911");

        Livro livro = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2002");
        Livro livro2 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2003");
        Livro livro3 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2004");
        Livro livro4 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2005");

        Aluguel aluguel1 = new Aluguel(cliente, livro);
        Aluguel aluguel2 = new Aluguel(cliente2, livro2);
        Aluguel aluguel3 = new Aluguel(cliente3, livro3);
        Aluguel aluguel4 = new Aluguel(cliente, livro4);

        Biblioteca biblioteca = new Biblioteca();

        //biblioteca.cadastrarCliente(cliente);
       // biblioteca.cadastrarCliente(cliente2);
        //biblioteca.cadastrarCliente(cliente3);

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);
        biblioteca.cadastrarLivro(livro4);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);
        biblioteca.registrarAluguel(aluguel3);
        biblioteca.registrarAluguel(aluguel4);

        biblioteca.listarAlugueisPorDataCliente("17-01-2022", "18-01-2022", cliente);
    }

    public static void testeDeveListarLocacoesFiltradasPorDataLivro() throws Exception
    {
        Cliente cliente = new Cliente("joao", "12345678913");
        Cliente cliente2 = new Cliente("pedro", "12345678912");
        Cliente cliente3 = new Cliente("antonio", "12345678911");

        Livro livro = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2002");
        Livro livro2 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2003");
        Livro livro3 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2004");
        Livro livro4 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25-05-2005");

        Aluguel aluguel1 = new Aluguel(cliente, livro);
        Aluguel aluguel2 = new Aluguel(cliente2, livro2);
        Aluguel aluguel3 = new Aluguel(cliente3, livro3);
        Aluguel aluguel4 = new Aluguel(cliente, livro4);

        Biblioteca biblioteca = new Biblioteca();

        //biblioteca.cadastrarCliente(cliente);
        //biblioteca.cadastrarCliente(cliente2);
        //biblioteca.cadastrarCliente(cliente3);

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);
        biblioteca.cadastrarLivro(livro4);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);
        biblioteca.registrarAluguel(aluguel3);
        biblioteca.registrarAluguel(aluguel4);

        biblioteca.listarAlugueisPorDataLivro("17-01-2022", "18-01-2022", livro2);
    }

}
