import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by mollyarant on 5/31/17.
 */
public class TestParser {
    Parser parser;
    @Before
    public void setUp() {
        parser = new Parser();
    }


    @Test
    public void testSplitTextFile() {
        //given
        String stringToSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        String expected="naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        //when
        String actual= parser.splitTextFile(stringToSplit).get(0);

        //then
        Assert.assertEquals("should split into an array",expected , actual);

    }

    @Test

    public void testSplitTextFileLength() {
        //given
        String stringToSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        int expectedArrayLength= 3;
        //when
        int actual = parser.splitTextFile(stringToSplit).size();

        //then
        Assert.assertEquals("should split into an array",expectedArrayLength , actual);

    }

    @Test

    public void testReadNamePullName(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expectedGroup2= "Milk";
        //when
        String actual= parser.readName(stringtoSplit);
        //then
        Assert.assertEquals("should return the name of the product", expectedGroup2, actual);
    }
    @Test
    public void testReadPricePullPrice(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expectedGroup2= "3.23";
        //when
        String actual= parser.readPrice(stringtoSplit);
        //then
        Assert.assertEquals("should return the price of the product", expectedGroup2, actual);
    }

    @Test
    public void testReadTypePullType(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expectedGroup2= "Food";
        //when
        String actual= parser.readType(stringtoSplit);
        //then
        Assert.assertEquals("should return Food", expectedGroup2, actual);
    }
    @Test
    public void testReadExpirationPullExpiration(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expectedGroup2= "1/25/2016";
        //when
        String actual= parser.readExpiration(stringtoSplit);
        //then
        Assert.assertEquals("should return the expiration date", expectedGroup2, actual);
    }

    @Test
    public void testMakeNewItem(){
        //given
        String stringToSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expected=(new Item("Milk", "3.23", "Food","1/25/2016").toString());
        //when
        String actual= parser.makeItem(stringToSplit).toString();
        //then
        Assert.assertEquals("should produce a new item",expected,actual );

    }

    @Test
    public void testMakeNewItems(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        ArrayList<String> forTest= parser.splitTextFile(stringtoSplit);
        String expected= (new Item("Milk", "3.23", "Food", "1/25/2016").toString());
        //when
        String actual= parser.makeItems(forTest).get(0).toString();
        System.out.println(actual);
        //then
        Assert.assertEquals("should return one item from the new arraylist", expected,actual);
    }

    @Test
    public void testMakeNewItemsArraySize(){
        //given
        String stringtoSplit= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        ArrayList<String> forTest= parser.splitTextFile(stringtoSplit);
        int expected= 3;
        //when
        int actual= parser.makeItems(forTest).size();

        //then
        Assert.assertEquals("should return the size of the new arraylist", expected,actual);
    }














}
