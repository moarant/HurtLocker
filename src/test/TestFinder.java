import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mollyarant on 5/31/17.
 */
public class TestFinder {
    Finder finder;
    @Before
    public void setUp() {
        finder = new Finder();
    }


    @Test
    public void testSplitTextFile() {
        //given
        String stringToSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        String [] expected= {"naMe:Milk;price:3.23;type:Food;expiration:1/25/2016", "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016", "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016"};
        //when
        String [] actual = finder.splitTextFile(stringToSplit);

        //then
        Assert.assertEquals("should split into an array",expected , actual);

    }

    @Test

    public void testSplitTextFilelength() {
        //given
        String stringToSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        int expectedArrayLength= 3;
        //when
        int actual = finder.splitTextFile(stringToSplit).length;

        //then
        Assert.assertEquals("should split into an array",expectedArrayLength , actual);

    }







}
