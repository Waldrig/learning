import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Waldrig on 19.07.2017.
 */

/*
Задание 2
Написать класс Книга.
Поля класса: Кол-во страниц, разделы кол-во. Автор, название. переплет. ISBN. цена. Издание. год издания.
Написать класс Полка.
Функции класса: Хранение книг. Поиск по полям книги. Кол-во на полке. Удаление книг.
По желанию:  Хранение книг в алфавитном порядке. Возможность поиска книг по названию, выводить не более 10 результатов. например: ввод “Бу” -> Букварь, Бульба…
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Shelf shelf = new Shelf();
        Book bookOne = new Book(60,6,
                "Testing Author",
                "Тест", 1, "34567891", 600, 2, 1997);
        Book bookTwo = new Book(60,6,
                "Testing Author",
                "Тестовая", 1, "34567891", 600, 2, 1997);
        Book bookThree = new Book(60,6,
                "Testing Author",
                "Тестовая книга", 1, "34567891", 600, 2, 1997);
        shelf.addBooks(bookOne);
        shelf.addBooks(bookTwo);
        shelf.addBooks(bookThree);
        shelf.operationsWithShelf();
    }
}
