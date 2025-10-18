package com.todo.list.service;

import com.todo.list.dto.TarefaRequestDTO;
import com.todo.list.dto.TarefaResponseDTO;
import com.todo.list.entity.Tarefa;
import com.todo.list.enums.TarefaStatus;
import com.todo.list.exceptions.ResourceNotFoundException;
import com.todo.list.exceptions.UnprocessableEntity;
import com.todo.list.mapper.TarefaMapper;
import com.todo.list.repository.TarefaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class TarefaServiceImpl{

    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional(readOnly = false)
    public TarefaResponseDTO criarTarefa(TarefaRequestDTO tarefaRequestDTO) {
        Tarefa tarefa = TarefaMapper.dtoParaTarefa(tarefaRequestDTO);

        return TarefaMapper
                .tarefaParaDto(tarefaRepository.save(tarefa));
    }


    @Transactional(readOnly = false)
    public TarefaResponseDTO atualizarEstadoParaEmAndamento(Long id) {
        if(tarefaRepository.existeTarefaEmAndamento()){
            throw new UnprocessableEntity("Existe uma tarefa em andamento, termine ela e começe outra");
        }

        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com id (" + id + ") não existe"));

        if(!tarefa.getStatus().equals(TarefaStatus.CRIADA)){
            throw new UnprocessableEntity("Só pode mudar o status para (EM ANDAMENTO) de tarefas com status (Criada)");
        }

        tarefa.setStatus(TarefaStatus.EM_ANDAMENTO);


        return TarefaMapper
                .tarefaParaDto(tarefaRepository.save(tarefa));
    }

    @Transactional
    public TarefaResponseDTO finalizarTarefa(Long id) {
        Tarefa tarefa = buscarTarefaPorId(id);

        if(!tarefa.getStatus().equals(TarefaStatus.EM_ANDAMENTO)){
            throw new UnprocessableEntity("O status da tarefa tem que ser (EM ANDAMENTO)");
        }

        if(!Instant.now().isAfter(tarefa.getCreatedAt().plusSeconds(300))){
            throw new UnprocessableEntity("Só é possivel finalizar uma tarefa que está em andamento a no minimo 5 minutos");
        }

        tarefa.setStatus(TarefaStatus.FINALIZADA);
        tarefa.setCreatedAt(Instant.now());

        tarefaRepository.save(tarefa);
        return TarefaMapper.tarefaParaDto(tarefa);
    }

    private Tarefa buscarTarefaPorId(Long id){
        return  tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id inexistente"));
    }


}
