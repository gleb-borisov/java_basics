public class Domain {
    private String tld;
    private String sld;
    private String name;

    public Domain (String name, String sld, String tld) {
        this.tld = tld;
        this.sld = sld;
        this.name = name;
    }

    public String getTld() {
        return tld;
    }

    public String getSld() {
        return sld;
    }

    public String getName() {
        return name;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public void setSld(String sld) {
        this.sld = sld;
    }

    public void setName(String name) {
        this.name = name;
    }
}
