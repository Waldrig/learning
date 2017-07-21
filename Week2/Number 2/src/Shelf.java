import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Waldrig on 19.07.2017.
 */
public class Shelf {
    //   Написать класс Полка.
    // Функции класса: Хранение книг. Поиск по полям книги. Кол-во на полке. Удаление книг.
    private List<Book> books = new ArrayList<>();

    public void addBooks(Book book) {
        this.books.add(book);
    }

    static Comparator<Book> sorter = new Comparator<Book>() {
        public int compare(Book o1, Book o2) {
            return o1.getNameOfBook().compareTo(o2.getNameOfBook());
        }
    };


    public void operationsWithShelf() throws IOException {
        int choise;
        int positionOfBook;
        String partOfName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("\n1. Вывести все книги на полке");
            System.out.println("2. Вывести информацию о книге");
            System.out.println("3. Убрать книгу с полки");
            System.out.println("4. Отсортировать по алфавиту");
            System.out.println("5. Найти книгу по названию");
            System.out.println("0. Выход");

            choise = Integer.parseInt(reader.readLine());
            switch (choise) {
                case 1:
                    System.out.println("Общее количество книг на полке: " + books.size());
                    for (int i = 0; i < books.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        System.out.println(books.get(i).getNameOfBook());
                    }
                    break;
                case 2:
                    System.out.println("Введите позицию книги");
                    positionOfBook = Integer.parseInt(reader.readLine());
                    if (positionOfBook <= books.size()) {
                        System.out.println("Название книги: " + books.get(positionOfBook - 1).getNameOfBook());
                        System.out.println("Автор: " + books.get(positionOfBook - 1).getNameOfAuthor());
                        System.out.println("Издание: " + books.get(positionOfBook - 1).getEdition());
                        System.out.println("Количество страниц: " + books.get(positionOfBook - 1).getNumberOfpages());
                        System.out.println("Количество пунктов: " + books.get(positionOfBook - 1).getNumberOfPartitions());
                        System.out.println("Год издания: " + books.get(positionOfBook - 1).getYearOfEdition());
                        System.out.println("Переплет: " + books.get(positionOfBook - 1).getTypeOfBinding());
                        System.out.println("ISBN: " + books.get(positionOfBook - 1).getISBN());
                        System.out.println("Цена: " + books.get(positionOfBook - 1).getPrice());
                    } else {
                        System.out.println("Эта опзиция пуста, в ней нет книги.");
                    }
                    break;
                case 3:
                    System.out.println("Введите позицию книги для удаления");
                    positionOfBook = Integer.parseInt(reader.readLine());
                    if (positionOfBook <= books.size()) {
                        books.remove(positionOfBook);
                        System.out.println("Книга удалена");
                    } else {
                        System.out.println("Эта опзиция пуста, в ней нет книги.");
                    }
                    break;
                case 4:                                                       //По желанию хранение по алфавиту
                    Collections.sort(books, sorter);

                    for (int i = 0; i < books.size(); i++) {
                        System.out.println(books.get(i).getNameOfBook());
                    }
                    break;
                case 5:
                    int amount;
                    System.out.println("Введите часть названия книги");
                    partOfName = reader.readLine();
                    System.out.println("Введите количество записей");
                    amount = Integer.parseInt(reader.readLine());
                    searchByPartOfName(partOfName, amount);
                    break;

            }
        } while (choise != 0);
    }

    // Возможность поиска книг по названию, выводить не более 10 результатов. например: ввод “Бу” -> Букварь, Бульба…
    public void searchByPartOfName(String name, int amountOfPrint) {
        if (amountOfPrint <= books.size() && amountOfPrint <= 10) {
            for (int i = 0; i < amountOfPrint; i++) {
                if (books.get(i) != null) {
                    if (books.get(i).getNameOfBook().toLowerCase().contains(name.toLowerCase())) {
                        System.out.println(books.get(i).getNameOfBook());
                    } else {
                        System.out.println("Совпадений не найдено");
                    }
                }
            }
        } else {
            System.out.println("Вы пытаетесь вывести несуществующие данные, попытайтесь снова");
        }
    }
}


