package src.dojo2;

import java.util.ArrayList;

public class Cliente extends BaseClass
{
    private String nome;
    private String cpf;
    private int numAlugueisEmCurso;
    private ArrayList<Livro> livros;

    public Cliente(String nome, String cpf)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.livros = new ArrayList<Livro>();
    }

    public String cpf()
    {
        return cpf;
    }

    public int numAlugueisEmCurso()
    {
        return this.numAlugueisEmCurso;
    }

    /**
     * Método só deve ser chamado de dentro do método 'registrarAluguel'
     * na classe Biblioteca
     *
     * @see src.dojo2.Biblioteca#registrarAluguel(Aluguel)
     */
    public void alugar(Livro livro) throws Exception
    {

        if (this.possuiMaisDe2AlugueisEmCurso()) {
            throw new Exception("Cliente só pode alugar 2 livros por vez");
        }

        if (this.estaEntreOsUltimos3livrosAlugados(livro)) {
            throw new Exception("O livro de id: " + livro.id() + " esta entre os ultimos 3 livros alugados pelo usuário.");
        }

        this.livros.add(livro);
        this.numAlugueisEmCurso++;
    }

    private boolean possuiMaisDe2AlugueisEmCurso()
    {
        return this.numAlugueisEmCurso >= 2;
    }

    private boolean estaEntreOsUltimos3livrosAlugados(Livro livro)
    {
        if (this.livros.size() < 3) {
            for (Livro livroAlugado: this.livros) {
                if (livro.id() == livroAlugado.id()) {
                    return true;
                }
            }
        } else {
            int antepenultimoLivro = this.livros.size() - 3;
            int ultimoLivro = this.livros.size() - 1;

            for (int i = antepenultimoLivro; i <= ultimoLivro; i++) {
                if (this.livros.get(i).id() == livro.id()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método só deve ser chamado de dentro do método 'removerAluguel'
     * na classe Biblioteca
     *
     * @see src.dojo2.Biblioteca#removerAluguel(Aluguel)
     */
    public void desalugar(Livro livro) throws  Exception
    {
        if (!this.livros.contains(livro)) {
            throw new Exception("Livro nao pertence ao cliente de cpf " + this.cpf);
        }
        this.numAlugueisEmCurso--;
    }

    public void dadosFormatados()
    {
        this.output("CPF: " + this.cpf);
        this.output("Nome: " + this.nome);
        this.output("");
    }
}
