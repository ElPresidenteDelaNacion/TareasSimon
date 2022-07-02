package com.anahuac.calidad.tareaUnitTest;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import java.io.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.anahuac.calidad.tareaUnitTest.entities.Book;
import com.anahuac.calidad.tareaUnitTest.entities.BookShelf;
import com.anahuac.calidad.tareaUnitTest.entities.BookShelfCapacityReached;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestBookShelf {
	public BookShelf bookShelfExc;
	public BookShelf bookShelfAdd;
	public void setUp() throws Exception {
		bookShelfAdd = new BookShelf();
		bookShelfExc = new BookShelf(3);
	}
	@Test
	public void testAdd() {
		
		LocalDate fechaPublicacion = LocalDate.of(2020, Month.DECEMBER, 18);
		Book newBook1 = new Book("Don Quijote","Miguel de Cervantes",fechaPublicacion);
		Book newBook2 = new Book("Don ","Miguel",fechaPublicacion);
		bookShelfAdd.add(newBook1);
		bookShelfAdd.add(newBook2);
		//System.out.println(newBook1);
		int nLibro = bookShelfAdd.books().size();
		//System.out.println(newBook2);
		 
		assertThat(nLibro, is(2));
	}

}
