// Classe che rappresenta i multimedia di tipo audio
public class Audio extends Multimedia implements Riproducibile {

    // Costruttore che richiama quello della superclasse
    public Audio(String title, int time) {
        super(title, time);
    }

    // Metodo per alzare il volume
    @Override
    public void louder(int volume) {
        if (volume < 0) {
            System.err.println("\nNumero negativo!\n");
        } else {
            Multimedia.volume = Multimedia.volume + volume;
        }
    }

    // Metodo per riprodurre il contenuto (! indicano il volume)
    @Override
    public void play() {
        out = title;
        for (int i = 0; i < Multimedia.volume; i++) {
            out = out.concat("!");
        }
        for (int i = 0; i < time; i++) {
            System.out.println(out);
        }
    }

    // Metodo per abbassare il volume con controllo che
    // non possa assumere numeri negativi
    @Override
    public void weaker(int volume) {
        if (volume >= Multimedia.volume) {
            Multimedia.volume = 0;
        } else {
            Multimedia.volume = Multimedia.volume - volume;
        }
    }
}

