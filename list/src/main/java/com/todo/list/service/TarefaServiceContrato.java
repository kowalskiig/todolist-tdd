package com.todo.list.service;

import com.todo.list.dto.TarefaRequestDTO;
import com.todo.list.dto.TarefaResponseDTO;

public interface TarefaServiceContrato {
    TarefaResponseDTO criarTarefa(TarefaRequestDTO tarefaRequestDTO);
}
