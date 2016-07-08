/*
	Template method pattern: compile-time algorithm selection by subclassing
    Strategy pattern: run-time algorithm selection by containment
*/
public class TemplateMethodPattern {
	public abstract class SpaceShip {
		public String GetShipType() {
			return "SpaceShip";
		}
		public void hit()
		{
			System.out.println("hit");
			collideWith();
			System.out.println("over hit");
		}
		public abstract void collideWith();
	}
	
	public class SpaceShipThatHitsNormalAsteroid extends SpaceShip{
		
		public void collideWith() {
			System.out.println("Asteroid hit a SpaceShip");
		}
	};
	public class SpaceShipThatHitsExplodingAsteroid extends SpaceShip {
		public void collideWith() {
			System.out.println("ExplodingAsteroid hit a SpaceShip");
		}
	};
	
	public TemplateMethodPattern(){
		SpaceShipThatHitsExplodingAsteroid spaceShipEA = new SpaceShipThatHitsExplodingAsteroid();

		spaceShipEA.hit();
	}
	
	public static void main(String[] args)
	{
		new VisitorPattern();
	}
}
