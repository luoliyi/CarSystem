package carentity;

public class Car {
    private int cid;
    private String cname;
    private String ccolor;
    private int cspeed;
    private String ccard;
    private String cdesc;

    public Car(){}

    public Car( String cname, String ccolor, int cspeed, String ccard, String cdesc) {
        this.cname = cname;
        this.ccolor = ccolor;
        this.cspeed = cspeed;
        this.ccard = ccard;
        this.cdesc = cdesc;
    }
    public Car(int cid, String cname, String ccolor, int cspeed, String ccard, String cdesc) {
        this.cid = cid;
        this.cname = cname;
        this.ccolor = ccolor;
        this.cspeed = cspeed;
        this.ccard = ccard;
        this.cdesc = cdesc;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcolor() {
        return ccolor;
    }

    public void setCcolor(String ccolor) {
        this.ccolor = ccolor;
    }

    public int getCspeed() {
        return cspeed;
    }

    public void setCspeed(int cspeed) {
        this.cspeed = cspeed;
    }

    public String getCcard() {
        return ccard;
    }

    public void setCcard(String ccard) {
        this.ccard = ccard;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", ccolor='" + ccolor + '\'' +
                ", cspeed=" + cspeed +
                ", ccard='" + ccard + '\'' +
                ", cdesc='" + cdesc + '\'' +
                '}';
    }
}
