// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            System.out.format("%d\t%d\t%s\n", currentIndex, nextOpenBracket, toReturn);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(nextOpenBracket == -1 || nextCloseBracket == -1
                  || closeParen == -1 || openParen == -1) {
                return toReturn;
            }
            String potentialLink = markdown.substring(openParen + 1, closeParen);
            if(potentialLink.indexOf(" ") == -1 && potentialLink.indexOf("\n") == -1) {
                toReturn.add(potentialLink);
                currentIndex = closeParen + 1;
            }
            else {
                currentIndex = currentIndex + 1;
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
// // File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.ArrayList;

// public class MarkdownParse {
//     public static ArrayList<String> getLinks(String arg) throws IOException {
//         Path fileName = Path.of(arg);
// 	    String markdown = Files.readString(fileName);
//         ArrayList<String> toReturn = new ArrayList<>();
//         // find the next [, then find the ], then find the (, then take up to
//         // the next )
//         int currentIndex = 0;
//         while(currentIndex < markdown.length()) {
//             // System.out.println(currentIndex);
//             int nextOpenBracket = markdown.indexOf("[", currentIndex);
//             int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
//             int openParen = markdown.indexOf("(", nextCloseBracket);
//             int closeParen = markdown.indexOf(")", openParen);
            
//             //if one element is not found in the rest of the file, break
//             if(nextOpenBracket < 0 || nextCloseBracket < 0 || openParen < 0 || closeParen < 0){
//                 break;
//             }
//             else if(openParen - 1 != nextCloseBracket){
//                 nextOpenBracket = markdown.indexOf("[", nextOpenBracket);
//                 nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
//             }
//             else if(nextOpenBracket == 0){
//                 toReturn.add(markdown.substring(openParen + 1, closeParen));
//                 currentIndex = closeParen + 1;
//                 // System.out.println(currentIndex);
//             }
//             else if(!markdown.substring(nextOpenBracket - 1, nextOpenBracket).equals("!")){
//                 toReturn.add(markdown.substring(openParen + 1, closeParen));
//                 currentIndex = closeParen + 1;
//                 // System.out.println(currentIndex);
//             }
//             currentIndex = closeParen + 1;
//             // System.out.println(currentIndex);
//         }
//         return toReturn;
//     }
//     public static void main(String[] args) throws IOException {
		
//         ArrayList<String> links = getLinks(args[0]);
//         System.out.println(links);
//     }
// }


// /**
//  * possible probs
//  * 1. ")" inside a link     not possible
//  * 2. []
//  */

//  //hi aaaaaaa

//  //add a line