/**
 * Created by Waldrig on 07.07.2017.
 */

//3. Напишите метод, который будет увеличивать заданный элемент массива на 10%.
public class Number3 {
    public static void main (String[] args) {
        int [] arg = {1, 2, 3, 4, 5, 6};
        System.out.println(toten(arg, 2));
    }
    public static double toten (int [] x, int index){
       double result = x [index] * 0.10;
        return result;
    }
}
