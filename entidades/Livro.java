package src.dojo2.entidades;

import src.dojo2.BaseClass;

public class Livro extends BaseClass
{
    private int id;
    private String titulo;
    private String autor;
    private String editora;
    private String dataPublicaçao;
    private boolean emLocacao;
    private Cliente cliente;

    public Livro(int id, String titulo, String autor, String editora, String dataPublicaçao)
    {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.dataPublicaçao = dataPublicaçao;
        this.emLocacao = false;
    }

    public int id()
    {
        return this.id;
    }
    public boolean emLocacao()
    {
        return this.emLocacao;
    }

    public void entrarEmLocacao(Cliente cliente) throws Exception
    {
        if (this.emLocacao) {
            throw new Exception("Livro de id " + this.id + " já está em locaçao");
        }

        this.cliente = cliente;
        this.emLocacao = true;
    }

    public void sairDaLocacao(Cliente cliente) throws Exception
    {
        if (this.cliente != cliente) {
            throw new Exception("Cliente nao está associdado a esse livro.");
        }

        this.emLocacao = false;
    }

    public void dadosFormatados()
    {
        this.output("Titulo: " + this.titulo);
        this.output("Autor: " + this.autor);
        this.output("Editora: " + this.editora);
        this.output("Data de publicaçao: " + this.dataPublicaçao);
        this.output("");
    }
}

