package br.com.aweb.sistema_produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Product {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @NotBlank(message = "Nome é obrigatírio")
    private String name;
    @Positive(message = "Preço deve ser positivo =D")
    private Double price;
    private String description;

    // Construtores 
    public Product() {}
    public Product(Long id, @NotBlank(message = "Nome é obrigatírio") String name,
            @Positive(message = "Preço deve ser positivo =D") Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Métodos getters e setters
    
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
