import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public class Main5 {

    static class Rechnung {
        BigDecimal nettoBetrag;
        BigDecimal bruttoBetrag;
        BigDecimal mwstBetrag;

        public void setNettoBetrag(BigDecimal nettoBetrag) {
            this.nettoBetrag = nettoBetrag;
        }

        public void setBruttoBetrag(BigDecimal bruttoBetrag) {
            this.bruttoBetrag = bruttoBetrag;
        }

        public void setMwstBetrag(BigDecimal mwstBetrag) {
            this.mwstBetrag = mwstBetrag;
        }

        public void berechneBruttoBetrag(BinaryOperator<BigDecimal> summenFunktion) {
            this.bruttoBetrag = summenFunktion.apply(nettoBetrag, mwstBetrag);
        }

        @Override
        public String toString() {
            return "Rechnung{" +
                    "nettoBetrag=" + nettoBetrag +
                    ", bruttoBetrag=" + bruttoBetrag +
                    ", mwstBetrag=" + mwstBetrag +
                    '}';
        }
    }

    public static void main(String[] args) {
        BinaryOperator<BigDecimal> summe = BigDecimal::add;

        Rechnung rechnung = new Rechnung();
        rechnung.setNettoBetrag(new BigDecimal("100.00"));
        rechnung.setMwstBetrag(new BigDecimal("19.00"));

        rechnung.setBruttoBetrag(summe.apply(rechnung.nettoBetrag, rechnung.mwstBetrag));

        System.out.println(rechnung.bruttoBetrag);
    }

}
