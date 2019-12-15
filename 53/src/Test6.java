public class Test6 {
    private static Test6 instance = new Test6();

    public synchronized static Test6 getinstance() {
        return instance;
    }
}
