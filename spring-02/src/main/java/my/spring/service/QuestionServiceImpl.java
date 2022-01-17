package my.spring.service;

import my.spring.dao.QuestionDao;
import my.spring.domain.Question;
import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionDao dao;
    private final List<Question> questionList;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
        this.questionList = getQuestionList();
    }

    public void runTest() {
        int countAnswer = 0;
        int requiredAnswerCount = 3;

        for (Question question: this.questionList) {
            printOneQuestion(question);
            String answer = readAnswer();

            String requiredAnswer = question.getAnswer();
            if (answer.equalsIgnoreCase(requiredAnswer))
                countAnswer++;
        }

        if (countAnswer >= requiredAnswerCount)
            System.out.println("Test passed successfully!");
        else
            System.out.println("Test failed!");
    }

    public List<Question> getQuestionList() {
        try {
            return dao.readQuestionList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
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
}
