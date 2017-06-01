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

    public void testSplitTextFileLength() {
        //given
        String stringToSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        int expectedArrayLength= 3;
        //when
        int actual = finder.splitTextFile(stringToSplit).length;

        //then
        Assert.assertEquals("should split into an array",expectedArrayLength , actual);

    }

    @Test

    public void testReadNamePullName(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expectedGroup2= "Milk";
        //when
        String actual= finder.readName(stringtoSplit);
        //then
        Assert.assertEquals("should return the name of the product", expectedGroup2, actual);
    }
    @Test
    public void testReadPricePullPrice(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expectedGroup2= "3.23";
        //when
        String actual= finder.readPrice(stringtoSplit);
        //then
        Assert.assertEquals("should return the price of the product", expectedGroup2, actual);
    }

    @Test
    public void testReadTypePullType(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expectedGroup2= "Food";
        //when
        String actual= finder.readType(stringtoSplit);
        //then
        Assert.assertEquals("should return Food", expectedGroup2, actual);
    }
    @Test
    public void testReadExpirationPullExpiration(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expectedGroup2= "1/25/2016";
        //when
        String actual= finder.readExpiration(stringtoSplit);
        //then
        Assert.assertEquals("should return the expiration date", expectedGroup2, actual);
    }
    @Test
    public void testMakeNewItem(){
        //given
        String stringToSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        Item expected=new Item("Milk", "3.23", "Food","1/25/2016");
        //when
        Item actual=finder.makeItem(stringToSplit);
        //then
        Assert.assertEquals("should produce a new item",expected,actual );
    }









}
