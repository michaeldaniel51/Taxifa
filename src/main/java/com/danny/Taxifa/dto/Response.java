package com.danny.taxifa.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.danny.taxifa.dto.ResponseStatus.Created;
import static com.danny.taxifa.dto.ResponseStatus.Successful;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response <T>{


    private int code;
    private ResponseStatus status;
    private String description;
    private T data;
    private T error;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
    }

    private Response(){}

    public static <T> Response <T> build(ResponseStatus status,T data){

        Response<T> response = new Response<>();
        response.setCode(status.getCode());
        response.setStatus(status);
        response.setDescription(status.getMessage());

        if((status.equals(Successful)) || status.equals(Created)){
            response.setData(data);
        }else {

            response.setError(data);
        }

        return response;

    }

}
