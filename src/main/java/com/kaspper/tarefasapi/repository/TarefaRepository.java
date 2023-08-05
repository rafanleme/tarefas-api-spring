package com.kaspper.tarefasapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaspper.tarefasapi.entity.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

}