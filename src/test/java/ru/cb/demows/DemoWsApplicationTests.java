package ru.cb.demows;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor_ = @Autowired)
//@org.springframework.security.test.context.support.WithMockUser(authorities = "ADMIN")
class DemoWsApplicationTests {

  MockMvc mockMvc;

  @Test
  void contextLoads() {
  }

  @Test
  @SneakyThrows
  @DisplayName("Cat REST API works correctly")
  void catRESTAPIWorksCorrectlyTest() {
    mockMvc.perform(get("/api/cats"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(HAL_JSON_VALUE))
        .andExpect(jsonPath("$.page.totalElements").isNumber())
        .andExpect(jsonPath("$.page.totalElements").value(4));
  }
}
