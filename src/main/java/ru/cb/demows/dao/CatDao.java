package ru.cb.demows.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cb.demows.model.Cat;

public interface CatDao extends JpaRepository<Cat, UUID> {

  @Query("from Cat where name like :nameLike")
  List<Cat> getFilteredCats(String nameLike);
}
