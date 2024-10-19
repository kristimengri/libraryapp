package com.kent.gmail.com.runtime.controller;

import com.kent.gmail.com.runtime.GenresRequest;
import com.kent.gmail.com.runtime.authorsByGenresRepository;
import com.kent.gmail.com.runtime.security.UserSecurityContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("findAuthorsByGenres")
@Tag(name = "findAuthorsByGenres")
public class findAuthorsByGenres {

  @Autowired private authorsByGenresRepository authorsByGenresRepository;

  @PostMapping("findAuthorsByGenres")
  @Operation(summary = "findAuthorsByGenres", description = "")
  public List findAuthorsByGenres(
      @RequestBody GenresRequest genresRequest, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return authorsByGenresRepository.authorsByGenres(genresRequest, securityContext);
  }
}
