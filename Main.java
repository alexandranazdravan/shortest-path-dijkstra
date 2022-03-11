import java.io.File;
import java.util.Scanner;
import java.io.*;
import static java.lang.Integer.parseInt;

/**
 * Clasa principala, in care citesc din fisier, imi apelez metodele pentru
 *      a crea harta orasului si in care citesc din fisier.
 */
public class Main {
    /**
     * Aici citesc din fisiere si apelez metodele din Graph
     * @param args -> un array de argumente pentru aplicatie
     */
    public static void main(String[] args) {
        int nrMuchii;
        int nrNoduri;

        try {
            File f = new File("map.in");
            Scanner s = new Scanner(f);

            String data = s.nextLine();

            String[] splited = data.split(" ");
            nrMuchii = parseInt(splited[0]);
            nrNoduri = parseInt(splited[1]);

            Graph graph = new Graph(nrMuchii);
            graph.setNrNoduri(nrNoduri);

            int i = 0;
            while (s.hasNextLine()) {
                data = s.nextLine();
                if (data.charAt(0) == 'P') {
                    splited = data.split(" ");

                    graph.addStreet(new Nod(splited[0]), new Nod(splited[1]), parseInt(splited[2]),
                            parseInt(splited[3]));
                } else {

                    splited = data.split(" ");
                    String accident = "accident";
                    String trafic = "trafic";
                    String blocaj = "blocaj";
                    String drive = "drive";
                    String actiune = splited[0];

                    if (actiune.equals(trafic) || actiune.equals(accident) || actiune.equals(blocaj)) {
                        graph.addRestriction(splited[0], new Nod(splited[1]), new Nod(splited[2]), Integer.parseInt(splited[3]));
                    } else if (actiune.equals(drive)) {
                        int sursa = parseInt(splited[2].substring(1));
                        int dest = parseInt(splited[3].substring(1));
                        String type = splited[1];
                        check_vehicle(type,sursa,dest,graph);
                    }
                }
                i = i + 1;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    /**
     * Verific ce tip de vehicul s-a citit si apoi apelez drive()
     * @param type -> a,b,c sau m : key-ul pentru tipul de vehicul
     * @param sursa -> nodul de start
     * @param dest -> nodul final
     * @param graph -> harta orasului(graful)
     */
   public static void check_vehicle(String type, int sursa, int dest, Graph graph) {
       switch (type) {
           case "b" : {
               Bicicleta v = new Bicicleta();
               v.creeaza("b");
               graph.drive(v, sursa, dest);
               break;
           }
           case "a" : {
               Autoturism v = new Autoturism();
               v.creeaza("a");
               graph.drive(v, sursa, dest);
               break;
           }
           case "m" : {
               Motocicleta v = new Motocicleta();
               v.creeaza("m");
               graph.drive(v, sursa, dest);
               break;
           }
           case "c" : {
               Camion v = new Camion();
               v.creeaza("c");
               graph.drive(v, sursa, dest);
               break;
           }
       }
    }
}

