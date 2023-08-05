package com.kaspper.tarefasapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaspper.tarefasapi.entity.Tarefa;
import com.kaspper.tarefasapi.repository.TarefaRepository;

@CrossOrigin
@RestController
@RequestMapping("tarefas")
public class TarefaController {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@GetMapping
	public List<Tarefa> listarTarefas(){
		var tarefas = tarefaRepository.findAll();
		
		return tarefas;
	}
	
	@PostMapping
	public Tarefa inserirTarefa(@RequestBody Tarefa novaTarefa) {
		var tarefa = tarefaRepository.save(novaTarefa);
		
		return tarefa;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarTarefa(@PathVariable UUID id) {
		var tarefaOp = tarefaRepository.findById(id);
		
		if(tarefaOp.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		tarefaRepository.deleteById(id);
		
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Tarefa> buscarPorId(@PathVariable UUID id) {
		var tarefa = tarefaRepository.findById(id);
		
		if(tarefa.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(tarefa.get());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable UUID id, @RequestBody Tarefa tarefaAtualizar) {
		tarefaAtualizar.setId(id);
		
		var tarefaSalva = tarefaRepository.save(tarefaAtualizar);
		
		return ResponseEntity.ok(tarefaSalva);
	}

}
