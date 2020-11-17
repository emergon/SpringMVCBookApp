package emergon.controller;

import emergon.entity.Book;
import emergon.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BookService service;
    
    
    @RequestMapping("/list")
    public String showBooksPage(Model model){
        List<Book> biblia = service.findAll();
        model.addAttribute("books", biblia);
        return "biblia/list";
    }
    
    @GetMapping("/create")
    public String showCreateBookPage(Model model){
        model.addAttribute("biblio", new Book());
        return "biblia/create";
    }
    
    @PostMapping("/add")
    public String addBook(@ModelAttribute("biblio") Book book){
        service.create(book);
        return "redirect:/book/list";
    }
    
    @PostMapping("/search")
    public String searchBook(Model model, String searchValue){
        List<Book> biblia = service.findBySearchValue(searchValue);
        model.addAttribute("books", biblia);
        return "biblia/list";
    } 
}
