package com.demodynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.demodynamodb.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Funcionario save(Funcionario funcionario) {
        dynamoDBMapper.save(funcionario);
        return funcionario;
    }

    public Funcionario getFuncionarioById(String funcionarioId) {
        return dynamoDBMapper.load(Funcionario.class, funcionarioId);
    }

    public String delete(String funcionarioId) {
        Funcionario response = dynamoDBMapper.load(Funcionario.class, funcionarioId);
        dynamoDBMapper.delete(response);
        return "Funcionário deletado com sucesso";
    }

    public String update(String funcionarioId, Funcionario funcionario){
        dynamoDBMapper.save(funcionario,
                new DynamoDBSaveExpression()
        .withExpectedEntry("funcionarioId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(funcionarioId)
                        )));
        return funcionarioId;
    }
}
