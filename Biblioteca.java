package src.dojo2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Biblioteca extends BaseClass
{
    ArrayList<Livro> livros;
    ArrayList<Cliente> clientes;
    ArrayList<Aluguel> alugueis;

    public Biblioteca() {
        this.livros = new ArrayList<Livro>();
        this.clientes = new ArrayList<Cliente>();
        this.alugueis = new ArrayList<Aluguel>();
    }

    public void cadastrarLivro(Livro livro) {

        if (this.atingiuLimiteLivros()) {
            System.out.println("A biblioteca só pode cadastrar no máximo 1000 livros.");
            return;
        }

        if (this.livroJaCadastrado(livro)) {
            System.out.println("Livro já cadastrado.");
            return;
        }

        this.livros.add(livro);
        this.output("Livro de id: " + livro.id() + " cadastrado com sucesso!");
    }

    private boolean atingiuLimiteLivros()
    {
        return this.livros.size() > 1000;
    }

    public void removerLivro(Livro livro) {
        if (livro.emLocacao()) {
            System.out.println("Voce nao pode remover o livro de id " + livro.id() + ". Ele esta em locaçao.");
            return;
        }

        this.livros.remove(livro);
        System.out.println("Livro de id " + livro.id() + " removido com sucesso.");
    }

    public void listarLivros() {

        this.output("LISTA DE LIVROS\n");
        for (Livro livro : this.livros) {
            livro.dadosFormatados();
        }
    }

    public void cadastrarCliente(Cliente cliente)
    {
        if (this.clienteJaCadastrado(cliente)) {
            this.output("Cliente já cadastrado.");
            return;
        }

        this.clientes.add(cliente);
        this.output("Cliente de cpf: " + cliente.cpf() + " cadastrado com sucesso!");
    }

    public void removerCliente(Cliente cliente)
    {
        if (cliente.numAlugueisEmCurso() > 0) {
            this.output("O cliente de cpf " + cliente.cpf() + " nao pode ser removido. Ele esta em locaçao.");
            return;
        }

        this.clientes.remove(cliente);
        this.output("Cliente de cpf " + cliente.cpf() + " removido com sucesso.");
    }

    public void listarClientes() {
       this.output("LISTA DE CLIENTES\n");
        for (Cliente cliente : this.clientes) {
            cliente.dadosFormatados();
        }
    }

    public void registrarAluguel(Aluguel aluguel)
    {
        Cliente cliente = aluguel.cliente();
        Livro livro = aluguel.livro();

        if (!this.clienteJaCadastrado(cliente)) {
            this.output("Falha na locaçao. Cliente nao cadastrado.");
            return;
        }

        if (!this.livroJaCadastrado(livro)) {
            this.output("Falha na locaçao. Livro nao cadastrado.");
            return;
        }

        try {
            cliente.alugar(livro);
            livro.entrarEmLocacao(cliente);
        } catch (Exception e) {
            this.output(e.getMessage());
            return;
        }

        aluguel.setData();
        this.alugueis.add(aluguel);
        this.output("Aluguel de id: " + aluguel.id() + " registrado e validado com sucesso!");
    }

    public void removerAluguel(Aluguel aluguel) throws Exception
    {
        if (!this.alugueis.contains(aluguel)) {
            this.output("O aluguel nao pode ser removido pois ainda foi registrado e validado na biblioteca.");
            return;
        }

        aluguel.encerrar();
        this.alugueis.remove(aluguel);

        this.output("Aluguel de id: " + aluguel.id() + " finalizado.");
    }

    public void listarTodosAlugueis()
    {
        this.output("LISTA GERAL DE ALUGUEIS: \n");

        for (Aluguel aluguel : this.alugueis) {
            aluguel.dadosFormatados();
        }
    }

    /**
     *
     * @param minData formato: dd-mm-yyyy
     * @param maxData formato: dd-mm-yyyy
     */
    public void listarAlugueisPorData(String minData, String maxData) throws Exception
    {
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");

        Date minDataCovertida = formatador.parse(minData);
        Date maxDataConvertida = formatador.parse(maxData);

        for (Aluguel aluguel: this.alugueis) {
            if (aluguel.data().after(minDataCovertida) && aluguel.data().before(maxDataConvertida)) {
                aluguel.dadosFormatados();
            }
        }
    }

    /**
     *
     * @param minData dd-mm-yyyy
     * @param maxData dd-mm-yyyy
     * @param cliente
     */
    public void listarAlugueisPorDataCliente(String minData, String maxData, Cliente cliente)
    {

        for (Aluguel aluguel : this.alugueis) {
            //if (aluguel.getData() >= minData && aluguel.getData() <= maxData) {
              //  aluguel.dadosFormatados();
            //}
        }
    }

    /**
     *
     * @param minData dd-mm-yyyy
     * @param maxData dd-mm-yyyy
     * @param livro
     */
    public void listarAlugueisPorDataLivro(String minData, String maxData, Livro livro)
    {

    }

    private boolean clienteJaCadastrado(Cliente cliente)
    {
        for (Cliente clienteCadastrado : this.clientes) {
            if (clienteCadastrado.cpf() == cliente.cpf()) {
                return true;
            }
        }
        return false;
    }

    private boolean livroJaCadastrado(Livro livro)
    {
        for (Livro livroCadastrado : this.livros) {
            if (livroCadastrado.id() == livro.id()) {
                return true;
            }
        }
        return false;
    }

}
