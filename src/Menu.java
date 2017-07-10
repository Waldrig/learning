import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Waldrig on 10.07.2017.
 */
public class Menu {
    public static void main (String [] args) {
        int chose, chose2, size, IntegerSymbol, max, min, index;
        int counter = 0;
        String StringSymbol;
        char CharacterSymbol;
        int arr[] = new int[0];
        Logic logic = new Logic();
        try {

            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            do {

                System.out.println("Ввыберите тип массива");
                System.out.println("1. Integer");
                System.out.println("2. String");
                System.out.println("3. Character");
                System.out.println("4. Удалить указанное значение из массива");
                System.out.println("0. Выйти");
                chose = Integer.parseInt(r.readLine());

                start: switch (chose) {
                    case 1:
                        System.out.println("1. Ввести числа для массива");
                        System.out.println("2. Заполнить массив указанной длины случайными числами");
                        chose2 = Integer.parseInt(r.readLine());

                            switch (chose2) { //Начиная отсюда
                                case 1:
                                    System.out.println("Введите размер массива: ");
                                    size = Integer.parseInt(r.readLine());
                                    System.out.println("Введие число которым заполнить массив: ");
                                    IntegerSymbol = Integer.parseInt(r.readLine());
                                    arr = logic.IntegerArray(size, IntegerSymbol);
                                    counter ++;
                                    break start;
                                case 2:
                                    System.out.println("Введите размер массива: ");
                                    size = Integer.parseInt(r.readLine());
                                    System.out.println("Введите минимальное значение рандома: ");
                                    min = Integer.parseInt(r.readLine());
                                    System.out.println("Введите максимальное значение рандома: ");
                                    max = Integer.parseInt(r.readLine());
                                    arr = logic.IntegerArrayRndm(size, min, max);
                                    counter ++;
                                    break start;
                            } //Заканчивая тут. Криво работает выбор (если выбрать что-то другое помимо 1 или 2 запустит case1;
                        //Но если пользователь послушный то проблем не будет)


                    case 2:
                        System.out.println("Введите размер массива: ");
                        size = Integer.parseInt(r.readLine());
                        System.out.println("Введие символ для заполнения массива: ");
                        StringSymbol = r.readLine();
                        logic.StringArray(size, StringSymbol);
                        break;
                    case 3:
                        System.out.println("Введите размер массива: ");
                        size = Integer.parseInt(r.readLine());
                        System.out.println("Введие символ для заполнения массива: ");
                        CharacterSymbol = (char) r.read();
                        logic.CharacterArray(size, CharacterSymbol);
                        break;
                    case 4:
                        if (counter > 0) {
                            System.out.println("Введите порядковый номер числа которое следует удалить: ");
                            index = Integer.parseInt(r.readLine());
                            logic.RemoveFromArray(index, arr);
                            break;
                        } else {
                            System.out.println("Сначала сгенерируйте массив типа Integer\n");

                        }
                }

            }while (chose != 0);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

