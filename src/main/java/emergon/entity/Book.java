package emergon.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "book")
@NamedQueries(value = {
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findBySearchValue", 
            query = "SELECT b FROM Book b WHERE LOWER(b.title) LIKE :searchValue OR LOWER(b.author.lname) LIKE :searchValue OR LOWER(b.category.name) LIKE :searchValue"
    )

})
public class Book implements Serializable{
    
    @Id
    private String isbn;
    private String title;
    private double price;
    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Author author;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Category category;
    
    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.isbn);
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", price=" + price + '}';
    }
    
    
}
