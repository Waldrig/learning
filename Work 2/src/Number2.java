import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Waldrig on 07.07.2017.
 */

//2. Сила тяжести на Луне примерно равна 17%, напишите программу, которая вычисляет ваш вес на Луне.

public class Number2 {
    public static void main (String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Давайте вычислим ваш вес на лучне");
        System.out.print("Введите ваш вес: ");

        int weight = Integer.parseInt(r.readLine());
        System.out.println(math(weight));
    }

    public static double math (int x) {
        return (x*0.16);
    }
}
