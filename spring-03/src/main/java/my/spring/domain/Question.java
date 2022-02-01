package my.spring.domain;

public final class Question {

    private final int number;
    private final String text;
    private final String answer;

    public Question(int number, String text, String answer) {
        this.number = number;
        this.text = text;
        this.answer = answer;
    }

    public String getText() { return text; }

    public int getNumber() { return number; }

    public String getAnswer() { return answer; }
}
