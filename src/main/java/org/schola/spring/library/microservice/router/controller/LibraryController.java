package org.schola.spring.library.microservice.router.controller;

import org.schola.spring.library.microservice.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private BookService service;

}