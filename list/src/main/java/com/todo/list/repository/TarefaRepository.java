package com.todo.list.repository;

import com.todo.list.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("SELECT COUNT(t) > 0 FROM Tarefa t WHERE t.status = 'EM_ANDAMENTO'")
    boolean existeTarefaEmAndamento();

}
