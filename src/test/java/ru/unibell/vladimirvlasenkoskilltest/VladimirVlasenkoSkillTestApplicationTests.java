package ru.unibell.vladimirvlasenkoskilltest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.unibell.vladimirvlasenkoskilltest.repository.ClientRepository;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class VladimirVlasenkoSkillTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    public void deleteAllBeforeTests() throws Exception {
        clientRepository.deleteAll();
    }

    @Test
    public void shouldReturnRepositoryIndex() throws Exception {

        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.clients").exists());
    }

    @Test
    public void shouldCreateEntity() throws Exception {

        mockMvc.perform(post("/clients")
                        .content("{\"name\": \"Frodo Baggins\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("clients/")));
    }

    @Test
    public void shouldRetrieveEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/clients")
                        .content("{\"name\": \"Frodo Baggins\"}"))
                .andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Frodo Baggins"));
    }

//    @Test
//    public void shouldQueryEntity() throws Exception {
//
//        mockMvc.perform(post("/clients")
//                .content("{ \"name\": \"Frodo Baggins\"}"))
//                .andExpect(status().isCreated());
//
//        mockMvc.perform(
//                get("/clients/search/findByLastName?name={name}", "Baggins")).andExpect(
//                status().isOk()).andExpect(
//                jsonPath("$._embedded.people[0].firstName").value(
//                        "Frodo"));
//    }

    @Test
    public void shouldUpdateEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/clients")
                        .content("{\"name\": \"Frodo Baggins\"}"))
                .andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(put(location).content("{\"name\": \"Bilbo Baggins\"}"))
                .andExpect(status().isNoContent());

        mockMvc.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bilbo Baggins"));
    }

//    @Test
//    public void shouldPartiallyUpdateEntity() throws Exception {
//
//        MvcResult mvcResult = mockMvc.perform(post("/clients")
//                        .content("{\"name\": \"Frodo Baggins\"}"))
//                .andExpect(status().isCreated()).andReturn();
//
//        String location = mvcResult.getResponse().getHeader("Location");
//
//        mockMvc.perform(
//                patch(location).content("{\"name\": \"Bilbo Jr.\"}"))
//                .andExpect(status().isNoContent());
//
//        mockMvc.perform(get(location))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Bilbo Jr."));
//    }

    @Test
    public void shouldDeleteEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/clients")
                        .content("{ \"name\": \"Bilbo Baggins\"}"))
                .andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(delete(location)).andExpect(status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isNotFound());
    }


}
