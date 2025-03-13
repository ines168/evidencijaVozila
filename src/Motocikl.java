public class Motocikl extends Vozilo{
    private String tipVozila;
    private String tipMotora;

    public Motocikl(String registarskiBroj, String markaVozila, int godinaProizvodnje, String tipMotora) throws NeispravniPodaciException {
        super(registarskiBroj, markaVozila, godinaProizvodnje);
        this.tipMotora = tipMotora;
        this.tipVozila = "Motocikl";
    }

    public String getTipMotora() {
        return tipMotora;
    }

    public void setTipMotora(String tipMotora) {
        this.tipMotora = tipMotora;
    }

    @Override
    public String prikaziPodatke() {
        return tipVozila + "," + super.prikaziPodatke() + "," + tipMotora;
    }
}
