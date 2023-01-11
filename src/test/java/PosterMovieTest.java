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
    void findLastPurchaseItemMoreLimit() {
        PurchaseItem item = new PurchaseItem("mind");
        int lastMovie = 3;
        PosterMovie movie = new PosterMovie(lastMovie);
        movie.save(item1);
        movie.save(item2);
        movie.save(item3);
        movie.save(item4);
        movie.save(item);

        PurchaseItem[] expected ={item, item4, item3};
        PurchaseItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void findLastPurchaseItemUnderLimit(){
        PurchaseItem item = new PurchaseItem("mind");
        int lastMovie = 8;
        PosterMovie movie = new PosterMovie(lastMovie);
        movie.save(item1);
        movie.save(item2);
        movie.save(item3);
        movie.save(item4);
        movie.save(item);

        PurchaseItem[] expected ={item, item4, item3, item2, item1};
        PurchaseItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void findLastPurchaseItemEqualsLimit(){
        PurchaseItem item = new PurchaseItem("mind");
        int lastMovie = 5;
        PosterMovie movie = new PosterMovie(lastMovie);
        movie.save(item1);
        movie.save(item2);
        movie.save(item3);
        movie.save(item4);
        movie.save(item);

        PurchaseItem[] expected ={item, item4, item3, item2, item1};
        PurchaseItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    void findLastNoParameter() {
        PurchaseItem item = new PurchaseItem("mind");
        PosterMovie movie = new PosterMovie();
        movie.save(item1);
        movie.save(item2);
        movie.save(item3);
        movie.save(item4);
        movie.save(item5);
        movie.save(item6);
        movie.save(item7);
        movie.save(item8);
        movie.save(item9);
        movie.save(item10);
        movie.save(item);

        PurchaseItem[] expected ={item, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        PurchaseItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
