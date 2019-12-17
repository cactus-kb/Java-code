import java.io.IOException;
import java.io.PrintWriter;

public class IODemo {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter("hello.text","UTF-8");
        printWriter.println("good morning!");
        printWriter.println("my name is : ll");
        printWriter.printf("%d: i'm coming %n",12);
        printWriter.close();
    }
}
