import java.util.ArrayList;

/**
 * Created by Waldrig on 11.07.2017.
 */
public class Info {

    private int SpaceCounter;
    private int StrLength;
    private int WordCounter;
    private int PalinCounter;
    private int SentenceCounter;
    private int WordInSentCounter;
    private char [] symbols;
    private String Sentence;



    public void AmountOfSymbols (String str){
        Sentence = str;
        symbols = str.toCharArray();
        for (int i = 0; i < symbols.length; i++){
            if (symbols[i] == ' '){
                SpaceCounter++;
            }
        }
        StrLength = symbols.length;
        System.out.println("Длина строки: " + StrLength);
        System.out.println("Длина строки без пробелов: "+ (StrLength-SpaceCounter));
    }


    public void AmountOfWords (char chose){

            for (int i = 0; i < symbols.length; i++) {
                if (symbols[i] == ' ') {
                    WordCounter++;
                    WordInSentCounter++;
                }
                if (symbols[i] == chose) {
                    SentenceCounter++;

                    if (SentenceCounter > 1) {
                        System.out.println("В предложении №" + SentenceCounter + " " + WordInSentCounter + " слов");
                        WordInSentCounter = 0;
                    } else {
                        System.out.println("В предложении №" + SentenceCounter + " " + (WordInSentCounter + 1) + " слов");
                        WordInSentCounter = 0;
                    }
                }

            }
            System.out.println("Количество предложений: " + WordCounter);
        System.out.println("Общее количество слов: " + (SpaceCounter+1));

    }


    public void Words() {
        String text = Sentence;
        String tmp = "";
        String maxWord = "";
        String minWord = text;

        for (int i = 0; i <= text.length(); i++){
            if (i == text.length() || text.charAt(i) == ' '){
                maxWord = maxWord.length() < tmp.length() ? tmp : maxWord;
                if (tmp.length() > 2) {
                    minWord = minWord.length() > tmp.length() ? tmp : minWord;
                }
                tmp = "";
            }
            else tmp += text.charAt(i);
        }

        System.out.println("Самое длинное слово: " + maxWord);
        System.out.println("Самое короткое слово: " + minWord);
    }


    public void isPalindrom () {
        String text[] = Sentence.trim().split("[^A-Za-zА-Яа-яЁё]");

        ArrayList <String> list = new ArrayList<>();

        for (int i = 0; i < text.length; i++){
            String reversed = new StringBuilder(text[i]).reverse().toString();

            if (text[i].equalsIgnoreCase(reversed)){
                if (text[i].length() > 2) {
                    list.add(text[i]);
                    PalinCounter++;
                }
                }
            }

        System.out.print("Текст содержит " + PalinCounter +  " палиндром(ов): ");
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toUpperCase());
        }
    }
}
