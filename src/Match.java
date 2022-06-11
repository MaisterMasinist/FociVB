public class Match {
    private String year;
    private String stage;
    private String date;
    private String team_a, team_b;
    private int goals_a, goals_b;
    private Integer penalties_a, penalties_b;
    private Worldcup worldcup;

    public Match(String csvLine) {
        String[] splits = csvLine.split(";");
        year = splits[0];
        stage = splits[1];
        date = splits[2];
        team_a = splits[3];
        team_b = splits[4];
        goals_a = Integer.parseInt(splits[5]);
        goals_b = Integer.parseInt(splits[6]);
        if(splits.length >= 8) {
            penalties_a = Integer.parseInt(splits[7]);
            penalties_b = Integer.parseInt(splits[8]);
        }
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeam_a() {
        return team_a;
    }

    public void setTeam_a(String team_a) {
        this.team_a = team_a;
    }

    public String getTeam_b() {
        return team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public int getGoals_a() {
        return goals_a;
    }

    public void setGoals_a(int goals_a) {
        this.goals_a = goals_a;
    }

    public int getGoals_b() {
        return goals_b;
    }

    public void setGoals_b(int goals_b) {
        this.goals_b = goals_b;
    }

    public Integer getPenalties_a() {
        return penalties_a;
    }

    public void setPenalties_a(Integer penalties_a) {
        this.penalties_a = penalties_a;
    }

    public Integer getPenalties_b() {
        return penalties_b;
    }

    public void setPenalties_b(Integer penalties_b) {
        this.penalties_b = penalties_b;
    }

    public Worldcup getWorldcup() {
        return worldcup;
    }

    public void setWorldcup(Worldcup worldcup) {
        this.worldcup = worldcup;
    }

    public boolean getWinnerA() {
        return goals_a > goals_b;
    }

    public boolean getWinnerB() {
        return goals_a < goals_b;
    }

    public Integer getTotalGoals() {
        return goals_a + goals_b;
    }

    @Override
    public String toString() {
        return "Match{" +
                "year='" + year + '\'' +
                ", stage='" + stage + '\'' +
                ", date='" + date + '\'' +
                ", team_a='" + team_a + '\'' +
                ", team_b='" + team_b + '\'' +
                ", goals_a=" + goals_a +
                ", goals_b=" + goals_b +
                ", penalties_a=" + penalties_a +
                ", penalties_b=" + penalties_b +
                '}';
    }
}
