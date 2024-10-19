package com.kent.gmail.com.runtime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class BookInstance extends Base {

  @OneToMany(targetEntity = LenderToBookInstance.class, mappedBy = "bookInstance")
  @JsonIgnore
  private List<LenderToBookInstance> bookInstanceLenderToBookInstances;

  private String serialNumber;

  private boolean blocked;

  /**
   * @return bookInstanceLenderToBookInstances
   */
  @OneToMany(targetEntity = LenderToBookInstance.class, mappedBy = "bookInstance")
  @JsonIgnore
  public List<LenderToBookInstance> getBookInstanceLenderToBookInstances() {
    return this.bookInstanceLenderToBookInstances;
  }

  /**
   * @param bookInstanceLenderToBookInstances bookInstanceLenderToBookInstances to set
   * @return BookInstance
   */
  public <T extends BookInstance> T setBookInstanceLenderToBookInstances(
      List<LenderToBookInstance> bookInstanceLenderToBookInstances) {
    this.bookInstanceLenderToBookInstances = bookInstanceLenderToBookInstances;
    return (T) this;
  }

  /**
   * @return serialNumber
   */
  public String getSerialNumber() {
    return this.serialNumber;
  }

  /**
   * @param serialNumber serialNumber to set
   * @return BookInstance
   */
  public <T extends BookInstance> T setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return (T) this;
  }

  /**
   * @return blocked
   */
  public boolean isBlocked() {
    return this.blocked;
  }

  /**
   * @param blocked blocked to set
   * @return BookInstance
   */
  public <T extends BookInstance> T setBlocked(boolean blocked) {
    this.blocked = blocked;
    return (T) this;
  }
}
