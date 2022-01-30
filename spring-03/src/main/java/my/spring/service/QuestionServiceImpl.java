package my.spring.service;

import my.spring.config.ServiceConfig;
import my.spring.dao.QuestionDao;
import my.spring.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao dao;

    private final ServiceConfig config;

    private final InputOutputService io;

    //private final List<Question> questionList;
//    public void setRequiredAnswerCount(int requiredAnswerCount) {
//        this.requiredAnswerCount = requiredAnswerCount;
//    }

    @Autowired
    public QuestionServiceImpl(QuestionDao dao, ServiceConfig config, InputOutputService io) {
        this.dao = dao;
        this.config = config;
        this.io = io;
        //this.questionList = getQuestionList();
    }

    public void runTest() {
        int countAnswer = 0;
        int countQuestion = 0;

        String name = readName();

        for (Question question: getQuestionList()) {
            printOneQuestion(question);
            String answer = readAnswer();

            String requiredAnswer = question.getAnswer();
            if (answer.equalsIgnoreCase(requiredAnswer))
                countAnswer++;
            countQuestion++;
        }

        if (countQuestion == 0) {
            io.outputString("strings.list_is_empty", null);
        }
        else
            getTestResult(name, countAnswer);
    }

    public List<Question> getQuestionList() {
        try {
            return dao.readQuestionList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    //Нужен был для отладки
    public void printQuestionList() {
        for (Question question: getQuestionList()) {
            printOneQuestion(question);
        }
    }

    //Не пригодился
    public void findOneQuestion(int index) {
        for (Question question: getQuestionList()) {
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
        io.outputString("strings.enter_the_answer", null);

        if (scanner.hasNextLine()) {
            answer = scanner.nextLine();
            while (answer.equals("") || answer == null) {
                io.outputString("strings.enter_the_answer_again", null);
                answer = scanner.nextLine();
            }
            io.outputString("strings.thank_you", null);
        }

        return answer;
    }

    public String readName() {
        String name = "";
        Scanner scanner = new Scanner(System.in);
        io.outputString("strings.enter_the_name", null);

        if (scanner.hasNextLine()) {
            name = scanner.nextLine();
            while (name.equals("") || name == null) {
                io.outputString("strings.enter_the_name_again", null);
                name = scanner.nextLine();
            }
            io.outputString("strings.thank_you", null);
        }

        return name;
    }

    public void getTestResult(String name, int countAnswer) {
        int requiredAnswerCount = config.getRequiredAnswerCount();
        if (countAnswer >= requiredAnswerCount)
            io.outputString("strings.test_passed_successfully", new String[] {name});
        else
            io.outputString("strings.test_passed_failed", new Object[] {name, countAnswer, requiredAnswerCount});
    }
}
