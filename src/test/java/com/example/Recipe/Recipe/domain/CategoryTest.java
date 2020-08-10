package com.example.Recipe.Recipe.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {
	Category category;
	
	@BeforeEach
	public void Setup() {
		category = new Category();
	}
	@Test
	public void getId() throws Exception {
		long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}
	
	@Test
	public void getDescription() throws Exception {
		
	}

}
