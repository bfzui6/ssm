package com.kzm.ssm.control;

import com.kzm.ssm.domain.Product;
import com.kzm.ssm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    @RolesAllowed("admin")
    public ModelAndView findAll() throws Exception {
        List<Product> products = productService.finAll();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("productList",products);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(HttpServletRequest request, Product product) throws Exception {
        //String path=request.getServletContext().getContextPath()+"/pages/product-list";
        productService.saveProduct(product);
        return "redirect:findAll";
    }
}
