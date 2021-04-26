package pl.dowhankuniewski.stworzliste;

import pl.dowhankuniewski.mapa.Mapa;
import pl.dowhankuniewski.specjalnepole.ISpecjalnePole;
import pl.dowhankuniewski.specjalnepole.SpecjalnePole;

import java.util.ArrayList;
import java.util.List;

public class StworzListePole {
    private int iloscPol;

    public StworzListePole(int iloscPol) {
        this.iloscPol = iloscPol;
    }

    public List<ISpecjalnePole> stworzListePole(Mapa mapa) {
        List<ISpecjalnePole> lista = new ArrayList<>();

        for (int i=0; i<iloscPol; i++) {
            lista.add(new SpecjalnePole(mapa));
        }

        return lista;
    }
}
