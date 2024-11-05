package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla {
    private final int hitelKeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelKeret) {
        super(tulajdonos);
        this.hitelKeret = hitelKeret;
    }

    public int getHitelKeret() {
        return hitelKeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (egyenleg - osszeg >= -hitelKeret) {
            egyenleg -= osszeg;
            return true;
        } else {
            return false;
        }
    }
}
