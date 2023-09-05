package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Quote {
    private String author;
    private String text;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
