package com.todo.list.controller;

import com.todo.list.dto.TarefaRequestDTO;
import com.todo.list.dto.TarefaResponseDTO;
import com.todo.list.service.TarefaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaServiceImpl tarefaService;

    public TarefaController(TarefaServiceImpl tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@Valid @RequestBody TarefaRequestDTO tarefaRequestDTO){
        TarefaResponseDTO result = tarefaService.criarTarefa(tarefaRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(result);
    }


}
