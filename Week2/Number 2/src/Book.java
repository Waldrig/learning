import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Waldrig on 19.07.2017.
 */
public class Book {
    //Написать класс Книга.
    //Поля класса: Кол-во страниц, разделы кол-во. Автор, название. переплет. ISBN. цена. Издание. год издания.
    private int position;
    private int numberOfpages;
    private int numberOfPartitions;
    private String nameOfAuthor;
    private String nameOfBook;
    private String typeOfBinding;
    private String ISBN;
    private int price;
    private int edition;
    private int yearOfEdition;


    public Book(int numberOfpages, int numberOfPartitions,
                String nameOfAuthor, String nameOfBook,
                int binding,
                String ISBN, int price, int eition,
                int yearOfEdition) {
        HashMap<Integer, String> mapBinding = new HashMap<>();
        mapBinding.put(1, "Твердый переплет");
        mapBinding.put(2, "Мягкий переплет");
        mapBinding.put(3, "Скрепление на пружине");
        mapBinding.put(4, "Скрепление скобой");

        this.numberOfpages = numberOfpages;
        this.numberOfPartitions = numberOfPartitions;
        this.nameOfAuthor = nameOfAuthor;
        this.nameOfBook = nameOfBook;
        this.typeOfBinding = mapBinding.get(binding);
        this.ISBN = ISBN;
        this.price = price;
        this.edition = eition;
        this.yearOfEdition = yearOfEdition;
}



    public int getNumberOfpages() {

        return numberOfpages;
    }

    public int getNumberOfPartitions() {

        return numberOfPartitions;
    }

    public String getNameOfAuthor() {

        return nameOfAuthor;
    }

    public String getNameOfBook() {

        return nameOfBook;
    }


    public String getTypeOfBinding() {

        return typeOfBinding;
    }

    public String getISBN() {

        return ISBN;
    }

    public int getPrice() {

        return price;
    }

    public int getEdition() {

        return edition;
    }

    public int getYearOfEdition() {

        return yearOfEdition;
    }


}
