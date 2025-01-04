package com.scotiabank.apipet.services.dto;

public class PetCreateDTO {
    private Integer id;
    private String name;
    private String status;
    private String transactionId;
    private String dateCreated;

    public PetCreateDTO() {}
    public PetCreateDTO(Integer id, String name, String status, String transactionId, String dateCreated) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.transactionId = transactionId;
        this.dateCreated = dateCreated;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
