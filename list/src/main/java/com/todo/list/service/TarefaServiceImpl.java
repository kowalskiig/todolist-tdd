package com.todo.list.service;

import com.todo.list.dto.TarefaRequestDTO;
import com.todo.list.dto.TarefaResponseDTO;
import com.todo.list.entity.Tarefa;
import com.todo.list.mapper.TarefaMapper;
import com.todo.list.repository.TarefaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TarefaServiceImpl{

    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional(readOnly = false)
    public TarefaResponseDTO criarTarefa(TarefaRequestDTO tarefaRequestDTO) {
        Tarefa tarefa = TarefaMapper.dtoParaTarefa(tarefaRequestDTO);

        return TarefaMapper.tarefaParaDto(tarefaRepository.save(tarefa));
    }
}
