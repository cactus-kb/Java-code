class HelloA {
    public HelloA() {
        System.out.println("i'm A class");
    }
    static {
        System.out.println("static A");
    }
}

public class HelloB extends HelloA{
   public HelloB () {
       System.out.println("i'm B class");
   }
   static {
       System.out.println("static B");
   }

    public static void main(String[] args) {
        new HelloB();
    }
}


