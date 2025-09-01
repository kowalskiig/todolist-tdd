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

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
public class AtualizarTarefaControllerIT {

    @LocalServerPort
    private int port;
    private Long tarefaExistenteIdStatusCriada;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        tarefaExistenteIdStatusCriada = 1L;
    }

    @Test
    public void atualizarStatusTarefaParaEmAndamentoDeveriaAtualizarTarefaQuandoCenarioSucesso(){
        given()
                .when()
                .put("/tarefas/{tarefaExistenteIdStatusCriada}", tarefaExistenteIdStatusCriada)

                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", equalTo("Estudar Java"))
                .body("tarefaStatus", is("EM_ANDAMENTO"));
    }


}
