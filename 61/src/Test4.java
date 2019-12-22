import java.io.File;
import java.io.IOException;

public class Test4 {
    private static void listDirectory (File root, int level) {
        File[] files = root.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            for (int i = 0; i < level * 4; i++) {
                System.out.print(" ");
            }
            System.out.print(file.getName());
            if (file.isDirectory()) {
                System.out.println(file.separator);
            } else {
                System.out.print(" ");
                System.out.println(file.length());
            }
            if (file.isDirectory()) {
                listDirectory(file, level + 1);
            }

        }
    }

    public static void main(String[] args) throws IOException{
        File files = new File("C:\\Users\\Lenovo\\Desktop\\bit");
        System.out.println(files.getAbsolutePath());
        listDirectory(files, 1);
    }
}
