package edu.kea.adventure_project.controllers;

import edu.kea.adventure_project.models.Product;
import edu.kea.adventure_project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Julius Panduro
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    //Frederik
    @GetMapping("/updateProduct/{productID}")
    public String updateProduct(@PathVariable("productID") Long productID, Model model) {
        model.addAttribute("product", productService.readProductById(productID));
        return "/updateProduct";
    }

    @GetMapping("/createProduct")
    public String createProduct() {
        return "/createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String fetchAll(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/products";
    }


    @PostMapping("updateProduct")
    public String updateProduct(@ModelAttribute Product product) {
        productService.updateProduct(product.getProductID(), product);
        return "redirect:/products";
    }


    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
