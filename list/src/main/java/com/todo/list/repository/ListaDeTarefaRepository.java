package com.todo.list.repository;

import com.todo.list.entity.ListaDeTarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeTarefaRepository extends JpaRepository<ListaDeTarefa, Long> {
}
