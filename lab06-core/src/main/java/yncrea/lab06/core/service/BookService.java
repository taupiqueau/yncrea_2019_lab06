package yncrea.lab06.core.service;

import org.springframework.stereotype.Service;
import yncrea.lab06.core.dao.BookDAO;
import yncrea.lab06.core.entity.Book;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    private BookDAO bookDAO;


    public BookService(final BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> findAll(){
        return bookDAO.findAll();
    }


    public Book getById(final long bookId) {
        return bookDAO.getOneWithAuthorsAndTagsAndReviews(bookId);
    }
}
