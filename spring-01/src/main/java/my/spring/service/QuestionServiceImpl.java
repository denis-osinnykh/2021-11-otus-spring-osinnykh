package my.spring.service;

import my.spring.dao.QuestionDao;
import my.spring.domain.Question;
import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    private final QuestionDao dao;

    private final String fileName;

    public QuestionServiceImpl(QuestionDao dao, String fileName) {
        this.dao = dao;
        this.fileName = fileName;
    }

    public List<Question> getQuestionList() { return dao.getQuestionList(fileName); }
}
