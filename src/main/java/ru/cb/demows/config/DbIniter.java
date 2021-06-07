package ru.cb.demows.config;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.cb.demows.dao.CatDao;
import ru.cb.demows.model.Cat;

@Component
@RequiredArgsConstructor
public class DbIniter implements CommandLineRunner {

  CatDao catDao;

  @Override
  public void run(String... args) {
    Arrays.stream("Васька, Мурзик, Матроскин".split(", "))
        .map(Cat::new)
        .forEach(catDao::save);
  }
}
