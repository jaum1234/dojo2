package src.dojo2;

public class Livro extends BaseClass
{
    private static int id = 0;
    private int livroId;
    private String titulo;
    private String autor;
    private String editora;
    private String dataPublicaçao;
    private boolean emLocacao;
    private Cliente cliente;

    public Livro(String titulo, String autor, String editora, String dataPublicaçao)
    {
        this.id++;
        this.livroId = this.id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.dataPublicaçao = dataPublicaçao;
        this.emLocacao = false;
    }

    public int id()
    {
        return this.livroId;
    }
    public boolean emLocacao()
    {
        return this.emLocacao;
    }

    public void entrarEmLocacao(Cliente cliente) throws Exception
    {
        if (this.emLocacao) {
            throw new Exception("Livro de id " + this.livroId + " já está em locaçao");
        }

        this.cliente = cliente;
        this.emLocacao = true;
    }

    public void sairDaLocacao(Cliente cliente) {
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

