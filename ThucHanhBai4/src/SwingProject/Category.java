package SwingProject;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cateId;
	private String cateName;
	private ArrayList<Product> listPro = new ArrayList<Product>();

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public ArrayList<Product> getListPro() {
		return listPro;
	}

	public void setListPro(ArrayList<Product> listPro) {
		this.listPro = listPro;
	}

	public Category(String cateId, String cateName) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
	}

	public Category() {
		super();
	}

	public Product findProductById(String id) {
		for (Product p : listPro) {
			if (p.getProduct().equalsIgnoreCase(id)) {
				return p;
			}
		}
		return null;
	}

	public boolean addProduct(Product p) {
		Product pFind = findProductById(p.getProduct());
		if (pFind != null) {
			System.out.println("Dupicate productID!");
			return false;
		}
		listPro.add(p);
		return true;
	}

	public void setListPro1(ArrayList<Product> listPro) {
		this.listPro = listPro;
	}

	public ArrayList<Product> getListPro1() {
		return listPro;
	}

	public void removeProductById(String id) {
		Product pFind = findProductById(id);
		if (pFind != null) {
			listPro.remove(pFind);
		}
	}

	public void removeProductByIndex(String index) {
		listPro.remove(index);
	}

	public int numberOfProduct() {
		return listPro.size();
	}

	public String toString() {
		return this.cateName;
	}

}
