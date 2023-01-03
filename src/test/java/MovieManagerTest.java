import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

 //   PosterMovie poster = Mockito.mock(PosterMovie.class);
    PosterMovie poster = new PosterMovie();
    //PosterMovie posterLast = new PosterMovie(int lastMovie);
    MovieManager manage = new MovieManager(poster);
   // MovieManager manageLast = new MovieManager(posterLast);

    PurchaseItem item1 = new PurchaseItem("jojo", 1);
    PurchaseItem item2 = new PurchaseItem("lolo", 2);
    PurchaseItem item3 = new PurchaseItem("koko", 3);
    PurchaseItem item4 = new PurchaseItem("popo", 4);
    PurchaseItem item = new PurchaseItem("mind", 0);

    @BeforeEach
    public void setup() {
        manage.add(item1);
        manage.add(item2);
        manage.add(item3);
        manage.add(item4);
        //manage.add(item);
    }

    @Test
    public void testReverseAll() {

        PurchaseItem[] jojo = manage.getAll();
        PurchaseItem[] expected = {item4, item3, item2, item1};
        PurchaseItem[] actual = manage.getItems() ;

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSave(){
        manage.add(item);

        PurchaseItem[] expected = {item1, item2, item3, item4, item};
        PurchaseItem[] actual = manage.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindById(){
        int idfind = 3;
        manage.findByIdObject(idfind);


        PurchaseItem expected = item3;
        PurchaseItem actual = manage.findByIdObject(idfind);

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testRemoveById(){
        int idremove = 2;
        manage.removeById(idremove);

        PurchaseItem[] expected = {item1,item3,item4};
        PurchaseItem[] actual = manage.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }
//    @Test
//    public void testRemoveByIdNonExistent(){
//        int idremove = 100;
//        manage.removeById(idremove);
//        PurchaseItem[] expected = {item1,item2,item3,item4};
//        PurchaseItem[] actual = manage.getAll();
//
//        Assertions.assertArrayEquals(expected, actual);
//
//    }
    @Test
    public void testRemoveAll(){
        manage.removeAll();

        PurchaseItem[] expected = {null, null, null, null};
        PurchaseItem[] actual = manage.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
