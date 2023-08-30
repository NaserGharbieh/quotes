package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
// This is the test file for lab08
public class QuotePrintTest {
    private List<Quote> quotesFromFile;

    @BeforeEach
    public void setUp() {
        // Initialize the list of quotes from the file
        quotesFromFile = new ArrayList<>();
        quotesFromFile.add(new Quote("Marilyn Monroe", "I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love."));
        quotesFromFile.add(new Quote("Author 2", "Quote 2"));
        // Add more quotes as needed
    }

    @Test
    public void testQuotePrint() {
        String result = App.quotePrint().toString();

        // Check if the result contains the expected quote
        for (Quote quote : quotesFromFile) {
            if (result.contains(quote.toString())) {
                return; // Test passed
            }
        }

        // If none of the quotes matched, fail the test
        fail("Expected quote not found in the result");
    }

    // Mocked implementation of createBufferedReader
    private BufferedReader createBufferedReader() {
        return new BufferedReader(new StringReader("..."));
    }

    // Mocked implementation of createGson
    private Gson createGson() {
        return new Gson();
    }
}
