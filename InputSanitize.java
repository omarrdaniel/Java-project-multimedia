import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputSanitize {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    // Metodo per l'inserimento di numeri interi con gestione di eventuali eccezioni
    public static int setInt() {
        //standard di input

        int numero = 0;
        boolean exit = false;
        do {
            try {
                //input del numero da parte dell'utente con la gestione di eventuali eccezioni e ripetizione in caso di eccezioni
                String string = bufferedReader.readLine();
                numero = Integer.parseInt(string);
                exit = true;
            } catch (Exception exc) {
                System.err.println("Errore di digitazione, riprova");
                exit = false;
            }
        } while (!exit);
        return numero;
    }

    //definizione metodo per l'inserimento di stringhe con gestione di eventuali eccezioni (bufferedreader può generare eccezione)
    public static String setString() {
        boolean exit = false;
        String string = null;
        do {
            try {
                string = bufferedReader.readLine();
                exit = true;
            } catch (IOException e) {
                System.out.println("Errore nella digitazione");
                exit = false;
            }
        } while (!exit);
        return string;
    }
}
