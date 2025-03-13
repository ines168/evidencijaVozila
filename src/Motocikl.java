public class Motocikl extends Vozilo{
    private String tipMotora;

    public Motocikl(String registarskiBroj, String markaVozila, int godinaProizvodnje, String tipMotora) throws NeispravniPodaciException {
        super(registarskiBroj, markaVozila, godinaProizvodnje);
        this.tipMotora = tipMotora;
    }

    public String getTipMotora() {
        return tipMotora;
    }

    public void setTipMotora(String tipMotora) {
        this.tipMotora = tipMotora;
    }

    @Override
    public String prikaziPodatke() {
        return super.prikaziPodatke() + ", Tip motora: " + tipMotora;
    }
}
