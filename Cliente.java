package dojo2;

public class Cliente
{
    String nome;
    String cpf;

    public Cliente(String nome, String cpf)
    {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
