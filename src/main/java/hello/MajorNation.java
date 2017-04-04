package hello;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-04-03.
 */
public class MajorNation {

    private int nationId;
    private List<String> countriesOwned;

    private List<String> countriesOwnedByUsa() {
        List<String> countriesOwnedByUsa = new ArrayList<>();
        countriesOwnedByUsa.add("g8");
        countriesOwnedByUsa.add("g9");
        countriesOwnedByUsa.add("g10");
        countriesOwnedByUsa.add("g11");

        return countriesOwnedByUsa;
    }

    private List<String> countriesOwnedByBritain() {
        List<String> countriesOwnedBritain = new ArrayList<>();
        countriesOwnedBritain.add("g38");
        countriesOwnedBritain.add("g39");
        countriesOwnedBritain.add("g40");

        return countriesOwnedBritain;
    }

    private List<String> countriesOwnedByFrance() {
        List<String> countriesOwnedFrance = new ArrayList<>();
        countriesOwnedFrance.add("g50");
        countriesOwnedFrance.add("g51");
        countriesOwnedFrance.add("g54");

        return countriesOwnedFrance;
    }

    private List<String> countriesOwnedByGermany() {
        List<String> countriesOwnedGermany = new ArrayList<>();
        countriesOwnedGermany.add("g45");
        countriesOwnedGermany.add("g46");
        countriesOwnedGermany.add("g60");

        return countriesOwnedGermany;
    }

    private List<String> countriesOwnedByRussia() {
        List<String> countriesOwnedRussia = new ArrayList<>();
        countriesOwnedRussia.add("g43");
        countriesOwnedRussia.add("g44");
        countriesOwnedRussia.add("g99");
        countriesOwnedRussia.add("g112");
        countriesOwnedRussia.add("g100");
        countriesOwnedRussia.add("g101");

        return countriesOwnedRussia;
    }

    private List<String> countriesOwnedByJapan() {
        List<String> countriesOwnedJapan = new ArrayList<>();
        countriesOwnedJapan.add("g103");
        countriesOwnedJapan.add("g104");
        countriesOwnedJapan.add("g105");
        countriesOwnedJapan.add("g106");

        return countriesOwnedJapan;
    }

    public List<String> getCountriesOwnedByUsa() {
        return countriesOwnedByUsa();
    }

    public void setCountriesOwnedByUsa(String country) {
        countriesOwnedByUsa().add(country);
    }

    public List<String> getCountriesOwnedByBritain() {
        return countriesOwnedByBritain();
    }

    public List<String> getCountriesOwnedByFrance() {
        return countriesOwnedByFrance();
    }

    public List<String> getCountriesOwnedByGermany() {
        return countriesOwnedByGermany();
    }

    public List<String> getCountriesOwnedByRussia() {
        return countriesOwnedByRussia();
    }

    public List<String> getCountriesOwnedByJapan() {
        return countriesOwnedByJapan();
    }
}
