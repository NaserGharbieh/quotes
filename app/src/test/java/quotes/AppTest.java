package quotes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

        @Test void testQuotes() {  // test can read from Json file and choose a random quote
            Quote quote = Quote.readQuotes("src/test/resources/recentquotes.json") ;
            Assertions.assertNotNull(quote);
        }
    }



