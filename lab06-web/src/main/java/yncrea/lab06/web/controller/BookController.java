package yncrea.lab06.web.controller;

import yncrea.lab06.core.entity.Book;
import yncrea.lab06.core.entity.Tag;
import yncrea.lab06.core.service.BookService;
import yncrea.lab06.web.dto.BookDTO;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController implements RestController {

    @Inject
    private BookService bookService;

    @GET
    @Path("")
    public Map<Long,String> getBooks(){
        List<Book> books = bookService.findAll();
        Map<Long,String> returnedMap = new HashMap<>();
        for(Book book:books){
            returnedMap.put(book.getId(),book.getTitle());
        }
        return returnedMap;
    }

    @GET
    @Path("/{bookId}")
    public BookDTO getBookDetails(@PathParam("bookId") long bookId){
        Book book = bookService.getById(bookId);
        BookDTO dto = new BookDTO();
        dto.setAuthors(book.getAuthors().stream().map(a->a.toString()).collect(Collectors.toList()));
        dto.setId(book.getId());
        dto.setImage(book.getImage());
        dto.setLanguage(book.getLanguage().toString());
        dto.setTitle(book.getTitle());
        dto.setTags(book.getTags().stream().map(Tag::getName).collect(Collectors.toList()));
        dto.setReviews(book.getReviews());


        return dto;
    }



}
