package my.spring.service;

import my.spring.dao.QuestionDao;
import my.spring.domain.Question;
import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionDao dao;
    private final List<Question> questionList;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
        this.questionList = getQuestionList();
    }

    public List<Question> getQuestionList() {
        try {
            return dao.readQuestionList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void printQuestionList() {
        List<Question> questionList = getQuestionList();

        for (Question question: questionList) {
            printOneQuestion(question);
        }
    }

    public void findOneQuestion(int index) {
        List<Question> questionList = getQuestionList();

        for (Question question: questionList) {
            if (question.getNumber() == index)
                printOneQuestion(question);
        }
    }

    public void printOneQuestion(Question question) {
        System.out.println(question.getNumber() + ". " +  question.getText() + "? " + question.getAnswer());
    }
}
