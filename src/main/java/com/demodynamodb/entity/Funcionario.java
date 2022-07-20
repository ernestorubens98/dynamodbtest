package com.demodynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "funcionario")
public class Funcionario {

    @DynamoDBHashKey(attributeName = "funcionario_id")
    @DynamoDBAutoGeneratedKey
    private String funcionarioId;

    @DynamoDBRangeKey(attributeName = "data_nascimento")
    @DynamoDBAttribute
    private String dataNascimento;

    @DynamoDBAttribute
    private String nome;

    @DynamoDBAttribute
    private String sobrenome;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private Departamento departamento;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @DynamoDBDocument
    public static class Departamento {

        @DynamoDBAttribute
        private String departamentoNome;

        @DynamoDBAttribute
        private String codigoDepartamento;
    }

}