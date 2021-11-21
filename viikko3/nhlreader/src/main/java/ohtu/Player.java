
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private Integer goals;
    private Integer assists;
    private String team;
    private String nationality;
    
    public Integer getTotal() {
        return this.goals + this.assists;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    @Override
    public int compareTo(Player otherPlayer) {
        return Integer.compare(getGoals() + getAssists(), otherPlayer.getGoals() + otherPlayer.getAssists());
    }
    

    @Override
    public String toString() {
        return this.name + " " + this.getTeam() + " " + this.goals.toString() + " + " +this.assists.toString() + " = " + this.getTotal().toString();
    }
      
}
