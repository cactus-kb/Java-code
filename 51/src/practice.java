public class practice {
    public static boolean ll(String str) {
        return str.toLowerCase().equals("admin");
    }

    public static void main(String[] args) {
        System.out.println(ll("Admin"));
    }
    


    public static boolean isRight(String UID) {
        return UID.toLowerCase() == "admin";
    }

    public static void main1(String[] args) {
        System.out.println(isRight("Admin"));
    }
}
