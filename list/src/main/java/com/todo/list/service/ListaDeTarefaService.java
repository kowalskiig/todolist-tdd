package com.todo.list.service;

import com.todo.list.dto.RequestListaDeTarefa;
import com.todo.list.dto.RespondeListaDeTarefa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListaDeTarefaService {

    @Transactional(readOnly = false)
    public RespondeListaDeTarefa criarTarefa(RequestListaDeTarefa requestListaDeTarefa) {
        return null;
    }
}
