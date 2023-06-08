package rodionomelin_task2_annotations;

import static rodionomelin_task2_annotations.Colors.*;

@Print(style = "arrow", color = RED)
public class Messages {

    @Print(style = "!~!", color = GREEN)
    public String happyBirthday() {
        return "С днём рождения!";
    }

    @Print(style = "!", color = YELLOW)
    public String warning() {
        return "Предупреждение";
    }

    @Print(style = "=", color = CYAN)
    public String TestString1() {
        return "Надпись Бирюзового цвета";
    }

    @Print(style = "?", color = BLUE)
    public String TestString2() {
        return "Надпись Синего цвета";
    }

    @Print(style = "^", color = PURPLE)
    public String TestString3() {
        return "Надпись Фиолетового цвета";
    }

    @Print(style = "/", color = BLACK)
    public String TestString4() {
        return "Надпись Чёрного цвета";
    }

    @Print(style = "$", color = WHITE)
    public String TestString5() {
        return "Надпись Белого цвета";
    }

    public String error() {
        return "Ошибка";
    }
}
