import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Waldrig on 11.07.2017.
 */
public class Menu {
    public static void main (String [] args){
        Info info = new Info();
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите свою строку: ");
            String str = r.readLine();
            System.out.println("Введите символ разделения предложений: ");
            char symbol = (char) r.read();
            info.AmountOfSymbols(str);
            info.AmountOfWords(symbol);
            info.Words();
            info.isPalindrom();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
