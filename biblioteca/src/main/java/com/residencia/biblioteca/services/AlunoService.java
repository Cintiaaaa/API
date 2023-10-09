package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {

	//CRUD
	//Recuperar todos os alunos
	//Recuperar um aluno pela sua chave primária
	//Salvar um novo aluno
	//Atualizar um determinado aluno
	//deletar um determinado aluno

	@Autowired
	AlunoRepository alunoRepo;
	
	public List<Aluno> listarAlunos() {
		return alunoRepo.findAll();
		}
	
	public Aluno buscarAlunoPorId(Integer id) {
		return alunoRepo.findById(id).get();
	}
	
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public void deletarAluno(Aluno aluno) {
		alunoRepo.delete(aluno);
	/*Aluno confereAlunoDeletado = buscarAlunoPorID(aluno.getNumreoMatriculaAluno());
	*/}
}
