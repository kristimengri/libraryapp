package com.kent.gmail.com.runtime;

public class GenresRequest {

  private Integer currentPage;

  private String genres;

  private Integer pageSize;

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage currentPage to set
   * @return GenresRequest
   */
  public <T extends GenresRequest> T setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return (T) this;
  }

  /**
   * @return genres
   */
  public String getGenres() {
    return this.genres;
  }

  /**
   * @param genres genres to set
   * @return GenresRequest
   */
  public <T extends GenresRequest> T setGenres(String genres) {
    this.genres = genres;
    return (T) this;
  }

  /**
   * @return pageSize
   */
  public Integer getPageSize() {
    return this.pageSize;
  }

  /**
   * @param pageSize pageSize to set
   * @return GenresRequest
   */
  public <T extends GenresRequest> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }
}
