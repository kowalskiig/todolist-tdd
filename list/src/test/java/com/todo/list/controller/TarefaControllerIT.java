package com.todo.list.controller;

import com.todo.list.dto.TarefaRequestDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.transaction.annotation.Transactional;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
public class TarefaControllerIT {

    @LocalServerPort
    private int port;

    private TarefaRequestDTO newTarefaRequestDTO, emptyTarefaRequestDTO;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        newTarefaRequestDTO = new TarefaRequestDTO("description", "titulo");
        emptyTarefaRequestDTO = new TarefaRequestDTO();
    }

    @Test
    public void criarTarefaDeveriaCriarTarefaQuandoCenarioSucesso(){
        given()
                .body(newTarefaRequestDTO)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post("/tarefas")

                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", equalTo(newTarefaRequestDTO.getName()))
                .body("description", equalTo(newTarefaRequestDTO.getDescription()))
                .body("createdAt", notNullValue())
                .body("tarefaStatus", is("CRIADA"));
    }


    @Test
    public void criarTarefaDeveriaRetornarUnprocessableEntityQuandoCamposNullos(){
        given()
                .body(emptyTarefaRequestDTO)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post("/tarefas")

                .then()
                .statusCode(422)
                .body("errors.fieldName", hasItems("name", "description"))
                .body("errors", hasSize(2))
                .body("errors.message", hasItems("Campo requerido"));
    }
}

