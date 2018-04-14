package net.vksagar.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.vksagar.shoppingbackend.dao.CategoryDAO;
import net.vksagar.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categoryList = new ArrayList<>();

	static {
		//1
		Category category = new Category();
		category.setId(1);
		category.setName("TV");
		category.setDescription("This description for TV");
		category.setImageUrl("CAT_1.png");
		categoryList.add(category);
		
		//2
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This description for Mobile");
		category.setImageUrl("CAT_2.png");
		categoryList.add(category);
		
		//3
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This description for Laptop");
		category.setImageUrl("CAT_3.png");
		categoryList.add(category);
		
		//4
		category = new Category();
		category.setId(4);
		category.setName("Refrigerator");
		category.setDescription("This description for Refrigerator");
		category.setImageUrl("CAT_4.png");
		categoryList.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryList;
	}

	@Override
	public Category get(int id) {
		for(Category category : categoryList) {
			if(category.getId() == id) return category;
		}
		return null;
	}

}
