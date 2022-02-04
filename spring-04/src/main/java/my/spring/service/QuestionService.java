package my.spring.service;

import my.spring.domain.Question;
import java.util.List;

public interface QuestionService {
    List<Question> getQuestionList();

    void runTest();

    resultEnum getTestResult();
}
