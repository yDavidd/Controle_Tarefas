package com.tarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarefas.entities.Tarefas;
import com.tarefas.entities.Tarefas;
import com.tarefas.repository.TarefaRepository;

@Service
public class TarefaServico {
	private final TarefaRepository tarefaRepository;
	
	@Autowired
	public TarefaServico(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	public Tarefas saveTarefa (Tarefas tarefas) {
		return tarefaRepository.save(tarefas);
	}
	public Tarefas getTarefaById(Long id) {
		return tarefaRepository.findById(id).orElse(null);
	}
	public List<Tarefas> getAllTarefas(){
		return tarefaRepository.findAll();
	}
	public void deleteTarefa (Long id) {
		tarefaRepository.deleteById(id);
	}
	public Tarefas alterarTarefa(Long id, Tarefas alterarTarefa) {
		Optional <Tarefas> existeTarefa = tarefaRepository.findById(id);
		if(existeTarefa.isPresent()) {
			alterarTarefa.setId(id);
			return tarefaRepository.save(alterarTarefa);
		}
		return null;
	}

}
