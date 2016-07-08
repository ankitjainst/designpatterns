import java.util.Hashtable;

public class PrototypePattern {

//Prototype
public abstract class Item {
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private String title;
	private double price;
	public Item clone() {
		Item clonedItem = null;
		try {
			//use default object clone.            
			clonedItem = (Item) super.clone();
			//specialised clone            
			clonedItem.setPrice(price);
			clonedItem.setTitle(title);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} // catch     
		return clonedItem;
	}
	public String getTitle() {
		return title;
	}
	public double getPrice() {
		return price;
	}
}

//Concrete Prototypes
public class Book extends Item {
//extra book stuff 
}
public class CD extends Item {
//extra cd stuff
}

public class ItemRegistry {
	 private Hashtable<String,Item> map = new Hashtable();
	 public ItemRegistry() {
	  loadCache();
	 }
	 public Item createBasicItem(String type) {
	  return (Item) map.get(type).clone();
	 }
	 private void loadCache() {
	  Book book = new Book();
	  book.setTitle("Design Patterns");
	  book.setPrice(20.00);
	  map.put("Book", book);
	  CD cd = new CD();
	  cd.setTitle("Various");
	  cd.setPrice(10.00);
	  map.put("CD", cd);
	 }
	}
}