package com.elena.project.repository;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elena.project.model.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Resource
	private BookRepository bookRepository;


	@Override
	@Transactional
	public Book loadBookByName(String name) {
		return (Book) sessionFactory.getCurrentSession()
                .createCriteria(Book.class)
                .add(Restrictions.eq("name",name))
                .uniqueResult();
	}

	@Override
	@Transactional
	public Serializable post(Book book) {
		return  sessionFactory.getCurrentSession().save(book);
	}

	@Override
	@Transactional
	public Book get(int id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public List findAll() {
		return bookRepository.findAll();
	}

	@Override
	public List findBookByAuthor(String author) {
		return  (List) sessionFactory.getCurrentSession()
                .createCriteria(Book.class)
                .add(Restrictions.eq("author",author));
               
	}

	
	 }

	
	


