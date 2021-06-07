package ru.cb.demows.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.cb.demows.model.Cat;

public interface CatDao extends JpaRepository<Cat, UUID> {
}
