package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Category;
import com.Interface.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	public List<Category> getCategorys(){
		return repo.findAll();
	}
	public Category getCategoryById(int cid) {
		try {
			return repo.findById(cid).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
