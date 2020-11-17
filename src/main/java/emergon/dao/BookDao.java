package emergon.dao;

import emergon.entity.Book;
import java.io.Serializable;
import java.util.List;


public interface BookDao {
    
    List<Book> findAll();

    public Serializable create(Book book);

    public List<Book> findBooksBySearchValue(String searchValue);
}
