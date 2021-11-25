package my.spring.service;

import my.spring.dao.QuestionDao;
import my.spring.domain.Question;
import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    public List<Question> getQuestionList(String str) { return dao.getQuestionList(str); }
}
