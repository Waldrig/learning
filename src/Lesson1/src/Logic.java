/**
 * Created by Waldrig on 10.07.2017.
 */
public class Logic {

    public static int[] IntegerArray (int size, int symbol) {
        int [] arr = new int [size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = symbol;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        return arr;
    }


    public static int[] IntegerArrayRndm (int size , int min, int max) {
        int [] arr = new int [size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = min + (int) (Math.random() * max);
        }
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        return arr;
    }


    public static String[] StringArray (int size, String symbol){
        String [] arr = new String[size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = symbol;
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        return arr;
    }


    public static char[] CharacterArray ( int size, char symbol){
        char [] arr = new char[size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = symbol;
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        return arr;
    }


    public static int[] RemoveFromArray (int index, int[] array){
        array[index] = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return array;
    }
}
