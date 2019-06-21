package com.edta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edta.project.model.Book;
import com.edta.project.model.BookDTO;
import com.edta.project.model.Student;
import com.edta.project.service.Library;


@Controller
public class HomeController{
	@Autowired
	Library li;
	@RequestMapping(value="/index.htm")
	public String welcome(Model model){
		model.addAttribute("book", new BookDTO());
		model.addAttribute("categoryList", li.getCategory());
		return "bookForm";
	}
	@RequestMapping(value="/postInfo.htm",method=RequestMethod.POST)
	public String submitData(Model model,@ModelAttribute(value="book") BookDTO book){
		Book bo=new Book();
		if(book.getId()!=0)
			bo.setId(book.getId());
		bo.setName(book.getName());
		bo.setAuthor(book.getAuthor());
		bo.setIsbn(book.getIsbn());
		bo.getCategory().setId(book.getCategoryId());
		li.saveBook(bo);
	//	model.addAttribute("bookList",li.getBooks());
		return "redirect:/bookList.htm";
	}
	@RequestMapping(value="/bookList.htm")
	public String bookList(Model model){
		model.addAttribute("bookList", li.getBooks());
		return "bookList";
	}
	@RequestMapping(value="/deleteBook/{id}")
	public String deleteBook(Model model,@PathVariable(value="id")int id){
		li.deleteBook(id);
		return "redirect:/bookList.htm";
	}
	
/*@RequestMapping(value="/updatebook.htm",method=RequestMethod.POST ,params = { "update" })
public String UpdateBook(Model model,@ModelAttribute(value="book") Book book) {
	li.updateBook(book);
	 model.addAttribute("bookList",li.getBooks()); 
	  return "redirect:/bookList.htm";
}*/
	@RequestMapping(value="/updateBook/{id}")
	public String updateBook(Model model,@PathVariable(value="id")int id){
		//li.updateBook(id);
		model.addAttribute("categoryList", li.getCategory());
		model.addAttribute("book", li.getBookById(id));
		//return "redirect:/bookList.htm";
		return "bookForm";
	}
}