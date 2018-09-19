import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class webScrapper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main (String[] unUsed) {
        String wholeURL = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String allWords []  = wholeURL.split(" ");
        int wordCount = allWords.length;
        System.out.println("The URL contained " + wordCount + " words.");
        String word = "prince";
        int count = 0;
        for (String i : allWords){
            if(i.toLowerCase().contains(word)){
                count++;
            }
        }
        System.out.println("The URL contained " + word + " " + count + " times.");

    }

}
