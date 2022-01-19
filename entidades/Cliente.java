package src.dojo2.entidades;

import src.dojo2.BaseClass;

import java.util.ArrayList;

public class Cliente extends BaseClass
{
    private static int id = 0;
    private int clienteId;
    private String nome;
    private String cpf;
    private int numAlugueisEmCurso;
    private ArrayList<Livro> historicoLivrosAlugados;

    public Cliente(String nome, String cpf)
    {
        this.id++;
        this.clienteId = this.id;
        this.nome = nome;
        this.cpf = cpf;
        this.numAlugueisEmCurso = 0;
        this.historicoLivrosAlugados = new ArrayList<Livro>();
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
     * @see Biblioteca#registrarAluguel()
     */
    public void alugar(Livro livro) throws Exception
    {

        if (this.possuiMaisDe2AlugueisEmCurso()) {
            throw new Exception("Cliente só pode alugar 2 livros por vez");
        }

        if (this.estaEntreOsUltimos3livrosAlugados(livro)) {
            throw new Exception("O livro de id: " + livro.id() + " esta entre os ultimos 3 livros alugados pelo usuário.");
        }

        this.historicoLivrosAlugados.add(livro);
        this.numAlugueisEmCurso++;
    }

    private boolean possuiMaisDe2AlugueisEmCurso()
    {
        return this.numAlugueisEmCurso >= 2;
    }

    private boolean estaEntreOsUltimos3livrosAlugados(Livro livro)
    {
        if (this.historicoLivrosAlugados.size() < 3) {
            for (Livro livroAlugado: this.historicoLivrosAlugados) {
                if (livro.id() == livroAlugado.id()) {
                    return true;
                }
            }
        } else {
            int antepenultimoLivro = this.historicoLivrosAlugados.size() - 3;
            int ultimoLivro = this.historicoLivrosAlugados.size() - 1;

            for (int i = antepenultimoLivro; i <= ultimoLivro; i++) {
                if (this.historicoLivrosAlugados.get(i).id() == livro.id()) {
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
     * @see Biblioteca#removerAluguel()
     */
    public void desalugar(Livro livro) throws  Exception
    {
        if (!this.historicoLivrosAlugados.contains(livro)) {
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
