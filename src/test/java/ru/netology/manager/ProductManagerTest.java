package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book first = new Book(1, "Name1", 10, "Author1");
    Book second = new Book(2, "Name2", 20, "Author2");
    Book third1 = new Book(3, "Name3", 30, "Author3");
    Book third2 = new Book(4, "Name4", 40, "Author4");
    Smartphone fourth = new Smartphone(5, "Bereza", 100, "Our1");
    Smartphone fifth = new Smartphone(6, "Topol", 200, "Our2");
    Smartphone sixth1 = new Smartphone(7, "Dub", 300, "Our3");
    Smartphone sixth2 = new Smartphone(8, "Lipa", 500, "Our5");

    @Test
    public void shouldSearchByBookAuthor() {
        manager.add(first);
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Author1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneManufacturer() {
        manager.add(sixth1);
        Product[] expected = new Product[]{sixth1};
        Product[] actual = manager.searchBy("Our3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        manager.add(second);
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Name2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        manager.add(fourth);
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Bereza");
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBySomeBookAuthor() {
        manager.add(third1);
        manager.add(third2);

        Product[] expected = new Product[]{third1};
        Product[] actual = manager.searchBy("Author3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySomeBookName() {
        manager.add(first);
        manager.add(second);
        manager.add(third1);

        Product[] expected = new Product[]{third1};
        Product[] actual = manager.searchBy("Name3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotBook() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Name3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySomeSmartphoneManufacturer() {

        manager.add(sixth2);

        Product[] expected = new Product[]{sixth2};
        Product[] actual = manager.searchBy("Our3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySomeSmartphoneName() {
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth1);

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Bereza");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotSmartphone() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Dub");
        assertArrayEquals(expected, actual);
    }
}

