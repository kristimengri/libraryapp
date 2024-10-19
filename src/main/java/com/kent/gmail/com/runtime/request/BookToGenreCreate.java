package com.kent.gmail.com.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kent.gmail.com.runtime.model.Book;
import com.kent.gmail.com.runtime.model.Genre;
import com.kent.gmail.com.runtime.validation.Create;
import com.kent.gmail.com.runtime.validation.IdValid;
import com.kent.gmail.com.runtime.validation.Update;

/** Object Used to Create BookToGenre */
@IdValid.List({
  @IdValid(
      field = "genreId",
      fieldType = Genre.class,
      targetField = "genre",
      groups = {Create.class, Update.class}),
  @IdValid(
      field = "bookId",
      fieldType = Book.class,
      targetField = "book",
      groups = {Update.class, Create.class})
})
public class BookToGenreCreate extends BaseCreate {

  @JsonIgnore private Book book;

  private String bookId;

  @JsonIgnore private Genre genre;

  private String genreId;

  /**
   * @return book
   */
  @JsonIgnore
  public Book getBook() {
    return this.book;
  }

  /**
   * @param book book to set
   * @return BookToGenreCreate
   */
  public <T extends BookToGenreCreate> T setBook(Book book) {
    this.book = book;
    return (T) this;
  }

  /**
   * @return bookId
   */
  public String getBookId() {
    return this.bookId;
  }

  /**
   * @param bookId bookId to set
   * @return BookToGenreCreate
   */
  public <T extends BookToGenreCreate> T setBookId(String bookId) {
    this.bookId = bookId;
    return (T) this;
  }

  /**
   * @return genre
   */
  @JsonIgnore
  public Genre getGenre() {
    return this.genre;
  }

  /**
   * @param genre genre to set
   * @return BookToGenreCreate
   */
  public <T extends BookToGenreCreate> T setGenre(Genre genre) {
    this.genre = genre;
    return (T) this;
  }

  /**
   * @return genreId
   */
  public String getGenreId() {
    return this.genreId;
  }

  /**
   * @param genreId genreId to set
   * @return BookToGenreCreate
   */
  public <T extends BookToGenreCreate> T setGenreId(String genreId) {
    this.genreId = genreId;
    return (T) this;
  }
}
