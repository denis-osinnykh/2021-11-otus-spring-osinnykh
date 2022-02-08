package my.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("QuestionServiceImpl")
public class QuestionServiceTest {
    private final QuestionServiceImpl qs;

    @Autowired
    public QuestionServiceTest(QuestionServiceImpl qs) {
        this.qs = qs;
    }

    @DisplayName("корректно возвращает пустой результат тест")
    @Test
    void shouldGetEmptyTestResult() {
        qs.setName(null);
        assertEquals(resultEnum.EMPTY, qs.getTestResult());
    }

    @DisplayName("корректно возвращает результат 'Тест пройден'")
    @Test
    void shouldGetPassedTestResult() {
        qs.setName("test");
        qs.setCountAnswer(3);
        assertEquals(resultEnum.PASSED, qs.getTestResult());
    }

    @DisplayName("корректно возвращает результат 'Тест провален'")
    @Test
    void shouldGetFailedTestResult() {
        qs.setName("test");
        qs.setCountAnswer(0);
        assertEquals(resultEnum.FAILED, qs.getTestResult());
    }
}
