import java.util.function.Function;

public class Main2 {

    public static void main(String[] args) {

        // Speiicher intensive Operationen
        Function<String, String> alleAnfangsbuchstabenZuGroßbuchstaben = text -> {
            String[] woerter = text.split(" ");
            String ergebnis = "";
            for (String wort : woerter) {
                ergebnis += wort.substring(0, 1).toUpperCase() + wort.substring(1) + " ";
            }
            return ergebnis;
        };

        // Speicher effiziente Operationen
        Function<String, String> alleAnfangsbuchstabenZuGroßbuchstaben2 = text -> {
            String[] woerter = text.split(" ");
            StringBuilder ergebnis = new StringBuilder();
            for (String wort : woerter) {
                ergebnis.append(wort.substring(0, 1).toUpperCase()).append(wort.substring(1)).append(" ");
            }
            return ergebnis.toString().trim();
        };

        String abc = alleAnfangsbuchstabenZuGroßbuchstaben2.apply("hallo welt a b c abc ab c");
        String def = alleAnfangsbuchstabenZuGroßbuchstaben2.apply("hallo welt a b c abc ab c");

        System.out.println(abc);
        System.out.println(def);


        String langerText = "Hier steht ein sehr langer Text, der als Test dient, um zu sehen, wie viel Speicherplatz unterschiedliche Implementierungen verwenden. Dieser Text sollte lang genug sein, um einen signifikanten Unterschied zu zeigen.";

        // Speicher vor der Operation
        long speicherVor1 = getVerfuegbarerSpeicher();
        String ergebnis1 = alleAnfangsbuchstabenZuGroßbuchstaben.apply(langerText);
        long speicherNach1 = getVerfuegbarerSpeicher();

        // Speicher vor der zweiten Operation
        long speicherVor2 = getVerfuegbarerSpeicher();
        String ergebnis2 = alleAnfangsbuchstabenZuGroßbuchstaben2.apply(langerText);
        long speicherNach2 = getVerfuegbarerSpeicher();

        // Ergebnisse ausgeben
        System.out.println("Speicherverbrauch Methode 1: " + (speicherVor1 - speicherNach1) + " Bytes");
        System.out.println("Speicherverbrauch Methode 2: " + (speicherVor2 - speicherNach2) + " Bytes");
    }

    private static long getVerfuegbarerSpeicher() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
