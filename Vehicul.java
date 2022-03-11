/**
 * Interfata care uneste toate tipurile de vehicule
 */
public interface Vehicul {
    /**
     * Metoda ce trebuie regasita in toate clasele ce implementeaza interfata, aceasta creand
     *      un anumit tip de vehicul cu toate caracteristicile sale.
     * @param type poate fi a b c sau m, iar cand apelez functia, il setez in variabila
     *             de membru key din Autoturism, Bicicleta, Camion, Motocicleta;
     *             tot in metoda aceasta setez si limita de gabarit si costul suplimentar
     *             al vechicului
     */
    void creeaza(String type);
}
