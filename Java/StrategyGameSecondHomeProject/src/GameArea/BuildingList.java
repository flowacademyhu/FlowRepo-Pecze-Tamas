package GameArea;

public class BuildingList {

    private String key;
    private int value;
    public BuildingList(String key, int value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public int getValue()
    {
        return value;
    }
}
