package my.spring.dao;

import my.spring.domain.Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionDaoSimple implements QuestionDao {
    public List<Question> getQuestionList(String fileName) {
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        if (file == null) {
            System.out.println("Файл не найден");
            return null;
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
            return null;
        }
        BufferedReader reader = new BufferedReader(fileReader);

        String line = null;
        Scanner scanner = null;
        int index = 0;
        int rowNum = 1;
        List<Question> questionList = new ArrayList<>();

        do {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка чтения строки");
                break;
            }

            if (line != null) {
                Question question = new Question();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0)
                        question.setText(data);
                    else
                        System.out.println("Некорректные данные::" + data);
                    question.setNumber(Integer.toString(rowNum));
                    index++;
                }
                index = 0;
                if (question.getText() != null)
                    questionList.add(question);
                rowNum++;
            }
        }
        while (line != null);

        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка закрытия ридера");
        }

        return questionList;
    }
}
