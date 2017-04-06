package hello;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-04-03.
 */
public class MajorNation {

    private List<String> regionsOwned = new ArrayList<>();
    private String nationName;

    public MajorNation(String nationName) {
        this.nationName = nationName;
        setRegions(nationName);
    }


    public List<String> getRegionsOwned() {
        return regionsOwned;
    }

    public void setRegions(String nationName) {
        if(nationName.equalsIgnoreCase("usa")){
            this.addToRegionsOwned("g8");
            this.addToRegionsOwned("g9");
            this.addToRegionsOwned("g10");
            this.addToRegionsOwned("g11");
        }
        else if (nationName.equalsIgnoreCase("russia")){
            this.addToRegionsOwned("g43");
            this.addToRegionsOwned("g44");
            this.addToRegionsOwned("g99");
            this.addToRegionsOwned("g100");
            this.addToRegionsOwned("g101");
            this.addToRegionsOwned("g112");
        }
        else if (nationName.equalsIgnoreCase("britain")){
            this.addToRegionsOwned("g38");
            this.addToRegionsOwned("g39");
            this.addToRegionsOwned("g40");
        }
        else if (nationName.equalsIgnoreCase("japan")){
            this.addToRegionsOwned("g103");
            this.addToRegionsOwned("g104");
            this.addToRegionsOwned("g105");
            this.addToRegionsOwned("g106");
        }
        else if (nationName.equalsIgnoreCase("france")){
            this.addToRegionsOwned("g50");
            this.addToRegionsOwned("g51");
            this.addToRegionsOwned("g54");
        }
        else if (nationName.equalsIgnoreCase("germany")){
            this.addToRegionsOwned("g45");
            this.addToRegionsOwned("g46");
            this.addToRegionsOwned("g60");
        }
        else {
            System.out.println("NU ÄR DET FEEEEEEEL!");
        }
    }

    public void addToRegionsOwned(String regionId) {
        this.regionsOwned.add(regionId);
    }

    public String getNationName() {
        return nationName;
    }
}
