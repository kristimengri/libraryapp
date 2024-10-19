package com.kent.gmail.com.runtime.request;

import java.time.OffsetDateTime;
import java.util.Set;

/** Object Used to List Person */
public class PersonFilter extends BaseFilter {

  private Set<String> address;

  private OffsetDateTime birthdateEnd;

  private OffsetDateTime birthdateStart;

  private Set<String> email;

  private Set<String> phoneNumber;

  private Set<String> socialSecurityNumber;

  private OffsetDateTime socialSecurityNumberEnd;

  /**
   * @return address
   */
  public Set<String> getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setAddress(Set<String> address) {
    this.address = address;
    return (T) this;
  }

  /**
   * @return birthdateEnd
   */
  public OffsetDateTime getBirthdateEnd() {
    return this.birthdateEnd;
  }

  /**
   * @param birthdateEnd birthdateEnd to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setBirthdateEnd(OffsetDateTime birthdateEnd) {
    this.birthdateEnd = birthdateEnd;
    return (T) this;
  }

  /**
   * @return birthdateStart
   */
  public OffsetDateTime getBirthdateStart() {
    return this.birthdateStart;
  }

  /**
   * @param birthdateStart birthdateStart to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setBirthdateStart(OffsetDateTime birthdateStart) {
    this.birthdateStart = birthdateStart;
    return (T) this;
  }

  /**
   * @return email
   */
  public Set<String> getEmail() {
    return this.email;
  }

  /**
   * @param email email to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setEmail(Set<String> email) {
    this.email = email;
    return (T) this;
  }

  /**
   * @return phoneNumber
   */
  public Set<String> getPhoneNumber() {
    return this.phoneNumber;
  }

  /**
   * @param phoneNumber phoneNumber to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setPhoneNumber(Set<String> phoneNumber) {
    this.phoneNumber = phoneNumber;
    return (T) this;
  }

  /**
   * @return socialSecurityNumber
   */
  public Set<String> getSocialSecurityNumber() {
    return this.socialSecurityNumber;
  }

  /**
   * @param socialSecurityNumber socialSecurityNumber to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setSocialSecurityNumber(Set<String> socialSecurityNumber) {
    this.socialSecurityNumber = socialSecurityNumber;
    return (T) this;
  }

  /**
   * @return socialSecurityNumberEnd
   */
  public OffsetDateTime getSocialSecurityNumberEnd() {
    return this.socialSecurityNumberEnd;
  }

  /**
   * @param socialSecurityNumberEnd socialSecurityNumberEnd to set
   * @return PersonFilter
   */
  public <T extends PersonFilter> T setSocialSecurityNumberEnd(
      OffsetDateTime socialSecurityNumberEnd) {
    this.socialSecurityNumberEnd = socialSecurityNumberEnd;
    return (T) this;
  }
}
