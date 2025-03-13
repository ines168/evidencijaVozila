import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvidencijaVozila {
    private List<Vozilo> listaVozila;

    public EvidencijaVozila() {
        listaVozila = new ArrayList<>();
    }

    public void getListaVozila() {
        if(listaVozila.isEmpty()) {
            System.out.println("Nema vozila u evidenciji.");
        } else {
            for (Vozilo vozilo : listaVozila) {
                System.out.println(vozilo.prikaziPodatke());
            }
        }
    }

    public void addVozilo(Vozilo vozilo) {
        listaVozila.add(vozilo);
    }

    public void spremiPodatkeUDatoteku(String datoteka) throws IOException {
        try (BufferedWriter izlaz = new BufferedWriter(new FileWriter(datoteka))){
            for (Vozilo vozilo: listaVozila){
                izlaz.write(vozilo.prikaziPodatke());
                izlaz.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Greška pri spremanju u datoteku! "+ e.getMessage());
        }
    }

    public void ucitajPodatkeIzDatoteke(String datoteka) throws IOException {
        try (BufferedReader ulaz = new BufferedReader(new FileReader(datoteka))){
            String c;
            while((c = ulaz.readLine()) != null) {
                System.out.println(c);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Greška pri učitavanju iz datoteke: " + e.getMessage());
        }
    }
}
