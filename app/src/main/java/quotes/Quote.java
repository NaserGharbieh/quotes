package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Quote {
    private String author;
    private String body;

    public Quote(String author, String body) {
        this.author = author;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public  static Quote readQuotes(String path) {
        Quote[] quotes;
        Quote randomQuote;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {  //path="app/src/main/resources/recentquotes.json"
            Gson gson = new Gson();
            quotes = gson.fromJson(reader, Quote[].class);
            Random random = new Random();
            randomQuote = quotes[random.nextInt(quotes.length)];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return randomQuote;
    }



}
