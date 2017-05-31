import org.apache.commons.io.IOUtils;

import java.util.regex.Pattern;

/**
 * Created by mollyarant on 5/31/17.
 */
public class Finder {
    private String [] dataOutputArray;
    private String result;
    final Pattern ENTIRETEXTFILESPLITTER= Pattern.compile("##");
    final Pattern NAME= Pattern.compile("(^\\w{4}:)((\\w+);)");
    final Pattern PRICE= Pattern.compile("(\\w{5}:)(\\d\\.\\d{2};)");
    final Pattern TYPEFOOD= Pattern.compile("(\\w{4}:\\w{4}[;^%*!@])");
    final Pattern EXPIRATIONDATE= Pattern.compile("expiration:\\d\\/\\d{2}\\/\\d{4}");



    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }


    public String[] splitTextFile(String reader){
        dataOutputArray= ENTIRETEXTFILESPLITTER.split(reader);
        return dataOutputArray;
    }

    






}
