package com.residencia.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoService;

	@GetMapping
	public ResponseEntity <List<Emprestimo>> listarEmprestimo() {
		return new ResponseEntity<> (emprestimoService.listarEmprestimos(),
				HttpStatus.OK);
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> buscarPorId(@PathVariable Integer id) {
		return new  ResponseEntity<>(emprestimoService.buscarEmprestimoPorId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Emprestimo> salvarEmprestimo(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(emprestimoService.salvarEprestimo(emprestimo), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity <Emprestimo> atualizar(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(emprestimoService.atualizarEmprestimo(emprestimo), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarEmprestimo(@RequestBody Emprestimo emprestimo) {
		emprestimoService.deletarEmprestimo(emprestimo);
		return new ResponseEntity<>("Deletado com Sucesso", HttpStatus.OK);	}
 }


