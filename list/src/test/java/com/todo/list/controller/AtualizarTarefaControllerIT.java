package com.todo.list.controller;

import com.todo.list.repository.TarefaRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AtualizarTarefaControllerIT {

    @Autowired
    private TarefaRepository tarefaRepository;

    @LocalServerPort
    private int port;
    private Long tarefaExistenteIdStatusCriada, tarefaInexistenteId;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        tarefaExistenteIdStatusCriada = 1L;


        tarefaInexistenteId =3000L;


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

    @Test
    public void atualizarStatusTarefaParaEmAndamentoDeveriaAtualizarTarefaQuandoIdInexistente(){
        given()
                .when()
                .put("/tarefas/{tarefaInexistenteId}", tarefaInexistenteId)

                .then()
                .statusCode(404)
                .body("error", is("Tarefa com id (" + tarefaInexistenteId + ") não existe"));
    }



}
