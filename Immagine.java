// Classe che rappresenta i multimedia di tipo Immagine
public class Immagine extends Multimedia implements Visualizzabile {

    // Costruttore che riprendere il costruttore della classe padre
    public Immagine(String title) {
        super(title);
    }

    // Metodo per alzare la luminosità con controllo che
    // non si possano inserire numeri negativi
    @Override
    public void brighter(int brightness) {
        if (brightness < 0) {
            System.err.println("\nNumero negativo!\n");
        } else {
            Multimedia.brightness = Multimedia.brightness + brightness;
        }
    }

    // Metodo per abbassare la luminosità con controllo che
    // non possa andare in negativo
    @Override
    public void darker(int brightness) {
        if (brightness >= Multimedia.brightness) {
            Multimedia.brightness = 0;
        } else {
            Multimedia.brightness = Multimedia.brightness - brightness;
        }
    }

    // Metodo per visualizzare l'immagine (* = luminosità)
    public void show() {
        out = title;
        for (int i = 0; i < Multimedia.brightness; i++) {
            out = out.concat("*");
        }
        System.out.println(out);
    }
}
