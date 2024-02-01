package com.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefas.entities.Tarefas;
import com.tarefas.services.TarefaServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	private final TarefaServico tarefaServico;
	
	@Autowired 
	public TarefaController (TarefaServico tarefaServico) {
		this.tarefaServico = tarefaServico;
	}
	@GetMapping("/{id}")
	public Tarefas getTarefa(@PathVariable Long id) {
		return tarefaServico.getTarefaById(id);
	}
	@PostMapping
	private Tarefas createTarefa(@RequestBody Tarefas tarefas) {
		return tarefaServico.saveTarefa(tarefas);
	}
	@GetMapping 
	public List<Tarefas>getAllTarefas(){
		return tarefaServico.getAllTarefas();
	}
	@DeleteMapping("/{id}")
	public void deleteTarefa(@PathVariable Long id) {
		tarefaServico.deleteTarefa(id);
	}
	public ResponseEntity<Tarefas> alteraTarefaControl (@PathVariable Long id, @RequestBody @Valid Tarefas tarefas){
		Tarefas alteraTarefa = tarefaServico.alterarTarefa(id, tarefas);
		if(alteraTarefa != null) {
			return ResponseEntity.ok(tarefas);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
