public class PhoneBookEntry {
    private int id;
    private String pn;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PhoneBookEntry(int id, String pn, String name, String description) {
        this.id = id;
        this.pn = pn;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return " \n TheBigPhoneBook " +
                "id:" + id +
                ", Phone number:'" + pn + '\'' +
                ", Name:'" + name + '\'' +
                ", Info:'" + description;
    }
}