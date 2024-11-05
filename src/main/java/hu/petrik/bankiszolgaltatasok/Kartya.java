package hu.petrik.bankiszolgaltatasok;

public class Kartya extends BankiSzolgaltatas {
    private final String kartyaSzam;
    private final Szamla szamla;

    public Kartya(Tulajdonos tulajdonos, Szamla szamla, String kartyaSzam) {
        super(tulajdonos);
        this.kartyaSzam = kartyaSzam;
        this.szamla = szamla;
    }

    public String getKartyaSzam() {
        return kartyaSzam;
    }

    public boolean vasarlas(int osszeg) {
        return szamla.kivesz(osszeg);
    }
}
