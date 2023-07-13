package manager;
import model.Class;
import java.util.ArrayList;
import java.util.List;

public class ClassManager {
    public static List<Class> classes = new ArrayList<>();
    static {
        classes.add(new Class(1, "C05"));
        classes.add(new Class(2, "C06"));
    }
}
