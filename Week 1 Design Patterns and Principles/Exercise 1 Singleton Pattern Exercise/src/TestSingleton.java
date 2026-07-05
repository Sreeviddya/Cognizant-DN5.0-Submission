public class TestSingleton {

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both references point to the same instance.");
        } else {
            System.out.println("FAILURE: Different instances were created.");
        }

        System.out.println("Logger 1 hash: " + System.identityHashCode(logger1));
        System.out.println("Logger 2 hash: " + System.identityHashCode(logger2));
    }
}
