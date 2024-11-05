package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Szamla> szamlak = new ArrayList<>();

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelkeret) {
        if (hitelkeret < 0) {
            throw new IllegalArgumentException("Negatív hitelkeret nem megengedett");
        }

        Szamla ujSzamla;
        if (hitelkeret == 0) {
            ujSzamla = new MegtakaritasiSzamla(tulajdonos);
        } else {
            ujSzamla = new HitelSzamla(tulajdonos, hitelkeret);
        }
        szamlak.add(ujSzamla);
        return ujSzamla;
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos) {
        int osszEgyenleg = 0;
        for (Szamla szamla : szamlak) {
            if (szamla.getTulajdonos().equals(tulajdonos)) {
                osszEgyenleg += szamla.getEgyenleg();
            }
        }
        return osszEgyenleg;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        Szamla legnagyobb = null;
        for (Szamla szamla : szamlak) {
            if (szamla.getTulajdonos().equals(tulajdonos)) {
                if (legnagyobb == null || szamla.getEgyenleg() > legnagyobb.getEgyenleg()) {
                    legnagyobb = szamla;
                }
            }
        }
        return legnagyobb;
    }

    public int getOsszHitelkeret() {
        int osszHitelkeret = 0;
        for (Szamla szamla : szamlak) {
            if (szamla instanceof HitelSzamla) {
                osszHitelkeret += ((HitelSzamla) szamla).getHitelKeret();
            }
        }
        return osszHitelkeret;
    }
}
