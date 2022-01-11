package my.spring.service;

import my.spring.dao.QuestionDao;
import my.spring.domain.Question;
import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    public List<Question> getQuestionList() {
        try {
            return dao.getQuestionList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void printQuestionList() {
        List<Question> questionList = null;

        questionList = getQuestionList();

        for (Question question: questionList) {
            System.out.println(question.getNumber() + ". " +  question.getText());
        }
    }
}
