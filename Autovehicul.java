/**
 * Clasa generala a mijloacelor de transport care au gabarit mediu
 */
public class Autovehicul {
    /**
     * gabaritul unui Autovehicul
     */
    private int limitaG = 2;

    /**
     * Singurul constructor de care am nevoie este cel fara parametrii,
     *      caci niciodata nu voi avea alt gabarit
     */
    public Autovehicul() {
    }

    /**
     * Getter-ul pentru gabarit
     * @return fiind un getter, returnez variabila de membru
     */
    public int getLimitaG() {
        return limitaG;
    }
}
