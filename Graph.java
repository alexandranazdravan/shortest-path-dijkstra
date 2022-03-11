import java.io.*;
import java.util.*;
import java.util.LinkedList;

/**
 * Clasa cea mai importanta, cea in care se afla metodele addStreet, addRestriction, drive.
 * Clasa in care fac cele mai multe prelucrari pe harta.
 * Clasa in care scriu in map.out
 */
public class Graph {
    /**
     * toata harta orasului
     */
    private ArrayList<Muchie>[] muchie;
    /**
     * numarul de noduri din graf, adica din harta
     */
    private int nrNoduri;
    /**
     * variabila actualizata pentru fiecare data cand este drive apelat;
     * aici stochez gabaritul vehiculului condus
     */
    int limitaG = 0;
    /**
     * variabila actualizata pentru fiecare data cand este drive apelat;
     * aici stochez costul vehiculului condus
     */
    int cost = 0;

    /**
     * Constructorul fara parametrii
     */
    public Graph() {
    }

    /**
     * Initializez cate o lista pentru fiecare element al vectorului
     * @param n reprezinta numarul de noduri citite din fisier
     *          ->tot un constructor, creat de mine, nu generat
     *          de Intellij, in care creez un vector de liste
     */
    public Graph(int n) {
        muchie = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            muchie[i] = new ArrayList<>();
        }
    }

    /**
     * Setter-ul pentru numarul de noduri
     * @param nrNoduri este numarul de noduri care exista pe harta, adica in graf
     */
    public void setNrNoduri(int nrNoduri) {
        this.nrNoduri = nrNoduri;
    }

    /**
     * Setter-ul pentru cost
     * @param cost se refera la costul autovehicului ce merge pe o strada
     *             si pe care il actualizez de fiecare data cand intru pe
     *             o strada noua
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Setter-ul pentru gabarit
     * @param limitaG este limita de gabarit a unei strazi; pe aceasta
     *                o actualizez, de asemenea, de fiecare data cand
     *                intru pe o strada noua
     */
    public void setLimitaG(int limitaG) {
        this.limitaG = limitaG;
    }

    /**
     * Setter-ul pentru muchie
     * @param muchie reprezinta un vector de strazi, cu "proprietatile" lor:
     *               -> numele nodului in care se duce strada
     *               -> costul strazii
     *               -> restrictiile de pe strada respectiva(costuri
     *                      suplimentare generate de ambuteiaje)
     *               -> limita de gabarit a strazii respective
     */
    public void setMuchie(ArrayList<Muchie>[] muchie) {
        this.muchie = muchie;
    }


    /**
     * Getter-ul pentru cost
     * @return returneaza costul vehiculului
     */
    public int getCost() {
        return cost;
    }

    /**
     * Getter-ul pentru muchie
     * @return returneaza o muchie
     */
    public List<Muchie>[] getMuchie() {
        return muchie;
    }

    /**
     * Getter-ul pentru gabarit
     * @return returneaza gabaritul vehiculului
     */
    public int getLimitaG() {
        return limitaG;
    }

    /**
     * Getter-ul pentru nr. de noduri
     * @return returneaza numarul de noduri din harta
     */
    public int getNrNoduri() {
        return nrNoduri;
    }

    /**
     *  Deoarece am decis sa salvez numele strazilor cu tot cu P,
     *      am avut nevoie sa salvez intr-un int numarul
     *      ce se afla dupa acest P.
     *  Apoi, l-am adaugat in lista ce tine de fiecare element al vectorului.
     *  Am folosit un bubbleSort pentru a avea strazile intr-o lista puse in
     *      ordine. (nu era necesara sortarea, dar asa mi se pare ca arata mai
     *      ordonat).
     * @param start -> nodul de unde incepe strada
     * @param end -> nodul in care se termina strada
     * @param cost -> costul strazii
     * @param size -> limita de gabarit a strazii
     */
    public void addStreet(Nod start, Nod end, int cost, int size) {
        int index = Integer.parseInt(start.getNume().substring(1));
        muchie[index].add(0, new Muchie(end, cost, size));
        bubbleSort(muchie[index]);
    }

    /**
     * Bubblesort-ul clasic, aplicat pe vectori, schimbat pentru liste
     * @param arr este o lista pe care o sortez cu clasica metoda
     *            de sortare bubbleSort in care dau swap la elemente
     *            doua cate doua pana cand ajung sa am o lista sortata
     */
    public void bubbleSort(List<Muchie> arr ) {
    int n = arr.size();
    for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (Integer.parseInt(arr.get(j).getEnd().getNume().substring(1)) >
                    Integer.parseInt(arr.get(j+1).getEnd().getNume().substring(1))) {
                Collections.swap(arr, j, j+1);
            }
}

    /**
     * Deoarece am salvat numele nodurilor cu tot cu P, am nevoie
     *             de doua int-uri care sa-mi salveze numarul efectiv de dupa P.
     * Cu aceste doua numere, prima oara caut sa gasesc start-ul in vector si apoi
     *             caut in lista nodurilor ce pornesc din nodul de start sa gasesc
     *             si nodul de end.
     * Cand gasesc, apelez addRestriction, metode din muchie, pentru a adauga
     *             o valoare noua la restrictia unei strazi.
     *
     * @param type reprezinta tipul de ambuteiaj
     * @param start reprezinta nodul de inceput al strazii
     * @param end reprezinta nodul de sfarsit al strazii
     * @param cost reprezinta costul suplimentar ce trebuie adaugat
     *             in urma unui ambuteiaj.
     */
    public void addRestriction(String type, Nod start, Nod end, int cost) {
        int indexS = Integer.parseInt(start.getNume().substring(1));
        int indexE = Integer.parseInt(end.getNume().substring(1));
        for (int i = 0; i < muchie.length; i++) {
            if (i == indexS) {
                for (int j = 0; j < muchie[i].size(); j++) {
                    int cauta = Integer.parseInt(muchie[i].get(j).getEnd().getNume().substring(1));
                    if (cauta == indexE) {
                        muchie[i].get(j).addRestriction(cost);
                    }
                }
            }
        }
    }

    /**
     * Caut index-ul la care se afla minimul din vectorul de costuri.
     * @param b -> un vector de boolean care verifica daca un nod
     *          e verificat sau nu e verificat
     * @param dist -> vectorul de distante minime
     * @param n -> numarul de noduri din harta
     * @return returnez indexul la care gasesc distanta cea mai mica
     */
    public int minDistace(Boolean[] b, int[] dist, int n) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int x = 0; x < n; x++) {
            if (!b[x] && dist[x] < min) {
                min = dist[x];
                index = x;
            }
        }
        return index;
    }

    /**
     *  Cu ajutorul metodei getClass() deja implementata, aflu
     *          cu ce tip de vehicul am de a face.
     *  Este nevoie sa folosesc split pentru ca mi se salveaza in c
     *          ceva de genul "class Motocicleta" iar eu am nevoie doar
     *          de Motocicleta, de a doua parte a string-ului.
     *  In functie de ce se salveaza in type, imi setez limitaG si costul
     * @param v -> tipul general de vehicul
     */
    public void getObj(Vehicul v) {
        Class c = v.getClass();
        String[] clasa = String.valueOf(c).split(" ");
        String type = clasa[1];

        if(type.equals("Motocicleta")) {
            limitaG = ((Motocicleta)v).getLimitaG();
            cost = ((Motocicleta)v).getCostSupl();

        }
        else if(type.equals("Autoturism")) {
            limitaG = ((Autoturism)v).getLimitaG();
            cost = ((Autoturism)v).getCostSupl();

        }
        else if(type.equals("Camion")) {
            limitaG = ((Camion)v).getLimitaG();
            cost = ((Camion)v).getCostSupl();

        }
        else if(type.equals("Bicicleta")) {
            limitaG = ((Bicicleta)v).getLimitaG();
            cost = ((Bicicleta)v).getCostSupl();

        }

    }

    /**
     * Prima oara, caut in vector nodul de start.
     * Cand il gasesc, incep sa caut in lista acestui nod. Exista si nodul
     *      destinatie in lista de vecini(ca sa o numesc asa)?
     * Daca exista, o returnez
     * @param src -> nodul de start
     * @param dest -> nodul de finish
     * @return returnez strada daca o gasesc(muchia) si returnez null
     *      daca nu exista acea strada.
     */
    public Muchie getObj(int src, int dest) {
        for (int i = 0; i < muchie.length; i++) {
            if (i == src) {
                for (int j = 0; j < muchie[i].size(); j++) {
                    int indexE = Integer.parseInt(muchie[i].get(j).getEnd().getNume().substring(1));
                    if (dest == indexE) {
                        return muchie[i].get(j);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Metoda in care scriu in map.out
     * @param src -> nodul de start
     * @param dest -> nodul de finish
     * @param dist -> vectorul de costuri
     * @param parent -> vectorul in care salvez path-ul
     * @param out -> BufferWrier-ul cu ajutorul caruia scriu in fisierul map.out
     * @throws IOException -> se intampla daca nu apare vreo problema la operatiile de tip I/O
     */
    public void scrie(int src, int dest, int[] dist, int[] parent, BufferedWriter out) throws IOException{
        File log = new File("map.out");
        int temp = dest;
        String[] afisare = new String[nrNoduri];
        List<String> write = new LinkedList<>();
        Arrays.fill(afisare, "X");
        try{
            if(!log.exists()){
                log.createNewFile();
            }
            if (dist[dest] == Integer.MAX_VALUE) {
                write.add("P"+ src + " P" + dest + " null" + "\n");
            } else {
                int i = 0;
                while (temp != src) {
                    afisare[i] = "P" + Integer.toString(temp);
                    i++;
                    temp = parent[temp];
                }
                write.add("P" + src + " ");
                for (int j = afisare.length - 1; j >= 0; j--) {
                    if (!afisare[j].equals("X"))
                        write.add(afisare[j] + " ");
                }
                write.add(String.valueOf(dist[dest]) + "\n");
            }
            for (int i = 0; i < write.size(); i++) {
                out.write(String.valueOf(write.get(i)));

            }
        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
        }
    }

    /**
     * O implementare clasica a algoritmului Dijkstra, adica fara PriorityQueue
     * @param v -> vehiculul(la modul general)
     * @param src -> nodul de start
     * @param dest -> nodul final
     */
    public void drive(Vehicul v, int src, int dest) {
        int[] dist = new int[nrNoduri];
        Boolean[] b = new Boolean[nrNoduri];
        int[] parent = new int[nrNoduri];

        getObj(v);

        for (int i = 0; i < nrNoduri; i++) {
            b[i] = false;
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        parent[src] = -1;
        dist[src] = 0;

        for (int i = 0; i < nrNoduri; i++) {
            int u = minDistace(b, dist, nrNoduri);
            if (u == -1) {
                continue;
            }
            b[u] = true;

            for (int j = 0; j < nrNoduri; j++) {
                Muchie m = getObj(u,j);

                if (m != null) {
                    if (limitaG <= m.getGabarit()) {

                        int aux = cost * m.getCost() + m.getRestrictie();

                        if (!b[j] && dist[u] != Integer.MAX_VALUE && ((dist[u] + aux) < dist[j])) {
                            dist[j] = dist[u] + aux;
                            parent[j] = u;
                        }
                    }
                }
            }
        }
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("map.out", true));
            scrie(src,dest,dist,parent,out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


