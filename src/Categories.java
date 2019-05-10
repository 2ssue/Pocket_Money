import java.util.Iterator;
import java.util.List;

public class Categories {
	private List<String> categories;
	
	public void addCategory(String sCategoryName) {
		categories.add(sCategoryName);
	}
	public void deleteCategory(String sCategoryNumber) {
		categories.remove(Integer.parseInt(sCategoryNumber));
	}
	public Iterator<String> iteratorCategories(){
		return categories.iterator();
	}
	public String getCategory(int nCategoryNumber) {
		return categories.get(nCategoryNumber);
	}
}