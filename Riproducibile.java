// Interfaccia che caratterizza i file multimediali riproducibili (AUDIO)
public interface Riproducibile {

    // Metodo per abbassare il volume
    public void weaker(int volume);

    // Metodo per alzare il volume
    public void louder(int volume);

    // Metodo per riprodurre il contenuto
    public void play();
}
