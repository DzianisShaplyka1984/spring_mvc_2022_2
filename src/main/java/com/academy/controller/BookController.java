package com.academy.controller;

import com.academy.config.ConfigProperties;
import com.academy.dto.CreateBookDto;
import com.academy.service.BookService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;
  private final ConfigProperties configProperties;

  @Value("${my.host}")
  private String myHost;

  @GetMapping(value = "/books")
  public String getBooks(Model model) {
    return books(model);
  }

  @GetMapping(value = "/book")
  public String getBook(@RequestParam() Integer id, Model model) {
    var book = bookService.getBook(id);

    model.addAttribute("book", book);
    return "bookDetails";
  }

  @GetMapping(value = "/showCreateBook")
  public String showCreateBook(Model model) {

    model.addAttribute("createBook", new CreateBookDto());
    return "createBook";
  }

  @GetMapping(value = "/createBook")
  public String createBook(@RequestParam String title, @RequestParam Integer year, @RequestParam Integer author, Model model) {
    var createBookDto = new CreateBookDto();
    createBookDto.setTitle(title);
    createBookDto.setYear(year);
    createBookDto.setAuthorId(author);

    bookService.save(createBookDto);

    return books(model);
  }

  @PostMapping(value = "/createBook")
  public String createBook(@ModelAttribute(value = "createBook") CreateBookDto createBookDto, Model model) {
    bookService.save(createBookDto);

    return books(model);
  }

  private String books(Model model) {
    var books = bookService.getBooks();
    model.addAttribute("books", books);

    return "books";
  }
}
