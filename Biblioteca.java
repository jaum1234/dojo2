package dojo2;

import java.util.ArrayList;

public class Biblioteca
{
    ArrayList<Livro> livros;
    ArrayList<Cliente> clientes;
    Aluguel aluguel;

    public Biblioteca()
    {
        this.livros = new ArrayList<Livro>();
        this.clientes = new ArrayList<Cliente>();
    }

    public void cadastrarLivro(Livro livro)
    {
        if (this.livros.size() > 1000) {
            System.out.println("Só podem ser cadastrados, no máximo, 1000 livros.");
            return;
        }

        if (this.livroJaCadastrado(livro)) {
            return;
        }

        this.livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private boolean livroJaCadastrado(Livro livro)
    {
        for (Livro livroCadastrado: this.livros) {
            if (livroCadastrado.getLivroId() == livro.getLivroId()) {
                System.out.println("Livro já cadastrado.");
                return true;
            }
        }
        return false;
    }


    public void listarLivros() {

        System.out.printf("LISTA DE LIVROS\n\n");
        for (Livro livro: this.livros) {
            System.out.printf("Titulo: %s\n", livro.getTitulo());
            System.out.printf("Autor: %s\n", livro.getAutor());
            System.out.printf("Editora: %s\n", livro.getEditora());
            System.out.printf("Data de publicaçao: %s\n\n", livro.getDataPublicaçao());
        }
    }

    public void removerLivro(Livro livro)
    {
        this.livros.remove(livro);
    }

    public void cadastrarCliente(Cliente cliente)
    {
        for (Cliente clienteCadastrado: this.clientes) {
            if (cliente.getCpf() == clienteCadastrado.getCpf()) {
                System.out.println("Cliente com cpf " + cliente.getCpf() + " já cadastrado!");
                return;
            }
        }

        this.clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes()
    {
        System.out.printf("LISTA DE CLIENTES\n\n");
        for (Cliente cliente: this.clientes) {
            System.out.printf("Nome: %s\n", cliente.getNome());
            System.out.printf("Autor: %s\n\n", cliente.getCpf());
        }
    }

    public void removerCliente(Cliente cliente)
    {
        this.clientes.remove(cliente);
    }

    public void realizarAluguel(Cliente cliente, Livro livro)
    {

    }

}
