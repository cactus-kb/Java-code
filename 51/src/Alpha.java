
class Bases {
    Bases() {
        System.out.println("Bases");
    }
}

public class Alpha extends Bases {
    public static void main(String[] args) {
        new Alpha();
        new Bases();
    }
}
