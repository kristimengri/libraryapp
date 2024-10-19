package com.kent.gmail.com.runtime;

public class AuthorList {

  private String authorList;

  /**
   * @return authorList
   */
  public String getAuthorList() {
    return this.authorList;
  }

  /**
   * @param authorList authorList to set
   * @return AuthorList
   */
  public <T extends AuthorList> T setAuthorList(String authorList) {
    this.authorList = authorList;
    return (T) this;
  }
}
