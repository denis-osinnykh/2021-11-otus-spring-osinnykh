package my.spring.dao;

import my.spring.Main;
import my.spring.domain.Question;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionDaoSimple implements QuestionDao {
    private final String fileName;

    public QuestionDaoSimple(String fileName) {
        this.fileName = fileName;
    }

    public List<Question> getQuestionList() throws Exception {
        List<Question> questionList = new ArrayList<>();

        try(InputStream output = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(output));
            if (reader == null)
                throw new Exception("Ошибка чтения ресурса");

            String line = null;
            Scanner scanner = null;
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
                    int number = 0;
                    scanner = new Scanner(line);
                    scanner.useDelimiter(",");
                    while (scanner.hasNext()) {
                        String data = scanner.next();
                        if (index == 0)
                            text = data;
                        else
                            throw new Exception("Некорректные данные::" + data);
                        number = rowNum;
                        index++;
                    }
                    index = 0;
                    if (text != null)
                        questionList.add(new Question(number, text));
                    rowNum++;
                }
            }
            while (line != null);
        }

        return questionList;
    }
}
