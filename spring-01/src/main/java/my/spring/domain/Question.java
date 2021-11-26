package my.spring.domain;

public class Question {

    private String number;
    private String text;

    public Question() {
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }
}
