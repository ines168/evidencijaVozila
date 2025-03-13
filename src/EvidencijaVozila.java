import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvidencijaVozila {
    private List<Vozilo> listaVozila;
    private List<Vozilo> listaUcitanihVozila;

    public EvidencijaVozila() {
        listaVozila = new ArrayList<>();
        listaUcitanihVozila = new ArrayList<>();
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

    //čita podatke iz datoteke, kreira objekte učitanih vozila i dodaje ih u listUčitanihVozila
    //da bi razlikovali automobile od motocikala, dodali smo njihovim klasama svojstvo tipVozila
    //vozilo izgleda ovako: Automobil,ZG-123-HU,Toyota,2015,5
    public void ucitajPodatkeIzDatoteke(String datoteka) throws IOException {
        try (BufferedReader ulaz = new BufferedReader(new FileReader(datoteka))){
            String c;
            while((c = ulaz.readLine()) != null) {
                //System.out.println(c);
                String[] splitC = c.split(",");
                //tip vozila nalazi se na prvom mjestu
                String tipVozila = splitC[0];
                if (tipVozila.equalsIgnoreCase("Automobil")) {
                    listaUcitanihVozila.add(new Automobil(splitC[1], splitC[2], Integer.parseInt(splitC[3]), Integer.parseInt(splitC[4])));
                } else if (tipVozila.equalsIgnoreCase("Motocikl")) {
                    listaUcitanihVozila.add(new Motocikl(splitC[1], splitC[2], Integer.parseInt(splitC[3]), splitC[4]));
                }
            }
            for (Vozilo vozilo : listaUcitanihVozila) {
                System.out.println(vozilo.prikaziPodatke());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Greška pri učitavanju iz datoteke: " + e.getMessage());
        } catch (NeispravniPodaciException e) {
            throw new RuntimeException(e);
        }
    }
}
//Jedno od pitanja:
//        *pozdrav, samo da pitam da li ucitajPodatkeIzDatoteke mora samo ispisat ili mora i spremat podatke u listu
//# ako učitaš podatke iz datoteke, onda se oni kreiraju kao objekti,.,novi automobil, novi motor itd