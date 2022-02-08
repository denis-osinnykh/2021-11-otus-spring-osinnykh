package my.spring.dao;

import my.spring.config.DaoConfig;
import my.spring.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class QuestionDaoSimple implements QuestionDao {
    private final DaoConfig config;

    @Autowired
    public QuestionDaoSimple(DaoConfig config) {
        this.config = config;
    }

    public List<Question> readQuestionList() throws Exception {
        if (config.getFileName() == null)
            throw new Exception("Файл не найден");

        List<Question> questionList = new ArrayList<>();

        String path = "files/" + config.getFileName().replace(".", config.getLanguage() + ".");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Thread.currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream(path))
            )) {

            String line = null;
            Scanner LineScanner = null;
            Scanner questionScanner = null;
            int index = 0;
            int rowNum = 1;

            do {
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    throw new Exception("Ошибка чтения строки");
                }

                if (line != null) {
                    String text = null;
                    String answer = null;
                    int number = 0;
                    LineScanner = new Scanner(line);
                    LineScanner.useDelimiter(",");
                    while (LineScanner.hasNext()) {
                        String questionString = LineScanner.next();
                        if (index == 0) {
                            questionScanner = new Scanner(questionString).useDelimiter("\\?");
                            while (questionScanner.hasNext()) {
                                String questionText = questionScanner.next();
                                if (text == null)
                                    text = questionText;
                                else
                                    answer = questionText.trim();
                            }
                        } else
                            throw new Exception("Некорректные данные::" + questionString);
                        number = rowNum;
                        index++;
                    }
                    index = 0;
                    if (text != null)
                        questionList.add(new Question(number, text, answer));
                    rowNum++;
                }
            }
            while (line != null);
        }

        return questionList;
    }
}
