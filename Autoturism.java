/**
 * O clasa particulara de vehicule (autoturisme), ce se incadreaza in
 *      in categoria mijlocealor de transport de gabarit mediu, adica autovehicule,
 *      si care implementeaza interfata generala de vehicule
 */
public class Autoturism extends Autovehicul implements Vehicul {
    /**
     * key = litera care imi spune pe ce caz sunt(aici a)
     */
    private String key;
    /**
     * costul suplimentar adus de acest tip de vehicul
     */
    private int costSupl;
    /**
     * gabaritul pe care il are acest tip de vehicul
     */
    private int limitaG;

    /**
     * Singurul constructor de care am nevoie este cel fara parametrii,
     *      caci niciodata nu voi avea alt gabarit
     */
    public Autoturism() {
    }

    /**
     * Getter-ul pentru cost suplimentar
     * @return Fiind getter-ul specific pentru variabila de membru costSupl,
     *      o returnez pe aceasta
     */
    public int getCostSupl() {
        return costSupl;
    }

    /**
     * Getter-ul pentru cheie
     * @return Fiind getter-ul specific pentru variabila de membru getKey,
     *      o returnez pe aceasta
     */
    public String getKey() {
        return key;
    }

    /**
     * Getter-ul pentru gabarit
     * @return Fiind getter-ul specific pentru variabila de membru getLimitaG,
     *      o returnez pe aceasta
     */
    @Override
    public int getLimitaG() {
        return limitaG;
    }

    /**
     * Metoda din interfata ce trebuie suprascrisa si care imi creeaza un vehicul de tip
     *      autoturism cu toate caracteristicile sale.
     * @param type se refera la tipul de ambuteiaj, pe care il voi seta in key
     */
    @Override
    public void creeaza(String type) {
        this.limitaG = super.getLimitaG(); /*apelez cu super limita de greutate din clasa parinte*/
        /*si setez limita din clasa copil cu aceeasi valoare*/
        this.key = type;
        this.costSupl = 4;
    }
}
