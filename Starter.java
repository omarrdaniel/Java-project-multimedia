import java.util.ArrayList;

public class Starter {
    // Metodo che utilizza instanceOf per capire di quale oggetto specifico si tratta
    // Ritorna 1,2,3 in base al tipo di oggetto
    public static int objectType(Multimedia multimedia) {
        if (multimedia instanceof Audio) {
            return 1;
        } else if (multimedia instanceof Filmato) {
            return 2;
        } else if (multimedia instanceof Immagine) {
            return 3;
        }
        return 0;
    }

    // Metodo main
    public static void main(String[] args) {
        System.out.println("\n" +
                "  _         _   _                   __  __       _ _   _                    _ _       _      \n" +
                " | |    ___| |_| |_ ___  _ __ ___  |  \\/  |_   _| | |_(_)_ __ ___   ___  __| (_) __ _| | ___ \n" +
                " | |   / _ | __| __/ _ \\| '__/ _ \\ | |\\/| | | | | | __| | '_ ` _ \\ / _ \\/ _` | |/ _` | |/ _ \\\n" +
                " | |__|  __| |_| || (_) | | |  __/ | |  | | |_| | | |_| | | | | | |  __| (_| | | (_| | |  __/\n" +
                " |_____\\___|\\__|\\__\\___/|_|  \\___| |_|  |_|\\__,_|_|\\__|_|_| |_| |_|\\___|\\__,_|_|\\__,_|_|\\___|\n" +
                "                                                                                             \n");
        System.out.println("Benvenuto! Inizia ad inserire i file multimediali che desideri utilizzare");
        // Variabili di supporto del programma per gestire cicli
        boolean exit = false;
        // Contatore elementi array
        int counter = 0;
        int choice;
        int selectedObject;
        int select;
        // ArrayList che contiene oggetti di tipo Multimedia
        ArrayList<Multimedia> multimedia = new ArrayList<>(1);
        do {
            counter++;
            // Scelta da parte dell'utente sulla tipologia di media da inserire con controllo adeguatezza input (1<=select<=3)
            System.out.println("Che tipo di multimedia vuoi aggiungere?");
            System.out.println("1 - Audio");
            System.out.println("2 - Filmato");
            System.out.println("3 - Immagine");
            do {
                select = InputSanitize.setInt();
                if (select < 1 || select > 3) {
                    System.err.println("Scelta non presente nel menu, riprova!");
                }
            } while (select < 1 || select > 3);
            switch (select) {
                case 1:
                    System.out.println("Digita il titolo");
                    String title = InputSanitize.setString();
                    System.out.println("Digita la durata");
                    int time = InputSanitize.setInt();
                    multimedia.add(new Audio(title, time));
                    break;
                case 2:
                    System.out.println("Digita il titolo");
                    String title2 = InputSanitize.setString();
                    System.out.println("Digita la durata");
                    int time2 = InputSanitize.setInt();
                    multimedia.add(new Filmato(title2, time2));
                    break;
                case 3:
                    System.out.println("Digita il titolo");
                    String title3 = InputSanitize.setString();
                    multimedia.add(new Immagine(title3));
                    break;
                default:
                    System.err.println("Scelta non esistente");
            }
            // Viene chiesto all'utente se vuole inserire un altro media con controllo su input utente
            do {
                System.out.println("Vuoi inserire un altro multimedia? 1 - Si, 0 - No");
                choice = InputSanitize.setInt();
                if (choice != 1) {
                    if (choice != 0) {
                        System.err.println("Errore nella digitazione, riprova!");
                    }
                }
            } while (choice != 1 && choice != 0);
            if (choice != 1) {
                exit = true;
            }
        } while (!exit && counter < 5);
        // La dimensione dell'arraylist viene ridotta al numero effettivo di elementi contenuti
        multimedia.trimToSize();
        // Scelta da parte dell'utente del media sul quale operare con controllo correttezza input per evitare eccezioni
        do {
            System.out.println("Con quale multimedia vuoi operare?");
            for (int i = 0; i < multimedia.size(); i++) {
                System.out.println(i + 1 + " - " + multimedia.get(i).getTitle());
            }
            System.out.println("Digita 0 per terminare il programma");
            do {
                selectedObject = (InputSanitize.setInt());
                selectedObject -= 1;
                if (selectedObject > multimedia.size() - 1) {
                    System.err.println("Elemento non esistente, riprova!");
                }
            } while (selectedObject > multimedia.size() - 1);

            // In base alla scelta dell'utente, si capisce che tipo di oggetto è e quali operazioni si posso svolgere su esso
            boolean exit1 = false;
            switch (selectedObject) {
                // I case sono in ordine inverso così che con qualsiasi elemento si vogli operare, rientriamo nel case 0
                case 4:
                case 3:
                case 2:
                case 1:
                case 0:
                    do {
                        // In base al tipo di oggetto (determinato da objectType) si entrerà nel case corrispondente
                        switch (objectType(multimedia.get(selectedObject))) {
                            case 1:
                                Audio audio = (Audio) multimedia.get(selectedObject);
                                System.out.println("Scegli una delle seguenti azioni: ");
                                System.out.println("1 - Play");
                                System.out.println("2 - Abbassa il volume");
                                System.out.println("3 - Alza il volume");
                                System.out.println("4 - Torna al menu");
                                switch (InputSanitize.setInt()) {
                                    case 1:
                                        audio.play();
                                        break;
                                    case 2:
                                        System.out.println("Di quanto vuoi abbassare il volume?");
                                        audio.weaker(InputSanitize.setInt());
                                        break;
                                    case 3:
                                        System.out.println("Di quanto vuoi alzare il volume?");
                                        audio.louder(InputSanitize.setInt());
                                        break;
                                    case 4:
                                        exit1 = true;
                                        break;
                                    default:
                                        System.err.println("Scelta non esistente");
                                }
                                break;
                            case 2:
                                Filmato filmato = (Filmato) multimedia.get(selectedObject);
                                System.out.println("Scegli una delle seguenti azioni: ");
                                System.out.println("1 - Play");
                                System.out.println("2 - Abbassa il volume");
                                System.out.println("3 - Alza il volume");
                                System.out.println("4 - Alza la luminosita'");
                                System.out.println("5 - Abbassa la luminosita'");
                                System.out.println("6 - Torna al menu");
                                switch (InputSanitize.setInt()) {
                                    case 1:
                                        filmato.play();
                                        break;
                                    case 2:
                                        System.out.println("Di quanto vuoi abbassare il volume?");
                                        filmato.weaker(InputSanitize.setInt());
                                        break;
                                    case 3:
                                        System.out.println("Di quanto vuoi alzare il volume?");
                                        filmato.louder(InputSanitize.setInt());
                                        break;
                                    case 4:
                                        System.out.println("Di quanto vuoi alzare la luminosita'?");
                                        filmato.brighter(InputSanitize.setInt());
                                        break;
                                    case 5:
                                        System.out.println("Di quanto vuoi abbassare la luminosita'?");
                                        filmato.darker(InputSanitize.setInt());
                                        break;
                                    case 6:
                                        exit1 = true;
                                        break;
                                    default:
                                        System.err.println("Scelta non esistente");
                                }
                                break;
                            case 3:
                                Immagine immagine = (Immagine) multimedia.get(selectedObject);
                                System.out.println("Scegli una delle seguenti azioni: ");
                                System.out.println("1 - Visualizza");
                                System.out.println("2 - Abbassa la luminosita'");
                                System.out.println("3 - Alza la luminosita'");
                                System.out.println("4 - Torna al menu");
                                switch (InputSanitize.setInt()) {
                                    case 1:
                                        immagine.show();
                                        break;
                                    case 2:
                                        System.out.println("Di quanto vuoi abbassare la luminosita'?");
                                        immagine.darker(InputSanitize.setInt());
                                        break;
                                    case 3:
                                        System.out.println("Di quanto vuoi alzare la luminosita'?");
                                        immagine.brighter(InputSanitize.setInt());
                                        break;
                                    case 4:
                                        exit1 = true;
                                        break;
                                    default:
                                        System.err.println("Scelta non esistente");
                                }
                                break;
                            default:
                                System.err.println("Scelta non esistente");
                        }
                    } while (!exit1);
                    break;
                // Case -1 si riferisce all'uscita (scelta dell'utente -1, quindi con 0 digitato dall'utente si esce)
                case -1:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Scelta non esistente");
            }
        } while (true);
    }
}