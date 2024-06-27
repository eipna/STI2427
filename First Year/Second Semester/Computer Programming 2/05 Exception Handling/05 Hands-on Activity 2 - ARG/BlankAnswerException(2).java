public class BlankAnswerException extends Exception {
    public BlankAnswerException() {
        super("Blank answer not allowed");
    }
}
