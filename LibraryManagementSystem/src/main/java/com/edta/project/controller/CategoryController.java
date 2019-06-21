package com.edta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edta.project.model.Book;
import com.edta.project.service.Library;

@Controller
public class CategoryController {
	@Autowired
	Library li;
	@RequestMapping(value="/category.htm")
	public String Category(Model model){
		model.addAttribute("category", new com.edta.project.model.Category());
		return "category";
	}
	@RequestMapping(value="/create_category.htm",method=RequestMethod.POST)
	public String Data(Model model,@ModelAttribute(value="category")com.edta.project.model.Category category){
		li.saveCategory(category);
		model.addAttribute("categoryList", li.getCategory());
		return "redirect:/caategoryList.htm";
	}
	@RequestMapping(value="/categoryList.htm")
	public String bookList(Model model,@ModelAttribute(value="category") com.edta.project.model.Category category){
		model.addAttribute("categoryList", li.getCategory());
		return "categoryList";
	}
	@RequestMapping(value="/deleteCategory/{id}")
	public String deleteBook(Model model,@PathVariable(value="id")int id){
		li.deleteCategory(id);
		return "redirect:/categoryList.htm";
	}
	/*@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String updateCategory(Model model,@PathVariable(value="id")int id){
		return"updateCategoryPage";
	}
	@RequestMapping(value="updateCategory",method=RequestMethod.POST)
	public String updateCate(Model model,@PathVariable(value="cate")com.edta.project.model.Category category){
		return"redirect:/categoryList.htm";
	}*/
	@RequestMapping(value="/updateCategory/{id}")
	public String updateCategory(Model model,@PathVariable(value="id")int id){
		model.addAttribute("category",li.getCategoryById(id) );
		return "category";
	}
}