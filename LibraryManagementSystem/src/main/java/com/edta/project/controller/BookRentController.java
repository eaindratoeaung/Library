package com.edta.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edta.project.model.BookRentDTO;
import com.edta.project.service.Library;


@Controller
public class BookRentController {
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     dateFormat.setLenient(false);
     webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
     }
	@Autowired
	Library li;
	@RequestMapping(value="/bookrent.htm")
	public String BookRent(Model model){
		model.addAttribute("bookrent", new BookRentDTO());
		model.addAttribute("bookList",li.getBooks());
		model.addAttribute("studentList",li.getStudents());
		return "bookrent";
	}
	@RequestMapping(value="/bookrent_list.htm",method=RequestMethod.POST)
	public String submitData(Model model,@ModelAttribute(value="bookrent") BookRentDTO brd){
		com.edta.project.model.BookRent br=new com.edta.project.model.BookRent();
		if(brd.getId()!=0)
			br.setId(brd.getId());
		br.setQty(brd.getQty());
		br.setRentdate(brd.getRentdate());
		br.getBook().setId(brd.getBookId());
		br.getStu().setId(brd.getStudentId());
		li.saveBookRent(br);
		model.addAttribute("bookrentList", li.getBookRent());
		return "redirect:/bookrentList.htm";
	}
	/*public ResponseEntity getBookList(){
		return ResponseEntity<>
	}*/
	@RequestMapping(value="/bookrentList.htm")
	public String BookRentList(Model model){
		model.addAttribute("bookrentList",li.getBookRent());
		return "bookrentlist";
	}
	@RequestMapping(value="/deleteBookRent/{id}")
	public String deleteBook(Model model,@PathVariable(value="id")int id){
		li.deleteBookRent(id);
		return "redirect:/bookrentList.htm";
	}
	@RequestMapping(value="/updateBookRent/{id}")
	public String updateBook(Model model,@PathVariable(value="id")int id){
		model.addAttribute("studentList",li.getStudents());
		model.addAttribute("bookList",li.getBooks());
		model.addAttribute("bookrent", li.getBookRentById(id));
		return "bookrent";
	}	
}
