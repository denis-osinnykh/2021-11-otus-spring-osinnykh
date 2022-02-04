package my.spring.shell;

import lombok.RequiredArgsConstructor;
import my.spring.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationCommands {
    @Autowired
    private QuestionService qs;

    @ShellMethod(value = "Run test", key = {"r", "run"})
    public void runTest() {
        qs.runTest();
    }

    @ShellMethod(value = "Get test result", key = {"g", "get"})
    public void getTestResult() {
        qs.getTestResult();
    }
}
