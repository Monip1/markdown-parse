import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
// import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

//javac -cp "lib//*" MarkdownParseTest.javajava -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
//java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
public class MarkdownParseTest {
    // @Test
    // public void addition() {
    //     assertEquals(2, 1 + 1);
    // }

    @Test
    public void testSnip1() throws IOException{
        List<String> expect = List.of("`google.com","google.com","ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks("C:/Users/ElenaTomson/OneDrive - Tomson Family/Documents/GitHub/markdown-parse/snip1.md"));
    }

    @Test
    public void testSnip2() throws IOException{
        List<String> expect = List.of("a.com","a.com(())","example.com");
        assertEquals(expect, MarkdownParse.getLinks("C:/Users/ElenaTomson/OneDrive - Tomson Family/Documents/GitHub/markdown-parse/snip2.md"));
    }
    @Test
    public void testSnip3() throws IOException{
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expect, MarkdownParse.getLinks("C:/Users/ElenaTomson/OneDrive - Tomson Family/Documents/GitHub/markdown-parse/snip3.md"));
    }
    // @Test
    // public void testSpaceAfterParen() {
    //     String contents = "[title]( space-in-url.com)";
    //     List<String> expect = List.of("space-in-url.com");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }
    // @Test
    // public void links()  throws IOException{
    //     assertEquals(MarkdownParse.getLinks(".\test-file.md"), List.of("https://something.com", "some-page.html"));
    //     assertEquals(4, 5);
    // }
    // @Test
    // public void links2()  throws IOException{
    //     assertEquals(MarkdownParse.getLinks("test-file2.md"), List.of("https://www.homedepot.com/", "https://theforum.ticketsoffice.org/"));
    // }
    // @Test
    // public void links3()  throws IOException{
    //     assertEquals(MarkdownParse.getLinks("test-file3.md"), List.of("https://www.homedepot.com/", "https://theforum.ticketsoffice.org/"));
    // }
    // @Test
    // public void links4()  throws IOException{
    //     assertEquals(MarkdownParse.getLinks("test-file4.md"), List.of("https://www.homedepot.com/", "https://theforum.ticketsoffice.org/"));
    // }
}