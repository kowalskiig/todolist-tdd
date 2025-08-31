package com.todo.list.service;

import com.todo.list.dto.TarefaRequestDTO;
import com.todo.list.dto.TarefaResponseDTO;
import com.todo.list.entity.Tarefa;
import com.todo.list.repository.TarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class TarefaServiceImpl implements TarefaServiceContrato {

    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public TarefaResponseDTO criarTarefa(TarefaRequestDTO tarefaRequestDTO) {
        Tarefa tarefa = new Tarefa(
                tarefaRequestDTO.getName(),
                tarefaRequestDTO.getDescription());


        tarefa = tarefaRepository.save(tarefa);
        return new TarefaResponseDTO(tarefa);
    }
}
