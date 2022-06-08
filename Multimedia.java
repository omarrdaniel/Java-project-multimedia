// Superclasse astratta
public abstract class Multimedia {
    protected String title;
    protected int time;
    protected static int volume = 10;
    protected static int brightness = 10;
    protected String out;

    public Multimedia(String title) {
        this.title = title;
    }

    public Multimedia(String title, int time) {
        this.title = title;
        this.time = time;
    }

    // Metodo getter (serve per recuperare il titolo del multimedia richiesto)
    public String getTitle() {
        return title;
    }
}