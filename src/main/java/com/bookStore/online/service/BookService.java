package com.bookStore.online.service;

import com.bookStore.online.dto.BookDto;

import java.util.List;

public interface BookService {

    public BookDto getBook(String bookId);

    public List<BookDto> getAllBooks();

    public BookDto createBook(BookDto bookDto);

    public BookDto updateBookByName(BookDto bookDto);

    public void deleteBook(String bookId);


}
