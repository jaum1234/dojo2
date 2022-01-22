package src.dojo2.menu;

import src.dojo2.entidades.Biblioteca;

import java.util.Scanner;

public class Menu
{
    protected static int escolha;
    protected static Scanner scanner = new Scanner(System.in);
    protected static Biblioteca biblioteca = new Biblioteca();

    public static void call() throws Exception
    {
        MenuPrincipal.render();
    }

    protected static void escolherOpcao()
    {
        while(true) {
            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha >= 1 && escolha <= 4) {
                break;
            }
            System.out.println("Opçao inválida. Tente novamente.");
        }
    }
}
