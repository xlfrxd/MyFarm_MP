public class Message {
    public static void throwUnknownError(String input){
        /** This helper function throws an error message when input is invalid or unknown
         * @param input             user input to display in exception
         */
        System.out.println("Unknown command: \"" + input + "\"");
    }

}
