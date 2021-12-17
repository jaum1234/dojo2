package dojo2;

import java.time.LocalDateTime;

public class Aluguel
{
    private Cliente cliente;
    private Livro livro;
    private LocalDateTime data;

    public Aluguel(Cliente cliente, Livro livro)
    {
        this.cliente = cliente;
        this.livro = livro;
        this.data = LocalDateTime.now();
    }

    public LocalDateTime getData() {
        return data;
    }
}
