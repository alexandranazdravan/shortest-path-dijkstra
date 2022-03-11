/**
 * o clasa mai generala de vehicule de gabarit mare
 */
public class Autoutilitar {
    /**
     * gabaritul unui Autoutilitar
     */
    private int limitaG = 3;

    /**
     * Singurul constructor de care am nevoie este cel fara parametrii,
     *      caci niciodata nu voi avea alt gabarit
     */
    public Autoutilitar() {
    }

    /**
     * Getter-ul pentru gabarit
     * @return fiind un getter, returnez variabila de membru
     */
    public int getLimitaG() {
        return limitaG;
    }
}
