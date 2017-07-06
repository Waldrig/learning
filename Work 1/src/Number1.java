import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Waldrig on 06.07.2017.
 */

//1. Напишите программу, которая считывает символы пока не встретится точка. Также предусмотрите вывод количества пробелов


public class Number1 {
    public static void main (String [] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        String input = r.readLine(); //считываем строку пользователя
        char [] symbols = input.toCharArray(); //перевод строки пользователя в массив символов

        for (int i = 0; i < symbols.length; i++ ){
            if (symbols[i] == ' '){
                counter++;
            } else if (symbols[i] == '.'){
                break;
            }
        }
        System.out.println(counter);
    }

}
