
package dto;

public class Category {
    private String catID;
    private String catName;

    public Category() {
    }

    public Category(String catID, String catName) {
        this.catID = catID;
        this.catName = catName;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Category{" + "catID=" + catID + ", catName=" + catName + '}';
    }  
}
