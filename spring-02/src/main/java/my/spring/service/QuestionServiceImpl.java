package my.spring.service;

import my.spring.dao.QuestionDao;
import my.spring.domain.Question;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionDao dao;
    private final List<Question> questionList;
    @Value("${requiredAnswerCount}")
    private int requiredAnswerCount;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
        this.questionList = getQuestionList();
    }

    public void runTest() {
        int countAnswer = 0;

        String name = readName();

        for (Question question: this.questionList) {
            printOneQuestion(question);
            String answer = readAnswer();

            String requiredAnswer = question.getAnswer();
            if (answer.equalsIgnoreCase(requiredAnswer))
                countAnswer++;
        }

        getTestResult(name, countAnswer);
    }

    public List<Question> getQuestionList() {
        try {
            return dao.readQuestionList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    //Нужен был для отладки
    public void printQuestionList() {
        for (Question question: this.questionList) {
            printOneQuestion(question);
        }
    }

    //Не пригодился
    public void findOneQuestion(int index) {
        for (Question question: this.questionList) {
            if (question.getNumber() == index)
                printOneQuestion(question);
        }
    }

    public void printOneQuestion(Question question) {
        System.out.println(question.getNumber() + ". " +  question.getText() + "?");
    }

    public String readAnswer() {
        String answer = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your answer:");

        if (scanner.hasNextLine()) {
            answer = scanner.nextLine();
            while (answer.equals("") || answer == null) {
                System.out.println("Enter your answer again.");
                answer = scanner.nextLine();
            }
            System.out.println("Thanks for your answer.");
        }

        return answer;
    }

    public String readName() {
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");

        if (scanner.hasNextLine()) {
            name = scanner.nextLine();
            while (name.equals("") || name == null) {
                System.out.println("Enter your name again.");
                name = scanner.nextLine();
            }
            System.out.println("Thank you.");
        }

        return name;
    }

    public void getTestResult(String name, int countAnswer) {
        if (countAnswer >= requiredAnswerCount)
            System.out.println(name + ", your test passed successfully!");
        else
            System.out.println(name + ", your test failed! " + countAnswer + " of " + requiredAnswerCount);
    }
}
