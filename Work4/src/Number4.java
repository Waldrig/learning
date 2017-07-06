import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Waldrig on 07.07.2017.
 */
//4. Напишите метод, заменяющий в строке все вхождения слова «бяка» на «вырезано цензурой».
public class Number4 {
    public static void main (String [] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку: ");
        String str = r.readLine();

        for (String result : str.split(" ")){
            for (int i = 0; i < result.length(); i++){
                if (result.equals("бяка")){
                    result = "вырезано цензурой";
                }
            }
            System.out.print(result + " ");
        }
    }
}
