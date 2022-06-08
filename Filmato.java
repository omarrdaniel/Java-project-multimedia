// Classe che rappresenta i multimedia di tipo Filmato
public class Filmato extends Multimedia implements Riproducibile, Visualizzabile {

    // Costruttore che richiama quello della classe padre
    public Filmato(String title, int time) {
        super(title, time);
    }

    // Metodo per riprodurre il filmato (* luminosità, ! volume)
    @Override
    public void play() {
        out = title;
        for (int i = 0; i < Multimedia.volume; i++) {
            out = out.concat("!");
        }
        for (int i = 0; i < Multimedia.brightness; i++) {
            out = out.concat("*");
        }
        for (int i = 0; i <= time; i++) {
            System.out.println(out);
        }
    }

    // Metodo per abbassare la luminosità con controllo che
    // non possa assumere numeri negativi
    @Override
    public void darker(int brightness) {
        if (brightness >= Multimedia.brightness) {
            Multimedia.brightness = 0;
        } else {
            Multimedia.brightness = Multimedia.brightness - brightness;
        }
    }

    // Metodo per alzare la luminosità con controlo che
    // non si possano inserire numeri negativi
    @Override
    public void brighter(int brightness) {
        if (brightness < 0) {
            System.err.println("\nNumero negativo!\n");
        } else {
            Multimedia.brightness = Multimedia.brightness + brightness;
        }
    }

    // Metodo per alzare il volume con controllo che
    // non si possano inserire numeri negativi
    @Override
    public void louder(int volume) {
        if (volume < 0) {
            System.err.println("\nNumero negativo!\n");
        } else {
            Multimedia.volume = Multimedia.volume + volume;
        }
    }

    // Metodo per abbassare il volume con controllo che
    // non possa assumere valori negativi
    @Override
    public void weaker(int volume) {
        if (volume >= Multimedia.volume) {
            Multimedia.volume = 0;
        } else {
            Multimedia.volume = Multimedia.volume - volume;
        }
    }
}
