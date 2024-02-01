package com.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefas.entities.Tarefas;

public interface TarefaRepository extends JpaRepository <Tarefas, Long> {

}
