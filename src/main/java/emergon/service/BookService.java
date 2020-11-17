package emergon.service;

import emergon.entity.Book;
import java.util.List;


public interface BookService {
    
    List<Book> findAll();

    public String create(Book book);

    public List<Book> findBySearchValue(String searchValue);
    
}
