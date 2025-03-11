package com.bookStore.online.service;

import com.bookStore.online.Entity.Book;
import com.bookStore.online.dto.BookDto;
import com.bookStore.online.mapper.BookMapper;
import com.bookStore.online.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto getBook(String bookId) {
        Book book = bookRepository.findBookByBookId(bookId);
        return BookMapper.toDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        for(Book book:books){
            bookDtoList.add(BookMapper.toDto(book));
        }
        return bookDtoList;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookRepository.insert(BookMapper.toEntity(bookDto));
        return BookMapper.toDto(book);
    }

    @Override
    public BookDto updateBookByName(BookDto bookDto) {
//        Book book = BookMapper.toEntity(bookDto);
        bookRepository.updateBookNameByBookId(bookDto.bookId(), bookDto.name());
        return bookDto;
    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.deleteBookByBookId(bookId);
    }
}
