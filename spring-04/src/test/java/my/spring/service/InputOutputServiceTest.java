package my.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Класс InputOutputService")
public class InputOutputServiceTest {
    private InputOutputService io;

    @Autowired
    public InputOutputServiceTest(InputOutputService io) {
        this.io = io;
    }

    @DisplayName("корректно задает локаль")
    @Test
    void shouldSetLocale() {
        //InputOutputService io =  new InputOutputService();
        io.setLocale("ru_RU");
        assertEquals("ru_RU", io.getLocale());
    }

    @DisplayName("корректно возвращает строку на русском языке")
    @Test
    void shouldHaveGetRuString() {
        //InputOutputService io =  new InputOutputService();
        io.setLocale("ru_RU");
        String testString = io.getOutputString("strings.test_string", null);
        assertEquals("Тестовая строка", testString);
    }

    @DisplayName("корректно возвращает строку на английском языке")
    @Test
    void shouldHaveGetEnString() {
        //InputOutputService io =  new InputOutputService();
        io.setLocale("en_EN");
        String testString = io.getOutputString("strings.test_string", null);
        assertEquals("Test string", testString);
    }
}