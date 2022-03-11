/**
 * O clasa care reprezinta nodul dintr-un graf si care are o singura
 *      variabila, numele acelui nod
 */
public class Nod  {
    /**
     * numele unui nod de pe o strada
     */
    private String nume;

    /**
     * Constructor cu parametru
     * @param newNume -> numele unui nod
     */
    public Nod(String newNume) {
        this.nume = newNume;
    }

    /**
     * Getter-ul pentru nume
     * @return returneaza numele nodului
     */
    public String getNume() {
        return nume;
    }

    /**
     * Setter-ul pentru nume
     * @param nume -> de format P + un numar, reprezinta numele nodului
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

}
