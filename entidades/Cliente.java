package src.dojo2.entidades;

import java.util.ArrayList;

public class Cliente
{
    private String nome;
    private int cpf;
    private ArrayList<Livro> alugueisEmCurso;
    private ArrayList<Livro> ultimos3Alugueis;

    public Cliente(String nome, int cpf)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.alugueisEmCurso = new ArrayList<Livro>();
        this.ultimos3Alugueis = new ArrayList<Livro>();
    }

    public int identificador()
    {
        return cpf;
    }

    public int numAlugueisEmCurso()
    {
        return this.alugueisEmCurso.size();
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
            throw new Exception("O livro de id: " + livro.identificador() + " esta entre os ultimos 3 livros alugados pelo usuário.");
        }

        if (this.ultimos3Alugueis.size() >= 3) {
            this.ultimos3Alugueis.remove(0);
        }

        this.ultimos3Alugueis.add(livro);
        this.alugueisEmCurso.add(livro);
    }

    private boolean possuiMaisDe2AlugueisEmCurso()
    {
        return this.alugueisEmCurso.size() >= 2;
    }

    private boolean estaEntreOsUltimos3livrosAlugados(Livro livro)
    {
         return this.ultimos3Alugueis.contains(livro);
        //if (this.ultimos3Alugueis.size() < 3) {
        //    for (Livro livroAlugado: this.ultimos3Alugueis) {
        //        if (livro.identificador() == livroAlugado.identificador()) {
        //            return true;
        //        }
        //    }
        //} else {
        //    int antepenultimoLivro = this.ultimos3Alugueis.size() - 3;
        //    int ultimoLivro = this.ultimos3Alugueis.size() - 1;
        //
        //    for (int i = antepenultimoLivro; i <= ultimoLivro; i++) {
        //        if (this.ultimos3Alugueis.get(i).identificador() == livro.identificador()) {
        //            return true;
        //        }
        //    }
        //}
        //return false;
    }

    /**
     * Método só deve ser chamado de dentro do método 'removerAluguel'
     * na classe Biblioteca
     *
     * @see Biblioteca#removerAluguel()
     */
    public void desalugar(Livro livro) throws  Exception
    {
        if (!this.alugueisEmCurso.contains(livro)) {
            throw new Exception("Livro nao pertence ao cliente de cpf " + this.cpf);
        }
        this.alugueisEmCurso.remove(livro);
    }

    public void dadosFormatados()
    {
        System.out.println("CPF: " + this.cpf);
        System.out.println("Nome: " + this.nome);
        System.out.println("----------------------------------");

    }
}
