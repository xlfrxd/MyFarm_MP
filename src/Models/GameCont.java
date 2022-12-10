package Models;

public class GameCont {
    public static boolean getIsRunning() {
        return isRunning;
    }


    public static void setRunning(boolean running) {
        isRunning = running;
    }

    private static boolean isRunning = true;

}
