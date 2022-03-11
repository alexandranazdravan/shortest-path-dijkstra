/**
 * O clasa mai generala pentru vehiculele de gabarit mic
 */
public class Moped {
    /**
     * gabaritul unui Moped
     */
    private int limitaG = 1;

    /**
     * Singurul constructor de care am nevoie este cel fara parametrii,
     *      caci niciodata nu voi avea alt gabarit
     */
    public Moped() {
    }

    /**
     * Getter-ul pentru gabarit
     * @return fiind un getter, returnez variabila de membru
     */
    public int getLimitaG() {
        return limitaG;
    }
}
