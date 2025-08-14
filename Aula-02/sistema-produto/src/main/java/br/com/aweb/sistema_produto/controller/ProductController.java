package br.com.aweb.sistema_produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aweb.sistema_produto.model.Product;
import br.com.aweb.sistema_produto.service.ProductService;  // Assuming you have a ProductService


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;  // Inject ProductService

    // Listar produtos
    @GetMapping
    public String list(Model model) { 
        model.addAttribute("products", productService.listAll());  // Use addAttribute to add data to the view
        return "products/list";  // Returns the view name for the product list page
    }

    // Retorna a view do formulario de cadastro/edição de produto
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());  // Add a new product instance for the form
        return "products/form";  // Return the view name for the form page
    }
}
