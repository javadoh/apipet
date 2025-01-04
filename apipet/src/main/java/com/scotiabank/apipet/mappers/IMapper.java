package com.scotiabank.apipet.mappers;

public interface IMapper<IN,OUT>{
    public OUT map(IN in);
}
