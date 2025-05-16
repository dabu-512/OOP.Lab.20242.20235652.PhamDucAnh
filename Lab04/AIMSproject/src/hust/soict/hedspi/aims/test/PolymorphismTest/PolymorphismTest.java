package hust.soict.hedspi.aims.test.PolymorphismTest;

import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Interstellar", "Sci-Fi", 30.0f, "Nolan", 169);
        Book book = new Book(5, "Clean Code", "Programming", 20.5f);
        book.addAuthor("Robert C. Martin");
        CompactDisc cd = new CompactDisc(9, "Taylor's Hits", "Pop", 25.0f, "Producer", 12, "Taylor Swift");

        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);

        for (Media m : mediaList) {
            System.out.println(m.toString()); // polymorphism in action
        }
    }
}