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
    private Book first = new Book(1, "Name1", 10, "Author1");
    private Book second = new Book(2, "Name2",20, "Author2");
    private Book third1 = new Book(3, "Name3", 30, "Author3");
    private Book third2 = new Book(4, "Name4", 40, "Author3");
    private Smartphone fourth = new Smartphone(5, "Bereza", 100, "Our1");
    private Smartphone fifth = new Smartphone(6, "Topol", 200, "Our2");
    private Smartphone sixth1 = new Smartphone(7, "Dub", 300, "Our3");
    private Smartphone sixth2 = new Smartphone(8, "Lipa", 500, "Our3");

    @Test
    public void shouldSearchByProduct() {
        manager.add(first);
        manager.add(second);
        manager.add(third1);
        manager.add(third2);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth1);
        manager.add(sixth2);

        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Author1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducts() {
        manager.add(first);
        manager.add(second);
        manager.add(third1);
        manager.add(third2);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth1);
        manager.add(sixth2);

        Product[] expected = new Product[]{sixth1,sixth2};
        Product[] actual = manager.searchBy("Our3");
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchByNotProduct() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Iva");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByNotProduct2(){

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("");
        assertArrayEquals(expected, actual);

    }
}


