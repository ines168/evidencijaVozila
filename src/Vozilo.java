public class Vozilo{
    private String registarskiBroj;
    private String markaVozila;
    private int godinaProizvodnje;

    public Vozilo(String registarskiBroj, String markaVozila, int godinaProizvodnje) throws NeispravniPodaciException {
        this.registarskiBroj = registarskiBroj;
        this.markaVozila = markaVozila;
        if(godinaProizvodnje<1900) {
            throw new NeispravniPodaciException("Godina proizvodnje je neispravna.");
        }
        this.godinaProizvodnje = godinaProizvodnje;
    }

//    public void ucitajPodatke(String registarskiBroj, String markaVozila, int godinaProizvodnje) throws NeispravniPodaciException {
//        this.registarskiBroj = registarskiBroj;
//        this.markaVozila = markaVozila;
//        if(godinaProizvodnje<1900) {
//            throw new NeispravniPodaciException("Godina proizvodnje je neispravna.");
//        } else {
//            this.godinaProizvodnje = godinaProizvodnje;
//        }
//    }

    public String prikaziPodatke() {
        return "Vozilo: " + registarskiBroj + ", Marka vozila: " + markaVozila + ", Godina proizvodnje: " + godinaProizvodnje;
    }
}
