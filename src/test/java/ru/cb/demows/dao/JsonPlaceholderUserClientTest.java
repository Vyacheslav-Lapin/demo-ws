package ru.cb.demows.dao;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import ru.cb.demows.model.Address;
import ru.cb.demows.model.Geo;
import ru.cb.demows.model.User;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class JsonPlaceholderUserClientTest {

  JsonPlaceholderUserClient userClient;

  @Test
  @SneakyThrows
  @DisplayName("Feign client works correctly")
  void feignClientWorksCorrectlyTest() {
    assertThat(userClient.getAll()).isNotNull()
        .matches(listResponseEntity -> listResponseEntity.getStatusCodeValue() == 200)
        .extracting(ResponseEntity::getBody).isNotNull().asList()
        .hasSize(10);
  }

  @Test
  @SneakyThrows
  @DisplayName("Concrete feign query works correctly")
  void concreteFeignQueryWorksCorrectlyTest() {
    assertThat(userClient.get(1)).isNotNull()
        .extracting(User::getAddress)
        .extracting(Address::getGeo)
        .extracting(Geo::getLatitude, Geo::getLongitude)
        .contains(-37.3159, 81.1496);
  }
}
