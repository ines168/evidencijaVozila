public class Automobil extends Vozilo{
    private int brojVrata;

    public Automobil(String registarskiBroj, String markaVozila, int godinaProizvodnje, int brojVrata) throws NeispravniPodaciException {
        super(registarskiBroj, markaVozila, godinaProizvodnje);
        if (brojVrata<1) {
            throw new NeispravniPodaciException("Neispravan broj vrata.");
        }
        this.brojVrata = brojVrata;
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(int brojVrata) throws NeispravniPodaciException {
        if(brojVrata<1) {
            throw new NeispravniPodaciException("Neispravan broj vrata.");
        }
        this.brojVrata = brojVrata;
    }

    @Override
    public String prikaziPodatke() {
        return super.prikaziPodatke() + ", Broj vrata: " + brojVrata;
    }
}
