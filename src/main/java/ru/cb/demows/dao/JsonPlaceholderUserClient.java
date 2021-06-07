package ru.cb.demows.dao;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.cb.demows.model.User;

@FeignClient(
    name = "JsonPlaceholderUserClient",
    url = "https://jsonplaceholder.typicode.com",
    path = "users"
)
public interface JsonPlaceholderUserClient {

  @GetMapping
  ResponseEntity<List<User>> getAll();

  @GetMapping("{id}")
  User get(@PathVariable Integer id);
}
