package com.kent.gmail.com.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kent.gmail.com.runtime.model.AuthorToBook;
import com.kent.gmail.com.runtime.model.Book;
import com.kent.gmail.com.runtime.validation.IdValid;
import java.util.List;
import java.util.Set;

/** Object Used to List Author */
@IdValid.List({
  @IdValid(field = "authorBooksIds", fieldType = Book.class, targetField = "authorBookses"),
  @IdValid(
      field = "authorAuthorToBooksIds",
      fieldType = AuthorToBook.class,
      targetField = "authorAuthorToBookses")
})
public class AuthorFilter extends BaseFilter {

  private Set<String> authorAuthorToBooksIds;

  @JsonIgnore private List<AuthorToBook> authorAuthorToBookses;

  private Set<String> authorBooksIds;

  @JsonIgnore private List<Book> authorBookses;

  /**
   * @return authorAuthorToBooksIds
   */
  public Set<String> getAuthorAuthorToBooksIds() {
    return this.authorAuthorToBooksIds;
  }

  /**
   * @param authorAuthorToBooksIds authorAuthorToBooksIds to set
   * @return AuthorFilter
   */
  public <T extends AuthorFilter> T setAuthorAuthorToBooksIds(Set<String> authorAuthorToBooksIds) {
    this.authorAuthorToBooksIds = authorAuthorToBooksIds;
    return (T) this;
  }

  /**
   * @return authorAuthorToBookses
   */
  @JsonIgnore
  public List<AuthorToBook> getAuthorAuthorToBookses() {
    return this.authorAuthorToBookses;
  }

  /**
   * @param authorAuthorToBookses authorAuthorToBookses to set
   * @return AuthorFilter
   */
  public <T extends AuthorFilter> T setAuthorAuthorToBookses(
      List<AuthorToBook> authorAuthorToBookses) {
    this.authorAuthorToBookses = authorAuthorToBookses;
    return (T) this;
  }

  /**
   * @return authorBooksIds
   */
  public Set<String> getAuthorBooksIds() {
    return this.authorBooksIds;
  }

  /**
   * @param authorBooksIds authorBooksIds to set
   * @return AuthorFilter
   */
  public <T extends AuthorFilter> T setAuthorBooksIds(Set<String> authorBooksIds) {
    this.authorBooksIds = authorBooksIds;
    return (T) this;
  }

  /**
   * @return authorBookses
   */
  @JsonIgnore
  public List<Book> getAuthorBookses() {
    return this.authorBookses;
  }

  /**
   * @param authorBookses authorBookses to set
   * @return AuthorFilter
   */
  public <T extends AuthorFilter> T setAuthorBookses(List<Book> authorBookses) {
    this.authorBookses = authorBookses;
    return (T) this;
  }
}
