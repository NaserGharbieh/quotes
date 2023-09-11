package quotes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Quotes {
    private String author;
    private String text;
    private Quote quote;
    private Quotes ApiQuote;

    public static ArrayList<Quotes> quotesData =new ArrayList<>();

    public Quotes() {

    }



    public  static Quotes readQuotesFromFile() {
        Quotes randomQuote =null ;
        Quotes[]quotes;
        try (BufferedReader reader = new BufferedReader(new FileReader("app/src/main/resources/recentquotes.json"))) {
            Gson gson = new Gson();
            quotes=gson.fromJson(reader, Quotes[].class);
            quotesData.addAll( Arrays.asList(quotes));
            Random random = new Random();
            randomQuote = quotesData.get(random.nextInt(quotesData.size()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomQuote;
    }

    public static Quotes readQuotesFromApi() {
        Quotes myQuote  ;

        try {
            Gson gson = new Gson();
          URL  apiUrl = new URL("https://favqs.com/api/qotd");
            HttpURLConnection apiUrlConnection = (HttpURLConnection) apiUrl.openConnection();
            apiUrlConnection.setRequestMethod("GET");

            InputStreamReader streamReader = new InputStreamReader(apiUrlConnection.getInputStream());
            BufferedReader apiBufferedReader = new BufferedReader(streamReader);
            String quoteData = apiBufferedReader.readLine();
            apiBufferedReader.close();


            gson = new GsonBuilder().setPrettyPrinting().create();
            myQuote = gson.fromJson(quoteData, Quotes.class);


            // Append the new quote to the original data
            quotesData.add(myQuote);
            System.out.println(quotesData.size());
            System.out.println(quotesData);
            // Write the updated list back to the JSON file
            WriteToFile("app/src/main/resources/writeRecentquotes.json",quotesData);
            return myQuote;

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            myQuote = readQuotesFromFile(); // Read from the file
            System.out.println("Error: " + e);
        }
        return myQuote;
    }
    public static void  WriteToFile(String path,ArrayList<Quotes> apiQuotes) {
        try(FileWriter writer = new FileWriter(new File(path))) {
//
           Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(apiQuotes, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();        }
    }

    @Override
    public String toString() {
        if (author == null) //  read throw the api
            return "Quotes{" +
                    quote +
                    '}';
        else  // read throw file
            return "Quotes{" +
                    "author='" + author + '\'' +
                    ", text='" + text + '\'' +
                    '}';
    }
    }

