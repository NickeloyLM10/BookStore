package com.bookStore.online.mapper;

import com.bookStore.online.Entity.Book;
import com.bookStore.online.dto.BookDto;

public class BookMapper {

    public static BookDto toDto(Book book){
        BookDto bookDto = new BookDto(book.bookId(), book.name(), book.price(), book.author(), book.Description());
        return bookDto;
    }

    public static Book toEntity(BookDto bookDto){
        Book book = new Book(bookDto.bookId(), bookDto.name(), bookDto.price(), bookDto.author(), bookDto.Description());
        return book;
    }
}
