package com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    private String id;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @NotBlank(message = "please provide a name")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "createdAt", nullable = false)
    private Long createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Long updatedAt;

    @Column(name = "deletedAt")
    private Long deletedAt;

    @Column(name = "status", nullable = false)
    private StatusEnum status;

    public Category() {
        id = UUID.randomUUID().toString();
        status = StatusEnum.SHOW;
        createdAt = System.currentTimeMillis();
        updatedAt = System.currentTimeMillis();
    }

    public enum StatusEnum {
        SHOW (0),
        DELETED (1);

        private final int value;
        StatusEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
