package bm.bookstore.controller;

import bm.bookstore.dto.BookDTO;
import bm.bookstore.entities.BookEntity;
import bm.bookstore.service.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class indexRouter {

    private final BookService bookService;

    public indexRouter(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allbooklist", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewBook(Model model) {
        BookEntity bookEntity = new BookEntity();
        model.addAttribute("book", bookEntity);
        return "newbook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute BookDTO book) {
        System.out.println(book);
        bookService.addOrUpdateBook(book);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        BookDTO book = bookService.getBookByID(id);
        model.addAttribute("book", book);
        return "update";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id) {
        bookService.removeBookByID(id);
        return "redirect:/";
    }
}
