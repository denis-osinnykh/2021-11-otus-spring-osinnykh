package my.spring.domain;

public final class Question {

    private int number;
    private String text;

    public Question(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public String getText() { return text; }

    public int getNumber() { return number; }
}
