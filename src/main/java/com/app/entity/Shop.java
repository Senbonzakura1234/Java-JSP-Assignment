package com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @Column(name = "id")
    private String id;

    @OneToMany(mappedBy = "shop")
    private List<Product> products;

    @NotBlank(message = "please provide a name")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone")
    private String phone;

    @Email(message = "please provide a valid email")
    @NotBlank(message = "please provide a valid email")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "createdAt", nullable = false)
    private Long createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Long updatedAt;

    @Column(name = "deletedAt")
    private Long deletedAt;

    @Column(name = "status", nullable = false)
    private StatusEnum status;

    public Shop() {
        id = UUID.randomUUID().toString();
        status = StatusEnum.ACTIVE;
        createdAt = System.currentTimeMillis();
        updatedAt = System.currentTimeMillis();
    }

    public enum StatusEnum {
        ACTIVE(0),
        PENDING(1),
        CLOSED(2),
        LOCKED(3);

        private final int value;

        StatusEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
