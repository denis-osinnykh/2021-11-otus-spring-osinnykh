package my.spring.dao;

import lombok.SneakyThrows;
import my.spring.domain.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("QuestionDaoSimpleTest")
public class QuestionDaoSimpleTest {
    private final QuestionDaoSimple dao;

    @Autowired
    public QuestionDaoSimpleTest(QuestionDaoSimple dao) {
        this.dao = dao;
    }

    @DisplayName("в принципе считывает строку из csv-файла")
    @Test
    @SneakyThrows
    void shouldReadQuestionStringFromCSV() {
        assertEquals(1, dao.readQuestionList().stream().count());
    }

    @DisplayName("корректно читает текст вопроса из строки")
    @Test
    @SneakyThrows
    void shouldReadQuestionTextFromCSV() {
        List<Question> list = new ArrayList<>();
        list.add(new Question(1, "Test question", "Test"));
        assertEquals(list.get(0).getText(), dao.readQuestionList().get(0).getText());
    }

    @DisplayName("корректно читает ответ на вопрос из строки")
    @Test
    @SneakyThrows
    void shouldReadQuestionAnswerFromCSV() {
        List<Question> list = new ArrayList<>();
        list.add(new Question(1, "Test question", "Test"));
        assertEquals(list.get(0).getAnswer(), dao.readQuestionList().get(0).getAnswer());
    }
}
