package statistics.matcher;
import statistics.Player;

public class HasFewerThan implements Matcher {
  private Not not;

  public HasFewerThan(int value, String category) {
      this.not = new Not(new HasAtLeast(value, category));
  }

  @Override
  public boolean matches(Player p) {
    return this.not.matches(p);
  }
  
  
}
