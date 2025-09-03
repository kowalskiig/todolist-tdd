package com.todo.list.service;

import com.todo.list.dto.RequestListaDeTarefa;
import com.todo.list.dto.ResponseListaDeTarefa;
import com.todo.list.entity.ListaDeTarefa;
import com.todo.list.mapper.ListaTarefaMapper;
import com.todo.list.repository.ListaDeTarefaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListaDeTarefaService {

    private final ListaDeTarefaRepository listaDeTarefaRepository;

    public ListaDeTarefaService(ListaDeTarefaRepository listaDeTarefaRepository) {
        this.listaDeTarefaRepository = listaDeTarefaRepository;
    }

    @Transactional(readOnly = false)
    public ResponseListaDeTarefa criarListaDeTarefa(RequestListaDeTarefa requestListaDeTarefa) {

        ListaDeTarefa listaDeTarefa = ListaTarefaMapper.toEntity(requestListaDeTarefa);

        return ListaTarefaMapper
                .toDto(listaDeTarefaRepository.save(listaDeTarefa));
    }
}
