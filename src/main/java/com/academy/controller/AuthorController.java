package com.academy.controller;

import com.academy.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthorController {
  private final AuthorService authorService;

  @GetMapping(value = "/authors")
  public String getAuthors(Model model) {
    var authors = authorService.getAuthors();

    model.addAttribute("authors", authors);
    return "authors";
  }

  @GetMapping(value = "/author")
  public String getBook(@RequestParam() Integer id, Model model) {
    var author = authorService.getAuthor(id);

    model.addAttribute("author", author);
    return "authorDetails";
  }
}
