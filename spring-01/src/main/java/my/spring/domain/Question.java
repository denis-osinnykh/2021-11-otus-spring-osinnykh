package my.spring.domain;

public class Question {

    private final int number;
    private final String text;

    public Question(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public String getText() { return text; }

    public int getNumber() { return number; }
}
