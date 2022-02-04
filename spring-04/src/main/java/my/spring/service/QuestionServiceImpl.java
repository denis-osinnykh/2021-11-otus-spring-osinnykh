package my.spring.service;

import my.spring.config.ServiceConfig;
import my.spring.dao.QuestionDao;
import my.spring.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao dao;

    private final ServiceConfig config;

    private final InputOutputService io;

    private String name;
    public String getName() { return this.name; }
    public void setName(String name) {
        this.name = name;
    }

    private int countAnswer=0;
    public int getCountAnswer() {return this.countAnswer; }
    public void setCountAnswer(int countAnswer) {
        this.countAnswer = countAnswer;
    }

    public int countQuestion=0;
    public resultEnum testResult;

    @Autowired
    public QuestionServiceImpl(QuestionDao dao, ServiceConfig config, InputOutputService io) {
        this.dao = dao;
        this.config = config;
        this.io = io;
    }

    public void runTest() {
        setName(readName());

        for (Question question: getQuestionList()) {
            printOneQuestion(question);
            String answer = readAnswer();

            String requiredAnswer = question.getAnswer();
            if (answer.equalsIgnoreCase(requiredAnswer))
                countAnswer++;
            countQuestion++;
        }

        if (countQuestion == 0) {
            io.printString("strings.list_is_empty", null);
        }
        else {
            testResult = getTestResult();
            switch (testResult) {
                case EMPTY:
                    io.printString("strings.list_is_empty", null);
                    break;
                case PASSED:
                    io.printString("strings.test_passed_successfully", new String[] {name});
                    break;
                case FAILED:
                    io.printString("strings.test_passed_failed", new Object[] {name, countAnswer, config.getRequiredAnswerCount()});
                    break;
            }
        }
    }

    @Cacheable(cacheNames="questions")
    public List<Question> getQuestionList() {
        try {
            return dao.readQuestionList();
        } catch (Exception e)
        {
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
        System.out.println(io.getOutputString("strings.enter_the_answer", null));

        if (scanner.hasNextLine()) {
            answer = scanner.nextLine();
            while (answer.equals("")) {
                System.out.println(io.getOutputString("strings.enter_the_answer_again", null));
                answer = scanner.nextLine();
            }
            System.out.println(io.getOutputString("strings.thank_you", null));
        }

        return answer;
    }

    public String readName() {
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(io.getOutputString("strings.enter_the_name", null));

        if (scanner.hasNextLine()) {
            name = scanner.nextLine();
            while (name.equals("")) {
                System.out.println(io.getOutputString("strings.enter_the_name_again", null));
                name = scanner.nextLine();
            }
            System.out.println(io.getOutputString("strings.thank_you", null));
        }

        return name;
    }

    public resultEnum getTestResult() {
        if (name == null) {
            //System.out.println(io.getOutputString("strings.no_test_results_yet", null));
            return resultEnum.EMPTY;
        }

        //int requiredAnswerCount = config.getRequiredAnswerCount();
        if (countAnswer >= config.getRequiredAnswerCount())
            return resultEnum.PASSED;
            //System.out.println(io.getOutputString("strings.test_passed_successfully", new String[] {name}));
        else
            return resultEnum.FAILED;
            //System.out.println(io.getOutputString("strings.test_passed_failed", new Object[] {name, countAnswer, requiredAnswerCount}));
    }
}

enum resultEnum {
    EMPTY,
    FAILED,
    PASSED
}
