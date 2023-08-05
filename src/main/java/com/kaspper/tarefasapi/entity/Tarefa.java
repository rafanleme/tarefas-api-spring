package com.kaspper.tarefasapi.entity;


import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_tarefas")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	UUID id;
	
	String descricao;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date data;
	
	Boolean urgente;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getUrgente() {
		return urgente;
	}

	public void setUrgente(Boolean urgente) {
		this.urgente = urgente;
	}

	
	
}
