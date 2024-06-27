public class NotValidAnswerException extends Exception {
    public NotValidAnswerException() {
        super("Answer can only be A, B or C");
    }
}
