package emergon.dao;

import emergon.entity.Book;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Book> findAll() {
        Query q = getSession().createNamedQuery("Book.findAll");
        return q.getResultList();
    }

    @Override
    public Serializable create(Book book) {
        return getSession().save(book);
    }

    @Override
    public List<Book> findBooksBySearchValue(String searchValue) {
        //The following query will not work if author or category are null.
        Query q = getSession().createNamedQuery("Book.findBySearchValue");
        q.setParameter("searchValue", "%" + searchValue + "%");
        return q.getResultList();
    }

}
