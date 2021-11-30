package my.spring.dao;

import my.spring.domain.Question;
import java.util.List;

public interface QuestionDao {
    List<Question> getQuestionList(String fileName);
}
