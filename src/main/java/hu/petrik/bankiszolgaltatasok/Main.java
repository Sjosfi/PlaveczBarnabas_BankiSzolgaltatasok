package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Tulajdonos tulajdonos = new Tulajdonos("Példa Péter");
        Bank bank = new Bank();

        Szamla megtakaritasiSzamla = bank.szamlaNyitas(tulajdonos, 0);
        Szamla hitelSzamla = bank.szamlaNyitas(tulajdonos, 50000);

        megtakaritasiSzamla.befizet(100000);
        System.out.println("Megtakarítási számla egyenleg: " + megtakaritasiSzamla.getEgyenleg());

        if (hitelSzamla.kivesz(20000)) {
            System.out.println("Hitel számláról sikeres kivétel");
        } else {
            System.out.println("Hitel számláról sikertelen kivétel");
        }

        System.out.println("Összes egyenleg: " + bank.getOsszEgyenleg(tulajdonos));
        System.out.println("Legnagyobb egyenlegű számla egyenlege: " +
                bank.getLegnagyobbEgyenleguSzamla(tulajdonos).getEgyenleg());
    }
}
