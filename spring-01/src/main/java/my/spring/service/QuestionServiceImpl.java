package my.spring.service;

import my.spring.dao.QuestionDao;
import my.spring.domain.Question;
import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionDao dao;

    private final String str;

    public QuestionServiceImpl(QuestionDao dao, String str) {
        this.dao = dao;
        this.str = str;
    }

    public List<Question> getQuestionList() { return dao.getQuestionList(str); }
}
