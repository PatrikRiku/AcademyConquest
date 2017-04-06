package hello;

public class RegionInfo {

    private String content;
    private String namesOfAttackRegions;
    private String idsForAdjacentRegions;

    public RegionInfo() {
    }

    public RegionInfo(String content) {
        this.content = content;
    }

    public RegionInfo(String content, String namesOfAttackRegions, String idsForAdjacentRegions) {
        this.content = content;
        this.namesOfAttackRegions = namesOfAttackRegions;
        this.idsForAdjacentRegions = idsForAdjacentRegions;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setNamesOfAttackRegions(String namesOfAttackRegions) {
        this.namesOfAttackRegions = namesOfAttackRegions;
    }

    public String getNamesOfAttackRegions() {
        return namesOfAttackRegions;
    }

    public String getIdsForAdjacentRegions() {
        return idsForAdjacentRegions;
    }

    public void setIdsForAdjacentRegions(String idsForAdjacentRegions) {
        this.idsForAdjacentRegions = idsForAdjacentRegions;
    }
}
