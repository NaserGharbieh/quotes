package quotes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuoteTest {
    private Quote quote;

    @BeforeEach
    public void setUp() {
        quote = new Quote("John Doe", "Sample Quote");
    }

    @Test
    public void testGetAuthor() {
        assertEquals("John Doe", quote.getAuthor());
    }

    @Test
    public void testSetAuthor() {
        quote.setAuthor("Jane Smith");
        assertEquals("Jane Smith", quote.getAuthor());
    }

    @Test
    public void testGetText() {
        assertEquals("Sample Quote", quote.getText());
    }

    @Test
    public void testSetText() {
        quote.setText("Updated Quote");
        assertEquals("Updated Quote", quote.getText());
    }

    @Test
    public void testToString() {
        String expectedString = "Quote{author='John Doe', text='Sample Quote'}";
        assertEquals(expectedString, quote.toString());
    }

    @Test
    public void testReadQuotes() {
        // Assuming you have a JSON file with quotes at the specified path
        Quote randomQuote = Quote.readQuotes("src/test/resources/recentquotes.json");
        assertNotNull(randomQuote);
        assertNotNull(randomQuote.getAuthor());
        assertNotNull(randomQuote.getText());
    }
}


