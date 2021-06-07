package ru.cb.demows.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.validation.annotation.Validated;

@Value
@Validated
@Jacksonized
@Builder(toBuilder = true)
public class User {
  Integer id;

  @NotBlank
  String name;

  @NotBlank
  @JsonProperty("username")
  String userName;

  String email; //todo 07.06.2021: email format check
  String phone; //todo 07.06.2021: email format check

  @JsonProperty("website")
  String webSite; //todo 07.06.2021: email format check

  Address address;

  Company company;
}
