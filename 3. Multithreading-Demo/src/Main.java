public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            SingleThreadExample singleThread = new SingleThreadExample(i);

            singleThread.start();
        }
    }
}
