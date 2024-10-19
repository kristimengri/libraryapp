package com.kent.gmail.com.runtime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Lender extends Person {

  @OneToMany(targetEntity = LenderToBookInstance.class, mappedBy = "lender")
  @JsonIgnore
  private List<LenderToBookInstance> lenderLenderToBookInstances;

  private boolean blocked;

  /**
   * @return lenderLenderToBookInstances
   */
  @OneToMany(targetEntity = LenderToBookInstance.class, mappedBy = "lender")
  @JsonIgnore
  public List<LenderToBookInstance> getLenderLenderToBookInstances() {
    return this.lenderLenderToBookInstances;
  }

  /**
   * @param lenderLenderToBookInstances lenderLenderToBookInstances to set
   * @return Lender
   */
  public <T extends Lender> T setLenderLenderToBookInstances(
      List<LenderToBookInstance> lenderLenderToBookInstances) {
    this.lenderLenderToBookInstances = lenderLenderToBookInstances;
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
   * @return Lender
   */
  public <T extends Lender> T setBlocked(boolean blocked) {
    this.blocked = blocked;
    return (T) this;
  }
}
