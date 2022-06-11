import java.util.List;

public class Worldcup {
    private String year;
    private String host;
    private String confederation;
    private String date_from;
    private String date_to;

    public Worldcup(String csvLine) {
        String[] splits = csvLine.split(";");
        year = splits[0];
        host = splits[1];
        confederation = splits[2];
        date_from = splits[3];
        date_to = splits[4];
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConfederation() {
        return confederation;
    }

    public void setConfederation(String confederation) {
        this.confederation = confederation;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    @Override
    public String toString() {
        return "Worldcup{" +
                "year='" + year + '\'' +
                ", host='" + host + '\'' +
                ", confederation='" + confederation + '\'' +
                ", date_from='" + date_from + '\'' +
                ", date_to='" + date_to + '\'' +
                '}';
    }
}
