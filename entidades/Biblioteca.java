package src.dojo2.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Biblioteca
{
    private ArrayList<Livro> livros;
    private ArrayList<Cliente> clientes;
    private ArrayList<Aluguel> alugueis;

    private Scanner scanner = new Scanner(System.in);

    public Biblioteca()
    {
        this.livros = new ArrayList<Livro>();
        this.clientes = new ArrayList<Cliente>();
        this.alugueis = new ArrayList<Aluguel>();
    }

    public void cadastrarLivro() throws Exception
    {
        if (this.atingiuLimiteLivros()) {
            throw new Exception("A biblioteca só pode cadastrar no máximo 1000 livros.");
        }

        System.out.println("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (this.livroJaCadastrado(id)) {
            throw new Exception("Livro já cadastrado");
        }

        System.out.println("Título: ");
        String titulo = scanner.nextLine();

        System.out.println("Autor: ");
        String autor = scanner.nextLine();

        System.out.println("editora: ");
        String editora = scanner.nextLine();

        System.out.println("Data de publicaçao: (dd-mm-yyyy)");
        String dataPublicacao = scanner.nextLine();

        Livro livro = new Livro(id, titulo, autor, editora, dataPublicacao);

        this.livros.add(livro);
        System.out.println("Livro de id: " + livro.identificador() + " cadastrado com sucesso!");
    }
    private boolean atingiuLimiteLivros()
    {
        return this.livros.size() >= 1000;
    }

    public void removerLivro() throws Exception
    {
        System.out.println("Id no livro a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Livro livro = this.buscarLivro(id);

        if (livro.emLocacao()) {
            throw new Exception("Voce nao pode remover o livro de id " + livro.identificador() + ". Ele esta em locaçao.");
        }

        this.livros.remove(livro);
        System.out.println("Livro de id " + livro.identificador() + " removido com sucesso.");
    }

    public void listarLivros() {

        System.out.println("LISTA DE LIVROS\n");
        for (Livro livro : this.livros) {
            livro.dadosFormatados();
        }
    }

    public void cadastrarCliente() throws Exception
    {
        System.out.println("CPF: ");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        if (this.clienteJaCadastrado(cpf)) {
            throw new Exception("Cliente já cadastrado.");
        }

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        this.clientes.add(cliente);
        System.out.println("Cliente de cpf: " + cliente.identificador() + " cadastrado com sucesso!");
    }

    public void removerCliente() throws Exception
    {
        System.out.println("CPF do cliente a ser removido: ");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = this.buscarCliente(cpf);

        if (cliente.numAlugueisEmCurso() > 0) {
            throw new Exception("O cliente de cpf " + cliente.identificador() + " nao pode ser removido. Ele esta em locaçao.");
        }

        this.clientes.remove(cliente);
        System.out.println("Cliente de cpf " + cliente.identificador() + " removido com sucesso.");
    }

    public void listarClientes() {
        System.out.println("LISTA DE CLIENTES\n");
        for (Cliente cliente : this.clientes) {
            cliente.dadosFormatados();
        }
    }

    public void registrarAluguel() throws Exception
    {
        System.out.println("Id do livro a ser alocado: ");
        int id = scanner.nextInt();

        if (!this.livroJaCadastrado(id)) {
            throw new Exception("Falha na locaçao. Livro nao cadastrado.");
        }
        scanner.nextLine();

        System.out.println("CPF do cliente a realiazar a locaçao: ");
        int cpf = scanner.nextInt();

        if (!this.clienteJaCadastrado(cpf)) {
            throw new Exception("Falha na locaçao. Cliente nao cadastrado.");
        }


        Cliente cliente = buscarCliente(cpf);
        Livro livro = buscarLivro(id);

        cliente.alugar(livro);
        livro.entrarEmLocacao(cliente);

        Aluguel aluguel = new Aluguel(cliente, livro);

        this.alugueis.add(aluguel);
        System.out.println("Aluguel de id: " + aluguel.idetificador() + " registrado com sucesso!");
    }

    public void removerAluguel() throws Exception
    {
        System.out.println("Id do aluguel a ser removido: ");
        int id = scanner.nextInt();

        Aluguel aluguel = this.buscarAluguel(id);

        if (!this.alugueis.contains(aluguel)) {
            System.out.println("O aluguel nao pode ser removido pois ainda foi registrado e validado na biblioteca.");
            return;
        }

        aluguel.encerrar();

        System.out.println("Aluguel de id: " + aluguel.idetificador() + " finalizado.");
    }

    public void listarTodosAlugueis()
    {
        System.out.println("LISTA GERAL DE ALUGUEIS: \n");

        for (Aluguel aluguel : this.alugueis) {
            aluguel.dadosFormatados();
        }
    }

    //public void listarAlugueisPorData() throws Exception
    //{
    //    System.out.println("Data mínima: (dd-mm-yyyy)");
    //    String minData = scanner.nextLine();
    //
    //    System.out.println("Data máxima: (dd-mm-yyyy)");
    //    String maxData = scanner.nextLine();
    //
    //    SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
    //
    //    Date minDataCovertida = formatador.parse(minData);
    //    Date maxDataConvertida = formatador.parse(maxData);
    //
    //    System.out.println("Alugueis listados entre " + minDataCovertida + " e " + maxDataConvertida);
    //
    //    for (Aluguel aluguel: this.alugueis) {
    //        if (
    //            (aluguel.data().after(minDataCovertida) && aluguel.data().before(maxDataConvertida))
    //            ||
    //            (aluguel.data().equals(minDataCovertida) && aluguel.data().equals(maxDataConvertida))
    //        ) {
    //            aluguel.dadosFormatados();
    //        }
    //    }
    //}

    public void listarAlugueisPorDataCliente() throws Exception
    {

        System.out.println("Forneça o cpf do cliente: ");

        int cpf = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente;

        cliente = this.buscarCliente(cpf);

        System.out.println("Data mínima: (dd-mm-yyyy)");
        String minData = scanner.nextLine();

        System.out.println("Data máxima: (dd-mm-yyyy)");
        String maxData = scanner.nextLine();

        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");

        Date minDataCovertida = formatador.parse(minData);
        Date maxDataConvertida = formatador.parse(maxData);

        System.out.println("Alugueis listados entre " + minData + " e " + maxData + " do cliente de cpf" + cliente.identificador());

        for (Aluguel aluguel: this.alugueis) {
            if (
                (aluguel.data().after(minDataCovertida) && aluguel.data().before(maxDataConvertida))
                && aluguel.cliente() == cliente
            ) {
                aluguel.dadosFormatados();
            }
        }
    }

    public void listarAlugueisPorDataLivro() throws Exception
    {
        System.out.println("Forneça o id do livro: ");

        int id = scanner.nextInt();
        scanner.nextLine();

        Livro livro;

        livro = this.buscarLivro(id);

        System.out.println("Data mínima: (dd-mm-yyyy)");
        String minData = scanner.nextLine();

        System.out.println("Data máxima: (dd-mm-yyyy)");
        String maxData = scanner.nextLine();

        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");

        Date minDataCovertida = formatador.parse(minData);
        Date maxDataConvertida = formatador.parse(maxData);

        System.out.println("Alugueis listados entre " + minDataCovertida + " e " + maxDataConvertida + " do livro de id " + livro.identificador());

        for (Aluguel aluguel: this.alugueis) {
            if (
                (aluguel.data().after(minDataCovertida) && aluguel.data().before(maxDataConvertida))
                && aluguel.livro() == livro
            ) {
                aluguel.dadosFormatados();
            }
        }
    }

    private Cliente buscarCliente(int cpf) throws Exception
    {
        List<Cliente> cliente = this.clientes.stream()
                .filter(item -> item.identificador() == cpf).collect(Collectors.toList());

        if (cliente.size() == 0) {
            throw new Exception("Livro nao encontrado");
        }
        return cliente.get(0);
        //int posicaoCliente;
        //for (Cliente clienteCadastrado: this.clientes) {
        //    if (clienteCadastrado.identificador() == cpf) {
        //        posicaoCliente = this.clientes.indexOf(clienteCadastrado);
        //
        //        return this.clientes.get(posicaoCliente);
        //    }
        //}
        //throw new Exception("Cliente nao encontrado.");
    }

    private Livro buscarLivro(int id) throws Exception
    {
        List<Livro> livro = this.livros.stream()
                .filter(item -> item.identificador() == id).collect(Collectors.toList());

        if (livro.size() == 0) {
            throw new Exception("Livro nao encontrado");
        }
        return livro.get(0);
        //int posicaoLivro;
        //for (Livro livroCadastrado: this.livros) {
        //    if (livroCadastrado.identificador() == id) {
        //        posicaoLivro = this.livros.indexOf(livroCadastrado);
        //        return this.livros.get(posicaoLivro);
        //    }
        //}
        //throw new Exception("Livro nao encontrado.");
    }

    private Aluguel buscarAluguel(int id) throws Exception
    {
        List<Aluguel> aluguel = this.alugueis.stream()
            .filter(item -> item.idetificador() == id).collect(Collectors.toList());

        if (aluguel.size() == 0) {
            throw new Exception("Aluguel nao encontrado");
        }
        return aluguel.get(0);
        //int posicaoAluguel;
        //for (Aluguel aluguelRegistrado: this.alugueis) {
        //    if (aluguelRegistrado.idetificador() == id) {
        //        posicaoAluguel = this.alugueis.indexOf(aluguelRegistrado);
        //        return this.alugueis.get(posicaoAluguel);
        //    }
        //}
        //throw new Exception("Aluguel nao encontrado.");
    }


    private boolean clienteJaCadastrado(int cpf)
    {
        for (Cliente cliente : this.clientes) {
            if (cliente.identificador() == cpf) {
                return true;
            }
        }
        return false;
    }

    private boolean livroJaCadastrado(int id)
    {
        for (Livro livroCadastrado : this.livros) {
            if (livroCadastrado.identificador() == id) {
                return true;
            }
        }
        return false;
    }

}
