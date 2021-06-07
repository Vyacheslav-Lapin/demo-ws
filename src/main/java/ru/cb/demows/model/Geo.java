package ru.cb.demows.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@With
@Value
@Jacksonized
@Builder(toBuilder = true)
public class Geo {

  @JsonProperty("lat")
  Double latitude;

  @JsonProperty("lng")
  Double longitude;
}
