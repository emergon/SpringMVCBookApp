/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.dao.BookDao;
import emergon.entity.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bdao;
    
    @Override
    public List<Book> findAll() {
        return bdao.findAll();
    }

    @Override
    public String create(Book book) {
        String id = (String)bdao.create(book);
        return id;
    }

    @Override
    public List<Book> findBySearchValue(String searchValue) {
        if(searchValue.trim().isEmpty()){
            return findAll();
        }
        searchValue = searchValue.toLowerCase();
        List<Book> list = bdao.findBooksBySearchValue(searchValue);
        return list;
    }
    
}
