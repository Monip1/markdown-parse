import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

//javac -cp "lib/\*" MarkdownParseTest.javajava -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
//javac -cp "lib/\*" MarkdownParseTest.javajava -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void links()  throws IOException{
        assertEquals(MarkdownParse.getLinks("test-file.md"), List.of("https://something.com", "some-page.html"));
        assertEquals(MarkdownParse.getLinks("test-file2.md"), List.of("https://www.homedepot.com/", "https://theforum.ticketsoffice.org/"));
        assertEquals(MarkdownParse.getLinks("test-file3.md"), List.of("https://www.homedepot.com/", "https://theforum.ticketsoffice.org/"));
        assertEquals(MarkdownParse.getLinks("test-file4.md"), List.of("https://www.homedepot.com/", "https://theforum.ticketsoffice.org/"));
    }
}