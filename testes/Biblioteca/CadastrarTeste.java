package src.dojo2.testes.Biblioteca;

import src.dojo2.Aluguel;
import src.dojo2.Biblioteca;
import src.dojo2.Cliente;
import src.dojo2.Livro;

public class CadastrarTeste {

    public static void main(String[] args) throws Exception
    {
        //testeDeveCadastrarCliente();
        //testeDeveCadastrarLivro();
        //testeBibliotecaDeveRealizarUmaLocacao();
        //testeLocacaoDeveFalharSeUsuarioTiver2AlugueisEmCurso();
        testeLocacaoDeveFalharSeLivroAlugadoEstiverEntreOsUltimos3LivrosAlugadosPeloCliente();
        //testeLocacaoDeveFalharSeLivroEstaEmLocacao();
        //testeLivroDevePoderSerAlugadoAposSairDeUmaLocacao();
        //testeClienteDevePoderAlugarMesmoLivroQuandoEsseNaoMaisEstiverEntreOsUltimos3();
    }

    public static void testeDeveCadastrarCliente()
    {
        Cliente cliente = new Cliente("Joao", "12345678901");
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente(cliente);

        System.out.println("Teste passou!");
    }

    public static void testeDeveCadastrarLivro()
    {
        Livro livro = new Livro("Novo livro", "Jonas", "Editora Nova", "20-01-2001");
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro(livro);

        System.out.println("Teste passou!");
    }

    public static void testeBibliotecaDeveRealizarUmaLocacao() throws Exception
    {
        Cliente cliente = new Cliente("joao", "123456789");
        Livro livro = new Livro("Um livro qualquer", "Um autor qualquer", "indefinido", "25/5/2002");
        Aluguel aluguel = new Aluguel(cliente, livro);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarCliente(cliente);
        biblioteca.cadastrarLivro(livro);

        biblioteca.registrarAluguel(aluguel);

        System.out.println("Teste passou!------------------------\n");
    }

    public static void testeLocacaoDeveFalharSeUsuarioTiver2AlugueisEmCurso() throws Exception
    {
        Cliente cliente = new Cliente("joao", "123456789");

        Livro livro1 = new Livro("Livro 1", "Autor 1", "Editora 1", "25/5/2001");
        Livro livro2 = new Livro("Livro 2", "Autor 2", "Editora 2", "25/5/2002");
        Livro livro3 = new Livro("Livro 3", "Autor 3", "Editora 3", "25/5/2003");

        Aluguel aluguel1 = new Aluguel(cliente, livro1);
        Aluguel aluguel2 = new Aluguel(cliente, livro2);
        Aluguel aluguel3 = new Aluguel(cliente, livro3);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente(cliente);

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);
        biblioteca.registrarAluguel(aluguel3);

        //biblioteca.listarTodosAlugueis();

        System.out.println("Teste passou!------------------------\n");
    }

    public static void testeLocacaoDeveFalharSeLivroAlugadoEstiverEntreOsUltimos3LivrosAlugadosPeloCliente() throws Exception
    {
        Cliente cliente = new Cliente("joao", "123456789");

        Livro livro1 = new Livro("Livro 1", "Autor 1", "Editora 1", "25/5/2001");
        Livro livro2 = new Livro("Livro 2", "Autor 2", "Editora 2", "25/5/2002");
        Livro livro3 = new Livro("Livro 3", "Autor 3", "Editora 3", "25/5/2003");
        Livro livro4 = new Livro("Livro 4", "Autor 4", "Editora 4", "25/5/2004");

        Aluguel aluguel1 = new Aluguel(cliente, livro1);
        Aluguel aluguel2 = new Aluguel(cliente, livro2);
        Aluguel aluguel3 = new Aluguel(cliente, livro3);
        Aluguel aluguel4 = new Aluguel(cliente, livro4);
        Aluguel aluguel5 = new Aluguel(cliente, livro1);
        Aluguel aluguel6 = new Aluguel(cliente, livro2);


        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente(cliente);

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);
        biblioteca.cadastrarLivro(livro4);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);

        biblioteca.removerAluguel(aluguel1);

        biblioteca.registrarAluguel(aluguel3);

        biblioteca.removerAluguel(aluguel2);

        biblioteca.registrarAluguel(aluguel4);

        biblioteca.removerAluguel(aluguel3);

        biblioteca.registrarAluguel(aluguel5);

        biblioteca.removerAluguel(aluguel4);
        biblioteca.removerAluguel(aluguel5);

        biblioteca.registrarAluguel(aluguel6);

        System.out.println("Teste passou!------------------------\n");
    }

    public static void testeClienteDevePoderAlugarMesmoLivroQuandoEsseNaoMaisEstiverEntreOsUltimos3() throws Exception
    {

        Cliente cliente = new Cliente("joao", "123456789");

        Livro livro1 = new Livro("Livro 1", "Autor 1", "Editora 1", "25/5/2001");
        Livro livro2 = new Livro("Livro 2", "Autor 2", "Editora 2", "25/5/2002");
        Livro livro3 = new Livro("Livro 3", "Autor 3", "Editora 3", "25/5/2003");

        Aluguel aluguel1 = new Aluguel(cliente, livro1);
        Aluguel aluguel2 = new Aluguel(cliente, livro2);
        Aluguel aluguel3 = new Aluguel(cliente, livro3);
        Aluguel aluguel4 = new Aluguel(cliente, livro1);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente(cliente);

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);

        biblioteca.removerAluguel(aluguel2);

        biblioteca.registrarAluguel(aluguel3);

        biblioteca.removerAluguel(aluguel3);

        biblioteca.registrarAluguel(aluguel1);

    }

    public static void testeLocacaoDeveFalharSeLivroEstaEmLocacao() throws Exception
    {
        Cliente cliente1 = new Cliente("joao", "123456789");
        Cliente cliente2 = new Cliente("pedro", "1234567811");

        Livro livro1 = new Livro("Livro 1", "Autor 1", "Editora 1", "25/5/2001");

        Aluguel aluguel1 = new Aluguel(cliente1, livro1);
        Aluguel aluguel2 = new Aluguel(cliente2, livro1);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente(cliente1);
        biblioteca.cadastrarCliente(cliente2);

        biblioteca.cadastrarLivro(livro1);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);

        //biblioteca.listarTodosAlugueis();
    }

    public static void testeLivroDevePoderSerAlugadoAposSairDeUmaLocacao() throws Exception
    {
        Cliente cliente1 = new Cliente("joao", "123456789");
        Cliente cliente2 = new Cliente("pedro", "1234567811");

        Livro livro1 = new Livro("Livro 1", "Autor 1", "Editora 1", "25/5/2001");

        Aluguel aluguel1 = new Aluguel(cliente1, livro1);
        Aluguel aluguel2 = new Aluguel(cliente2, livro1);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarCliente(cliente1);
        biblioteca.cadastrarCliente(cliente2);

        biblioteca.cadastrarLivro(livro1);

        biblioteca.registrarAluguel(aluguel1);
        biblioteca.removerAluguel(aluguel1);
        biblioteca.registrarAluguel(aluguel2);
    }

}
