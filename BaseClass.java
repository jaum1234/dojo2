package src.dojo2;

import java.util.Scanner;

abstract public class BaseClass
{
    protected static Scanner scanner = new Scanner(System.in);

    protected void output(String output)
    {
        System.out.println(output);
    }
}
