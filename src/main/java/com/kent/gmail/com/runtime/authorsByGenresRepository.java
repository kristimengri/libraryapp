package com.kent.gmail.com.runtime;

import com.kent.gmail.com.runtime.model.Author;
import com.kent.gmail.com.runtime.model.AuthorToBook;
import com.kent.gmail.com.runtime.model.Book;
import com.kent.gmail.com.runtime.model.BookToGenre;
import com.kent.gmail.com.runtime.model.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class authorsByGenresRepository {
  @PersistenceContext private EntityManager em;

  public java.util.List<com.kent.gmail.com.runtime.AuthorList> authorsByGenres(
      GenresRequest filtering,
      com.kent.gmail.com.runtime.security.UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Tuple> q = cb.createQuery(Tuple.class);
    Root<Author> authorRoot = q.from(Author.class);
    Join<Author, AuthorToBook> authorAuthorToBooksJoin = authorRoot.join("authorAuthorToBooks");
    Join<AuthorToBook, Book> bookJoin = authorAuthorToBooksJoin.join("book");
    Join<Book, BookToGenre> bookBookToGenresJoin = bookJoin.join("bookBookToGenres");
    Join<BookToGenre, Genre> genreJoin = bookBookToGenresJoin.join("genre");

    Path<String> authornamePath = authorRoot.get("name");
    Path<String> genreNamePath = genreJoin.get("name");

    String genres = filtering.getGenres();

    List<Predicate> preds = new ArrayList<>();

    Predicate customPred = cb.and(cb.like(genreNamePath, genres));
    preds.add(customPred);
    q.select(cb.tuple(authornamePath)).where(preds.toArray(new Predicate[0])).orderBy().groupBy();
    TypedQuery<Tuple> query = em.createQuery(q);
    if (filtering.getPageSize() != null
        && filtering.getCurrentPage() != null
        && filtering.getCurrentPage() >= 0
        && filtering.getPageSize() > 0) {
      query.setFirstResult(filtering.getCurrentPage() * filtering.getPageSize());
      query.setMaxResults(filtering.getPageSize());
    }
    return query.getResultList().stream().map(f -> mapToAuthorList(f)).collect(Collectors.toList());
  }

  private AuthorList mapToAuthorList(Tuple t) {
    AuthorList authorList = new AuthorList();

    authorList.setAuthorList(t.get(0, String.class));

    return authorList;
  }

  public Long authorsByGenresCount(
      GenresRequest filtering,
      com.kent.gmail.com.runtime.security.UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<Author> authorRoot = q.from(Author.class);
    Join<Author, AuthorToBook> authorAuthorToBooksJoin = authorRoot.join("authorAuthorToBooks");
    Join<AuthorToBook, Book> bookJoin = authorAuthorToBooksJoin.join("book");
    Join<Book, BookToGenre> bookBookToGenresJoin = bookJoin.join("bookBookToGenres");
    Join<BookToGenre, Genre> genreJoin = bookBookToGenresJoin.join("genre");

    Path<String> authornamePath = authorRoot.get("name");
    Path<String> genreNamePath = genreJoin.get("name");

    String genres = filtering.getGenres();

    List<Predicate> preds = new ArrayList<>();

    Predicate customPred = cb.and(cb.like(genreNamePath, genres));
    preds.add(customPred);
    q.select(cb.count(authorRoot)).where(preds.toArray(new Predicate[0])).groupBy();
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }
}
