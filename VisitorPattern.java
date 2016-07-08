public class VisitorPattern {

	public interface Ship {
		public void accept(Visitor v);
	}
	
	public class SpaceShip implements Ship {
		public String GetShipType() {
			return "SpaceShip";
		}
		public void accept(Visitor v)
		{
			v.collideWith(this);
		}
	}
	public class ApolloSpacecraft implements Ship {
		public String GetShipType() {
			return "ApolloSpacecraft";
		}
		public void accept(Visitor v)
		{
			v.collideWith(this);
		}
	}

	public interface Visitor{
		public void collideWith(SpaceShip s);
		public void collideWith(ApolloSpacecraft s);
	}

	public class Asteroid implements Visitor{
		
		public void collideWith(SpaceShip ship) {
			System.out.println("Asteroid hit a SpaceShip");
		}
		public void collideWith(ApolloSpacecraft ship) {
			System.out.println("Asteroid hit an ApolloSpacecraft");
		}
	};
	public class ExplodingAsteroid implements Visitor {
		public void collideWith(SpaceShip ship) {
			System.out.println("ExplodingAsteroid hit a SpaceShip");
		}
		public void collideWith(ApolloSpacecraft ship) {
			System.out.println("ExplodingAsteroid hit an ApolloSpacecraft");
		}
	};
	
	public VisitorPattern(){
		Visitor someAsteroid = new ExplodingAsteroid();
		Ship someShip = new ApolloSpacecraft();
		//theExplodingAsteroidRef.collideWith(theApolloSpacecraftRef);
		someShip.accept(someAsteroid);
	}
	
	public static void main(String[] args)
	{
		new VisitorPattern();
	}

}