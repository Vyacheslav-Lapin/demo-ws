package ru.cb.demows.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cb.demows.dao.JsonPlaceholderUserClient;
import ru.cb.demows.model.User;

@RestController
@RequestMapping("${spring.data.rest.base-path}/users")
@RequiredArgsConstructor
public class UserController {

  JsonPlaceholderUserClient userClient;

  @NotNull
  @GetMapping
  public ResponseEntity<@NotNull List<User>> get() {
    return ResponseEntity.ok(userClient.getAll().getBody());
  }

  @NotNull
  @SneakyThrows
  @Contract(pure = true)
  @GetMapping("/{id}")
  public ResponseEntity<@NotNull User> getById(@PathVariable @NotNull Integer id) {
    return ResponseEntity.ok(userClient.get(id));
  }
}
