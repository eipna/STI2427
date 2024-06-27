public class CharacterAnswerException extends Exception {
    public CharacterAnswerException() {
        super("Special characters are not allowed");
    }
}
