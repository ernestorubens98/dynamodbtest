package com.demodynamodb.controller;

import com.demodynamodb.entity.Funcionario;
import com.demodynamodb.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping("/funcionario")
    public Funcionario salvaFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/funcionario/{id}")
    public Funcionario buscaFuncionario(@PathVariable("id") String funcionarioId) {
        return funcionarioRepository.getFuncionarioById(funcionarioId);
    }

    @DeleteMapping("/funcionario/{id}")
    public String deletaFuncionario(@PathVariable("id") String funcionarioId) {
        return funcionarioRepository.delete(funcionarioId);
    }

    @PutMapping("/funcionario/{id}")
    public String atualizaFuncionario(String funcionarioId, @RequestBody Funcionario funcionario) {
        return funcionarioRepository.update(funcionarioId, funcionario);
    }

}
