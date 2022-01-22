package src.dojo2.entidades;

public class Livro
{
    private int id;
    private String titulo;
    private String autor;
    private String editora;
    private String dataPublicaçao;
    private Cliente cliente;
    private boolean emLocacao;

    public Livro(int id, String titulo, String autor, String editora, String dataPublicaçao)
    {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.dataPublicaçao = dataPublicaçao;
        this.emLocacao = false;
    }

    public int identificador()
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

        this.cliente = null;
        this.emLocacao = false;
    }

    public void dadosFormatados()
    {
        System.out.println("Id: " + this.id);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Editora: " + this.editora);
        System.out.println("Data de publicaçao: " + this.dataPublicaçao);
        System.out.println("");
    }
}

