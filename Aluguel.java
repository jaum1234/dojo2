package src.dojo2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Aluguel extends BaseClass
{
    private static int id = 0;
    private int aluguelId;
    private Cliente cliente;
    private Livro livro;
    private Date data;

    public Aluguel(Cliente cliente, Livro livro)
    {
        this.id++;
        this.aluguelId = this.id;
        this.cliente = cliente;
        this.livro = livro;


        this.output("Aluguel de id " + this.aluguelId + " criado! Para ser validado, precisa ser registrado na biblioteca.");
    }

    public int id()
    {
        return this.aluguelId;
    }

    public Date data()
    {
        return this.data;
    }


    public void setData()
    {
        this.data = new Date();
    }

    /**
     * Método só deve ser chamado de dentro do método 'removerAluguel'
     * na classe Biblioteca
     *
     * @see src.dojo2.Biblioteca#removerAluguel(Aluguel)
     */
    public void encerrar() throws Exception
    {
        this.cliente.desalugar(this.livro);
        this.livro.sairDaLocacao(this.cliente);
    }

    public Cliente cliente()
    {
        return this.cliente;
    }

    public Livro livro()
    {
        return this.livro;
    }

    public void dadosFormatados()
    {
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = formatador.format(this.data);

        this.output("Id: " + this.aluguelId);
        this.output("Data de realizaçao do aluguel: " + dataFormatada + "\n");

        this.output("CLIENTE:");
        this.cliente.dadosFormatados();

        this.output("LIVRO:");
        this.livro.dadosFormatados();

        this.output("----------------------------------");
    }
}
