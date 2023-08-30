/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println(quotePrint());

    }
    public static String quotePrint(){
        Quote randomQuote=null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\NASER GHARBIEH\\projects\\quotes\\app\\src\\main\\resources\\recentquotes.json"));
            Gson gson = new Gson();

            Type quoteListType = new TypeToken<List<Quote>>() {
            }.getType();
            List<Quote> quotesFromFile = gson.fromJson(bufferedReader, quoteListType);


            Random random = new Random();
            int randomIndex = random.nextInt(quotesFromFile.size());
             randomQuote = quotesFromFile.get(randomIndex);



        } catch (IOException e) {
            e.printStackTrace();
        }

        return ("Quote from file: " + randomQuote.toString());
    }


    public void WriteQout() {

        Quote motivation = new Quote("Daivid Gogins", "Who will carry the BOATS and THE LOGS");


        Gson gson = new Gson();


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\NASER GHARBIEH\\projects\\quotes\\app\\src\\main\\resources\\writeRecentquotes.json");
            String json = gson.toJson(motivation);
            fileWriter.write(json);


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    ;
                }

            }
        }


    }
}

