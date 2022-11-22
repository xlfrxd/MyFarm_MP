public class Message {

    public static void processCommand (String type){
        /** This helper function informs the user of actions and certain game events
         * @param type             the type of action/event that occurred
         */
        switch (type.toLowerCase()){
            case "intro":
                System.out.println(
                        "  _____                    _               ____  _                 _       _             \r\n"
                                + " |  ___|_ _ _ __ _ __ ___ (_)_ __   __ _  / ___|(_)_ __ ___  _   _| | __ _| |_ ___  _ __ \r\n"
                                + " | |_ / _` | '__| '_ ` _ \\| | '_ \\ / _` | \\___ \\| | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|\r\n"
                                + " |  _| (_| | |  | | | | | | | | | | (_| |  ___) | | | | | | | |_| | | (_| | || (_) | |   \r\n"
                                + " |_|  \\__,_|_|  |_| |_| |_|_|_| |_|\\__, | |____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   \r\n"
                                + "                                   |___/                                                 ");
                break;
            case "menu":
                System.out.println(
                        "   [1]     [ 2 ]      [3]         [4]        [5]  \r\n" +
                        " [PLANT] | [USE] | [HARVEST] | [NEXT DAY] | [QUIT] ");
                break;
            case "over":
                System.out.println(
                        "Game Over!\n" +
                                "[1] New Game    [2] Exit");
                break;
            case "quit":
                System.out.println("Quitting game...");
                break;
            default:
                throwUnknownError(type);
        }
    }

    public static void processCommand (String type, String desc){
        /** This helper function involves quality of life user updates
         * @param type             the type of action/event that occurred
         * @param desc             the short description of the action/event
         */
        switch(type){
            case "greeting":
                System.out.println("Howdy, " + desc);
                break;

            default:
                throwUnknownError(type);
        }
    }
    public static void processCommand (String type, boolean success) {
        /** This helper function informs the user of their actions and certain game events that involve success and fail conditions
         * @param type             the type of action/event that occurred
         * @param success          the result of the action/event
         */
        switch(type.toLowerCase()){
            case "harvest":
                break;
            case "plow":
                break;
            case "water":
                break;
            default:
                throwUnknownError(type);
                break;
        }
    }
    public static void throwUnknownError(String err){
        /** This helper function throws an error message when input is invalid or unknown
         * @param input             user input to display in exception
         */
        System.out.println("Unknown command: \"" + err + "\"");
    }

}
