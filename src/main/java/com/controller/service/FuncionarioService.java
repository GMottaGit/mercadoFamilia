
package com.controller.service;

import com.controller.model.Funcionario;
import com.controller.model.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
     @Autowired
     FuncionarioRepository fr;
     public Funcionario criarFuncionario(Funcionario funcionario) {
        funcionario.setId(null);
        fr.save(funcionario);
        return funcionario;
    }
     public List<Funcionario> listarTodosFuncionarios() {
        return fr.findAll();
    }
     public Funcionario getFuncionarioId(Integer funcId){
        Funcionario f = fr.findById(funcId).orElse(null);
        return f;
    }
     public void deletarFuncionario(Integer id){
       
        Funcionario funcionario = this.getFuncionarioId(id);
        fr.deleteById(funcionario.getId());
        
    }
}
