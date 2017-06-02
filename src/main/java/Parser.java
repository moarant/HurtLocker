import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mollyarant on 5/31/17.
 */
public class Parser extends IOException {
    private String[] dataOutputArray;
    private String result;
    final Pattern ENTIRETEXTFILESPLITTER= Pattern.compile("##");
    final Pattern ALLTHEREGEX= Pattern.compile("(^\\w{4}:)((\\w+);)(\\w{5}:)(\\d\\.\\d{2};)(\\w{4}:\\w{4}[;^%*!@])(expiration:\\d\\/\\d{2}\\/\\d{4})");
    final Pattern NAME= Pattern.compile("(^\\w{4}:)((\\w+);)");
    final Pattern PRICE= Pattern.compile("(\\w{5}:)(\\d\\.\\d{2};)");
    final Pattern TYPEFOOD= Pattern.compile("(\\w{4}:\\w{4}[;^%*!@])");
    final Pattern EXPIRATIONDATE= Pattern.compile("expiration:\\d\\/\\d{2}\\/\\d{4}");
    ArrayList <String> OriginalDataOutput = new ArrayList<String>();
    ArrayList<Item> ItemList= new ArrayList<Item>();
    private int errorCounter=0;




    public ArrayList <String> splitTextFile(String file){
       String [] temp=ENTIRETEXTFILESPLITTER.split(file);
       for(int i=0;i<temp.length;i++){
           OriginalDataOutput.add(temp[i]);
       }
        return OriginalDataOutput;

    }

    public Item makeItem(String line) throws IllegalArgumentException{
        String name= readName(line);
        String price=readPrice(line);
        String type= readType(line);
        String expiration= readExpiration(line);
        return new Item(name, price, type, expiration);
    }

   public ArrayList<Item> makeItems(ArrayList <String> list){
        for(int i=0;i<list.size();i++){
            Item newItem= makeItem(list.get(i));
            ItemList.add(newItem);
        }
        return ItemList;
   }

    public String readName(String line)throws IllegalArgumentException{
        Matcher name= Pattern.compile("([n|N]\\w{3}:)(\\w+)").matcher(line);
        if(name.find()){
            return name.group(2);
        }
        else{
            errorCounter+=1;
            throw new IllegalArgumentException("this is missing a value");
        }
    }

    public String readPrice(String line) throws IllegalArgumentException{
        Matcher price= Pattern.compile("([p|P]\\w{4}:)(\\d\\.\\d{2})").matcher(line);
        if(price.find()){
            return price.group(2);
        }
        else{
            errorCounter+=1;
            throw new IllegalArgumentException("this is missing a value");
        }
    }

    public String readType(String line) throws IllegalArgumentException{
        Matcher type= Pattern.compile("(type:)(Food)").matcher(line);
        if(type.find()){
            return type.group(2);
        }
        else{
            errorCounter+=1;
            throw new IllegalArgumentException("this is missing a value");
        }
    }

    public String readExpiration(String line) throws IllegalArgumentException{
        Matcher expiration= Pattern.compile("(expiration:)(\\d\\/\\d{2}\\/\\d{4})").matcher(line);
        if(expiration.find()){
            return expiration.group(2);
        }
        else{
            errorCounter+=1;
            throw new IllegalArgumentException("this is missing a value");
        }
    }
















































}
