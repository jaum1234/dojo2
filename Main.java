package dojo2;

public class Main
{

    public static void main(String[] args)
    {
        Livro livro = new Livro("joao", "joao", "joao", "joao");
        Cliente cliente = new Cliente("joao", "12345678901");

        System.out.println(livro.getLivroId());
        System.out.println(cliente.getNome());

        Biblioteca biblioteca = new Biblioteca();

        Aluguel aluguel = new Aluguel(cliente, livro);
        System.out.println(aluguel.getData());

    }
}
