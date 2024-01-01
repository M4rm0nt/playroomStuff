import java.time.LocalDate;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        // Function<T, R>
        Function<Integer, String> zahlZuString = zahl -> "Die Zahl ist: " + zahl;
        System.out.println(zahlZuString.apply(5));

        Function<String, String> anfangsBuchstabeZuGroßbuchstabe = text -> text.substring(0, 1).toUpperCase() + text.substring(1);
        System.out.println(anfangsBuchstabeZuGroßbuchstabe.apply("hallo welt"));

        Function<String, String> alleAnfangsbuchstabenZuGroßbuchstaben = text -> {
            String[] woerter = text.split(" ");
            String ergebnis = "";
            for (String wort : woerter) {
                ergebnis += wort.substring(0, 1).toUpperCase() + wort.substring(1) + " ";
            }
            return ergebnis;
        };

        System.out.println(alleAnfangsbuchstabenZuGroßbuchstaben.apply("hallo welt a b c abc ab c"));

        String abc = alleAnfangsbuchstabenZuGroßbuchstaben.apply("hallo welt a b c abc ab c");

        Function<String, String> alleAnfangsbuchstabenZuGroßbuchstaben2 = text -> {
            String[] woerter = text.split(" ");
            StringBuilder ergebnis = new StringBuilder();
            for (String wort : woerter) {
                ergebnis.append(wort.substring(0, 1).toUpperCase()).append(wort.substring(1)).append(" ");
            }
            return ergebnis.toString().trim();
        };

        System.out.println(alleAnfangsbuchstabenZuGroßbuchstaben2.apply("string concatenation '+=' in loop"));


        // Predicate<T>
        Predicate<String> istLang = text -> text.length() > 10;
        System.out.println(istLang.test("Hallo Welt")); // false

        Predicate<String> beginntMitGroßbuchstabe = text -> Character.isUpperCase(text.charAt(0));
        System.out.println(beginntMitGroßbuchstabe.test("Hallo Welt")); // true

        Predicate<Integer> istDieZahlGeteiltDurch186ProzentGleichNull = zahl -> zahl % 186 == 0;
        System.out.println(istDieZahlGeteiltDurch186ProzentGleichNull.test(100)); // false
        System.out.println(istDieZahlGeteiltDurch186ProzentGleichNull.test(186));
        System.out.println(istDieZahlGeteiltDurch186ProzentGleichNull.test((186 * 2))); // false

        Predicate<Boolean> istWahr = wert -> wert;
        System.out.println(istWahr.test(true));
        System.out.println(istWahr.test(false));

        Predicate<LocalDate> istDatumHeute = datum -> LocalDate.now().equals(datum);
        System.out.println(istDatumHeute.test(LocalDate.now()));

        Boolean istDatumHeute2 = LocalDate.now().equals(LocalDate.now());
        System.out.println(istDatumHeute2);

        // Consumer<T>
        Consumer<String> drucker = text -> System.out.println(text);
        drucker.accept("Hallo Java Welt");

        // Supplier<T>
        Supplier<LocalDate> heutigesDatum = () -> LocalDate.now();
        System.out.println(heutigesDatum.get()); // heutiges Datum

        // UnaryOperator<T>
        UnaryOperator<Integer> quadrat = zahl -> zahl * zahl;
        System.out.println(quadrat.apply(5)); // 25

        UnaryOperator<String> anfangsBuchstabeZuGroßbuchstabe2 = text -> text.substring(0, 1).toUpperCase() + text.substring(1);
        System.out.println(anfangsBuchstabeZuGroßbuchstabe2.apply("hallo welt"));

        // BinaryOperator<T>
        BinaryOperator<Integer> summe = (zahl1, zahl2) -> zahl1 + zahl2;
        System.out.println(summe.apply(5, 10)); // 15
        System.out.println(summe.apply(5, 10)); // 15


        // BiFunction<T, U, R>
        BiFunction<Integer, Integer, String> multipliziereUndKonvertiere = (zahl1, zahl2) -> "Ergebnis: " + (zahl1 * zahl2);
        System.out.println(multipliziereUndKonvertiere.apply(5, 4)); // "Ergebnis: 20"

        // BiPredicate<T, U>
        BiPredicate<Integer, String> testAlterUndName = (alter, name) -> alter >= 18 && name.startsWith("M");
        System.out.println(testAlterUndName.test(20, "Max")); // true

        // BiConsumer<T, U>
        BiConsumer<String, Integer> nameUndAlterDrucker = (name, alter) -> System.out.println(name + " ist " + alter + " Jahre alt.");
        nameUndAlterDrucker.accept("Anna", 30); // "Anna ist 30 Jahre alt."

    }
}
