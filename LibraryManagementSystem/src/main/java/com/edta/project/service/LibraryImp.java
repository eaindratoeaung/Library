package com.edta.project.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edta.project.model.Book;
import com.edta.project.model.BookDTO;
import com.edta.project.model.BookRent;
import com.edta.project.model.BookRentDTO;
import com.edta.project.model.Category;
import com.edta.project.model.Student;

@Repository
@Transactional

public class LibraryImp implements Library{
	@Autowired
	private SessionFactory sessionFactory;

	public List<Book> getBooks() {
		// TODO Auto-generated method stub
	 return sessionFactory.getCurrentSession().createCriteria(Book.class).list();
	}
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}
	public void deleteBook(int id){
		org.hibernate.Session session=sessionFactory.getCurrentSession();
		Book book=(Book)((org.hibernate.Session) session).get(Book.class,id);
		((org.hibernate.Session) session).delete(book);
		((org.hibernate.Session) session).flush();
		
	}

	public List<Book> searchBook(int id) {
		// TODO Auto-generated method stub
		
		org.hibernate.Session session=sessionFactory.getCurrentSession();
		List<Book> book=new ArrayList<Book>();
		book.add((Book)session.get(Book.class,id));
		return book;
	}
	public void updateBook(int id) {
		// TODO Auto-generated method stub
		getCurrentSession().saveOrUpdate(id);
	}

	public BookDTO getBookById(int id) {
		// TODO Auto-generated method stub
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Book.class)
				.createAlias("category", "c",JoinType.LEFT_OUTER_JOIN);
		c.add(Restrictions.eq("id", id));
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				.add(Projections.property("author"),"author")
				.add(Projections.property("isbn"),"isbn")
				.add(Projections.property("c.id"),"categoryId")
				);
		c.setResultTransformer(Transformers.aliasToBean(BookDTO.class));
		return (BookDTO)c.uniqueResult();
	}
	
	
	

	public void saveStudent(Student stu) {
	// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(stu);
	}

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Student.class).list();
	}
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Session session=(Session) sessionFactory.getCurrentSession();
		Student student=(Student)((org.hibernate.Session) session).load(Student.class,id);
		((org.hibernate.Session) session).delete(student);
		((org.hibernate.Session) session).flush();
		
	}

	public Student searchStudent(int id) {
		Session session=(Session) sessionFactory.getCurrentSession();
		Student student=(Student)((org.hibernate.Session) session).load(Student.class,id);
		return student;
	}
	public void updateStudent(int id) {
		// TODO Auto-generated method stub
		getCurrentSession().saveOrUpdate(id);
		
	}
	public Student getStudentById(int id){
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Student.class);
		c.add(Restrictions.eq("id", id));
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				.add(Projections.property("rollNo"),"rollNo")
				.add(Projections.property("address"),"address")
				.add(Projections.property("grade"),"grade")
				
				
				);
		c.setResultTransformer(Transformers.aliasToBean(Student.class));
		return (Student)c.uniqueResult();
	}


	
	public void saveCategory(Category cate){
		sessionFactory.getCurrentSession().saveOrUpdate(cate);
	}
	public List<Category> getCategory(){
		return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		org.hibernate.Session session=sessionFactory.getCurrentSession();
		Category category=(Category)((org.hibernate.Session) session).get(Category.class,id);
		((org.hibernate.Session) session).delete(category);
		((org.hibernate.Session) session).flush();
	}

	public Category searchCategory(int id) {
		// TODO Auto-generated method stub
		Session sessioin=(Session)(sessionFactory).getCurrentSession();
		Category category=(Category)((org.hibernate.Session) sessioin).load(Category.class,id);
		return category;
	}
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(category);
		
	}
	public void updateCategory(int id){
		getCurrentSession().saveOrUpdate(id);
	}
	public Category getCategoryById(int id){
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Category.class);
		c.add(Restrictions.eq("id", id));
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				.add(Projections.property("description"),"description")
				
				);
		c.setResultTransformer(Transformers.aliasToBean(Category.class));
		return (Category)c.uniqueResult();
	}
	
	
	
	
	
	
	public void saveBookRent(BookRent br){
		sessionFactory.getCurrentSession().saveOrUpdate(br);
	}
	public List<BookRent> getBookRent(){
		return sessionFactory.getCurrentSession().createCriteria(BookRent.class).list();
	}
	public void deleteBookRent(int id) {
		// TODO Auto-generated method stub
		Session session=(Session) sessionFactory.getCurrentSession();
		
		BookRent bookrent=(BookRent)(session.get(BookRent.class,id));
		((org.hibernate.Session) session).delete(bookrent);
		((org.hibernate.Session) session).flush();
		}
	public void updateBookRent(int id) {
		// TODO Auto-generated method stub
		getCurrentSession().saveOrUpdate(id);
	}
	public BookRentDTO getBookRentById(int id) {
		// TODO Auto-generated method stub
		Criteria c=sessionFactory.getCurrentSession().createCriteria(BookRent.class)
				.createAlias("book", "b",JoinType.LEFT_OUTER_JOIN).createAlias("stu", "s",JoinType.LEFT_OUTER_JOIN);
		c.add(Restrictions.eq("id", id));
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("qty"), "qty")
				.add(Projections.property("rentdate"),"rentdate")
				.add(Projections.property("s.id"),"studentId")
				.add(Projections.property("b.id"),"bookId")
				);
		c.setResultTransformer(Transformers.aliasToBean(BookRentDTO.class));
		return (BookRentDTO)c.uniqueResult();
	}
	
	private org.hibernate.Session getCurrentSession() {
		// TODO Auto-generated method stub
		return null;
	}
}
	



	
