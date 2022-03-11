/**
 * Clasa care reprezinta o strada din oras si care are ca variabile de membru
 *      numele nodului urmator, costul strazii, limita de gabarit a strazii si
 *      restrctiile, care initial sunt 0, dar daca se apare vreun ambuteiaj,
 *      se tot aduna costuri suplimentare in acest int.
 */
public class Muchie {
    /**
     * nodul final unde ajunge se termina muchia, adica strada
     */
    private Nod end;
    /**
     * costul strazii
     */
    private int cost;
    /**
     * variabila in care adun restrictii, daca este cazul
     */
    private int restrictie = 0; /*daca nu exista ambuteiaje, costul restrictiilor va fi 0*/
    /**
     * limita de gabarit a strazii
     */
    private int gabarit;

    /**
     * Constructor cu parametrii (singurul de care am nevoie, de altfel)
     * @param newEnd -> nodul unde se termina strada
     * @param newCost -> costul strazii
     * @param newGabarit -> limita de gabarit a strazii
     */
    public Muchie(Nod newEnd, int newCost, int newGabarit) {
        this.end = newEnd;
        this.cost = newCost;
        this.gabarit = newGabarit;
    }

    /**
     * Constructor fara parametri
     */
    public Muchie() {
    }

    /**
     * Getter-ul pentru cost
     * @return -> getter care returneaza costul strazii
     */
    public int getCost() {
        return cost;
    }

    /**
     * Getter-ul pentru limita de gabarit
     * @return -> getter care returneaza limita de gabarit a strazii
     */
    public int getGabarit() {
        return gabarit;
    }

    /**
     * Getter-ul pentru nodul de end
     * @return -> getter care returneaza nodul in care ajunge strada
     */
    public Nod getEnd() {
        return end;
    }

    /**
     * Getter-ul pentru restrictii
     * @return -> getter care returneaza restrctiile strazii
     */
    public int getRestrictie() {
        return restrictie;
    }

    /**
     * Setter-ul pentru nodul de end
     * @param end -> seteaza nodul unde ajunge strada
     */
    public void setEnd(Nod end) {
        this.end = end;
    }

    /**
     * Setter-ul pentru cost
     * @param cost -> o noua setare pentru costul strazii(al muchiei)
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Setter-ul pentru limita de gabarit
     * @param gabarit -> o noua setare pentru limita de gabarit
     */
    public void setGabarit(int gabarit) {
        this.gabarit = gabarit;
    }

    /**
     * Setter-ul pentru restrictii
     * @param restrictie -> o noua setare pentru restrictie
     */
    public void setRestrictie(int restrictie) {
        this.restrictie = restrictie;
    }

    /**
     * Meotda care imi aduna o noua restrictie
     * @param c -> cost suplimentar ce apare din cauza unui ambuteiaj;
     *          acesta se adauga la restrictie
     */
    public void addRestriction(int c) {
            this.restrictie += c;
    }
}
