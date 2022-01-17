package src.dojo2.testes.Biblioteca;

import src.dojo2.Aluguel;
import src.dojo2.Biblioteca;
import src.dojo2.Cliente;
import src.dojo2.Livro;

public class RemoverTeste {
    public static void main(String[] args) throws Exception
    {
        //testeDeveRemoverLocacao();
        //testeDeveRemoverLivro();
        //testeDeveRemoverCliente();
        //testeRemocaoDeveFalharSeClienteEstiverEmLocacao();
        //testeRemocaoDeveFalharSeLivroEstiverEmLocacao();
    }

    public static void testeDeveRemoverLivro()
    {
        Livro livro1 = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25/5/2002");

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro(livro1);
        //biblioteca.listarLivros();

        biblioteca.removerLivro(livro1);
        //biblioteca.listarLivros();

        System.out.println("Teste passou!------------------------\n");

    }

    public static void testeDeveRemoverCliente()
    {
        Cliente cliente1 = new Cliente("joao", "12345678913");

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente(cliente1);
        //biblioteca.listarClientes();

        biblioteca.removerCliente(cliente1);
        //biblioteca.listarClientes();

        System.out.println("Teste passou!------------------------\n");
    }

    public static void testeRemocaoDeveFalharSeLivroEstiverEmLocacao() throws Exception
    {
        Cliente cliente1 = new Cliente("joao", "12345678913");
        Livro livro1 = new Livro("Livro 1", "Autor 1", "Editor !", "25/5/2001");
        Aluguel aluguel1 = new Aluguel(cliente1, livro1);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente(cliente1);
        biblioteca.cadastrarLivro(livro1);

        biblioteca.registrarAluguel(aluguel1);

        biblioteca.removerLivro(livro1);
        //biblioteca.listarLivros();

        System.out.println("Teste passou!------------------------\n");
    }

    public static void testeRemocaoDeveFalharSeClienteEstiverEmLocacao() throws Exception
    {
        Cliente cliente1 = new Cliente("joao", "12345678913");
        Livro livro1 = new Livro("Livro 1", "Autor 1", "Editor !", "25/5/2001");
        Aluguel aluguel1 = new Aluguel(cliente1, livro1);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente(cliente1);
        //biblioteca.listarClientes();
        biblioteca.cadastrarLivro(livro1);

        biblioteca.registrarAluguel(aluguel1);

        biblioteca.removerCliente(cliente1);
        //biblioteca.listarClientes();

        System.out.println("Teste passou!------------------------\n");
    }

    public static void testeDeveRemoverLocacao() throws Exception
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

        biblioteca.cadastrarCliente(cliente);
        biblioteca.cadastrarCliente(cliente2);
        biblioteca.cadastrarCliente(cliente3);

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);
        biblioteca.cadastrarLivro(livro4);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);
        biblioteca.registrarAluguel(aluguel3);
        biblioteca.registrarAluguel(aluguel4);

        System.out.println("--------------ANTES--------------------\n");

        biblioteca.listarTodosAlugueis();

        biblioteca.removerAluguel(aluguel3);

        System.out.println("--------------DEPOIS--------------------\n");
        biblioteca.listarTodosAlugueis();

        System.out.println("Teste passou!------------------------\n");
    }


}
