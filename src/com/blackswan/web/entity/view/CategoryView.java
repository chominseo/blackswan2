package com.blackswan.web.entity.view;

import com.blackswan.web.entity.Category;

public class CategoryView extends Category{
	private int count;

	public CategoryView(int count ,String id,String name) {
		super(id, name);
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	
	
	
	
}
