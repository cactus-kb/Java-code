public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getState());
        System.out.println(thread.getPriority());
        System.out.println(thread.isAlive());
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isAlive());
    }
}
