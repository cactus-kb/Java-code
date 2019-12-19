import java.io.File;
import java.util.Properties;

public class IODemo {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
    }


    public static void main1(String[] args) {
        File parent = new File("F:\\myjavacode");
        System.out.println("可执行//可读//可写");
        System.out.println(parent.canExecute());
        System.out.println(parent.canRead());
        System.out.println(parent.canWrite());

        System.out.println("是否存在/是文件夹/是文件/绝对路径/隐藏");
        System.out.println(parent.exists());
        System.out.println(parent.isDirectory());
        System.out.println(parent.isFile());
        System.out.println(parent.isAbsolute());
        System.out.println(parent.isHidden());
        System.out.println("该文件所在盘符的空间情况");
        System.out.println(parent.getUsableSpace());
        System.out.println(parent.getFreeSpace());
        System.out.println(parent.getTotalSpace());
        System.out.println("文件大小/名字/上次修改时间");
        System.out.println(parent.length());
        System.out.println(parent.getName());
        System.out.println(parent.lastModified());
    }
}
