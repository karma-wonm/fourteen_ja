import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterMovieTest {

    PurchaseItem item1 = new PurchaseItem("jojo");
    PurchaseItem item2 = new PurchaseItem("lolo");
    PurchaseItem item3 = new PurchaseItem("koko");
    PurchaseItem item4 = new PurchaseItem("popo");
    PurchaseItem item5 = new PurchaseItem("momo");
    PurchaseItem item6 = new PurchaseItem("nono");
    PurchaseItem item7 = new PurchaseItem("bobo");
    PurchaseItem item8 = new PurchaseItem("vovo");
    PurchaseItem item9 = new PurchaseItem("xoxo");
    PurchaseItem item10 = new PurchaseItem("dodo");

    PosterMovie poster = new PosterMovie();

    @Test
    void AddNewMovie() {
        PurchaseItem item = new PurchaseItem("mind");
        poster.save(item1);
        poster.save(item);
        PurchaseItem[] expected = {item1, item};
        PurchaseItem[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        PurchaseItem item = new PurchaseItem("mind");
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);
        poster.save(item);
        PurchaseItem[] expected = {item1, item2, item3, item4, item};
        PurchaseItem[] actual = poster.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findLast() {
        PurchaseItem item = new PurchaseItem("mind");
        int lastMovie = 3;
        PosterMovie movie = new PosterMovie(3);
        movie.save(item1);
        movie.save(item2);
        movie.save(item3);
        movie.save(item4);
        movie.save(item);

        PurchaseItem[] expected = {item, item4, item3};
        PurchaseItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findLastNoParameter() {
        PurchaseItem item = new PurchaseItem("mind");
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);
        poster.save(item5);
        poster.save(item6);
        poster.save(item7);
        poster.save(item8);
        poster.save(item9);
        poster.save(item10);
        poster.save(item);

        PurchaseItem[] expected = {item, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        PurchaseItem[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);
        int id = 2;

        PurchaseItem expected = item2;
        PurchaseItem actual = poster.findById(id);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void removeByIdTest() {
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);
        int id = 2;
        poster.removeById(id);

        PurchaseItem[] expected = {item1, item3, item4};
        PurchaseItem[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void removeAllTest(){
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);

        poster.removeAll();

        PurchaseItem[] expected = {null,null,null,null};
        PurchaseItem[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
