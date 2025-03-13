import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, NeispravniPodaciException {
        try{
            EvidencijaVozila vozila = new EvidencijaVozila();
            vozila.addVozilo(new Automobil("ZG-123-HU", "Toyota", 2015, 5));
            vozila.addVozilo(new Motocikl("PU-898-K", "Aprilia", 2020, "Enduro"));
            vozila.addVozilo(new Automobil("ST-4567-DZ", "Fiat", 2012, 3));
            vozila.addVozilo(new Motocikl("RI-765-FK", "Kawasaki", 2021, "Sportski"));

            //ispis svih vozila
            //vozila.getListaVozila();

            //spremanje vozila u datoteku
            vozila.spremiPodatkeUDatoteku("EvidencijaVozila.txt");

            //učitavanje vozila iz datoteke
            vozila.ucitajPodatkeIzDatoteke("EvidencijaVozila.txt");
        } catch (NeispravniPodaciException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Greška u radu s datotekom: " + e.getMessage());
        }
    }
}
