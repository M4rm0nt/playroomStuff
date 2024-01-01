import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main4 {

    public static void main(String[] args) {

        UnaryOperator<String> anfangsBuchstabeZuGroßbuchstabe2 = text -> text.substring(0, 1).toUpperCase() + text.substring(1);
        //System.out.println(anfangsBuchstabeZuGroßbuchstabe2.apply("hallo welt"));

        Function<String, String> anfangsBuchstabeZuGroßbuchstabe = text -> text.substring(0, 1).toUpperCase() + text.substring(1);
        //System.out.println(anfangsBuchstabeZuGroßbuchstabe.apply("hallo welt"));

        System.out.println(anfangsBuchstabeZuGroßbuchstabe.getClass());
    }
}
