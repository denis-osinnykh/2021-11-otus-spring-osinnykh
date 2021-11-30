package my.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс Question")
class QuestionTest {

    @DisplayName("корректно возвращает текст")
    @Test
    void shouldHaveGetText() {
        Question question = new Question();
        question.setText("Test question");

        assertEquals("Test question", question.getText());
    }
}