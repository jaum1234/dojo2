package src.dojo2.menu;

import src.dojo2.entidades.Biblioteca;

import java.util.Scanner;

public class Menu
{
    protected static int escolha;
    protected static Biblioteca biblioteca = new Biblioteca();
    protected static Scanner scanner = new Scanner(System.in);

    public static void call() throws Exception
    {
        MenuPrincipal.render();
    }

    protected static void escolherOpcao()
    {
        while(true) {
            escolha = scanner.nextInt();

            if (escolha >= 1 && escolha <= 4) {
                break;
            }
            System.out.println("Opçao inválida. Tente novamente.");
        }
    }
}
