/*
 * The strategy pattern is like a 1:many relationship.
 * The visitor pattern is a many:many relationship.
 */
public class StrategyPattern {
	
	public class SpaceShip {
		public String GetShipType() {
			return "SpaceShip";
		}
		public void hit(Asteroid a)
		{
			a.collideWith(this);
		}
	}
	
	public interface Asteroid {
		public void collideWith(SpaceShip s);
	}
	
	public class NormalAsteroid implements Asteroid {
		
		public void collideWith(SpaceShip ship) {
			System.out.println("Asteroid hit a SpaceShip");
		}
	};
	public class ExplodingAsteroid implements Asteroid {
		public void collideWith(SpaceShip ship) {
			System.out.println("ExplodingAsteroid hit a SpaceShip");
		}
	};
	
	public StrategyPattern(){
		Asteroid someAsteroid = new ExplodingAsteroid();
		SpaceShip spaceShip = new SpaceShip();

		spaceShip.hit(someAsteroid);
	}
	
	public static void main(String[] args)
	{
		new VisitorPattern();
	}
}
