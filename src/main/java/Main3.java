import java.time.LocalDate;
import java.util.function.Consumer;

public class Main3 {

    static class Beleg {
        private LocalDate datum;

        public Beleg(LocalDate datum) {
            this.datum = datum;
        }

        public LocalDate getDatum() {
            return datum;
        }
    }

    public static void main(String[] args) {
        Consumer<Beleg> pruefeDatumGegenHeute = Main3::pruefeObDatumHeute;

        Beleg belegHeute = new Beleg(LocalDate.now());
        Beleg belegGestern = new Beleg(LocalDate.now().minusDays(1));

        pruefeDatumGegenHeute.accept(belegHeute);
        pruefeDatumGegenHeute.accept(belegGestern);
    }

    private static void pruefeObDatumHeute(Beleg beleg) {
        if (LocalDate.now().equals(beleg.getDatum())) {
            System.out.println("Belegdatum ist gleich heute");
        } else {
            System.out.println("Belegdatum ist nicht gleich heute");
        }
    }
}
