package com.edta.project.service;

import java.io.Serializable;
import java.util.List;

import com.edta.project.model.Book;
import com.edta.project.model.BookDTO;
import com.edta.project.model.BookRent;
import com.edta.project.model.BookRentDTO;
import com.edta.project.model.Category;
import com.edta.project.model.Student;


public interface Library {
	public List<Book> getBooks();
	public void saveBook(Book book);
	public void deleteBook(int id);
	public List<Book> searchBook(int id);
	public void updateBook(int id);
	public BookDTO getBookById(int id);
	
	
	public void saveStudent(Student stu);
	public List<Student> getStudents();
	public Student searchStudent(int id);
	public void deleteStudent(int id);
	public void updateStudent(int id);
	public Student getStudentById(int id);
	
	
	public void saveCategory(Category cate);
	public List<Category> getCategory();
	public Category searchCategory(int id);
	public void deleteCategory(int id);
	public void updateCategory(int id);
	public Category getCategoryById(int id);
	
	
	public void saveBookRent(BookRent br);
	public List<BookRent> getBookRent();
	public void deleteBookRent(int id);
	public void updateBookRent(int id);
	public BookRentDTO getBookRentById(int id);
	
}
