
public class DoubleDispatch {

	public class SpaceShip {
		public String GetShipType() {
			return "SpaceShip";
		}
	}
	public class ApolloSpacecraft extends SpaceShip {
		public String GetShipType() {
			return "ApolloSpacecraft";
		}
	}

	public class Asteroid {
		public void CollideWith(SpaceShip ship) {
			System.out.println("Asteroid hit a SpaceShip");
		}
		public void CollideWith(ApolloSpacecraft ship) {
			System.out.println("Asteroid hit an ApolloSpacecraft");
		}
	};
	public class ExplodingAsteroid extends Asteroid {
		public void CollideWith(SpaceShip ship) {
			System.out.println("ExplodingAsteroid hit a SpaceShip");
		}
		public void CollideWith(ApolloSpacecraft ship) {
			System.out.println("ExplodingAsteroid hit an ApolloSpacecraft");
		}
	};
	
	public DoubleDispatch(){
		Asteroid theExplodingAsteroidRef = new ExplodingAsteroid();
		SpaceShip theApolloSpacecraftRef = new ApolloSpacecraft();
		theExplodingAsteroidRef.CollideWith(theApolloSpacecraftRef);
		System.out.println(theApolloSpacecraftRef.GetShipType());
	}
	
	public static void main(String[] args)
	{
		new DoubleDispatch();
	}
	
}
