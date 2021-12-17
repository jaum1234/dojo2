package dojo2;

public class Livro
{
    private static int id = 0;
    private int livroId;
    private String titulo;
    private String autor;
    private String editora;
    private String dataPublicaçao;

    public Livro(String titulo, String autor, String editora, String dataPublicaçao)
    {
        this.id++;
        this.livroId = this.id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.dataPublicaçao = dataPublicaçao;
    }

    public int getLivroId() {
        return livroId;
    }

    public String getAutor() {
        return autor;
    }

    public String getDataPublicaçao() {
        return dataPublicaçao;
    }

    public String getEditora() {
        return editora;
    }

    public String getTitulo() {
        return titulo;
    }
}

