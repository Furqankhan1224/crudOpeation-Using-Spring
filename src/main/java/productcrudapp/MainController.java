package productcrudapp;

import java.util.List;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	@Autowired
	private ProductDao productDao;
  @RequestMapping("/")

  public String home(Model model) {
	  List<Product> products = this.productDao.getProducts();
	  model.addAttribute("product", products);
	  return "index";
  }
  @RequestMapping("/add-product")
  public String addProduct(Model model) {
	  model.addAttribute("title", "Add Product");
	return "add_product_form";
	  
  }
  
  @RequestMapping(value = "/handler-product",method =RequestMethod.POST )
  public RedirectView handlerProduct(@ModelAttribute Product product,HttpServletRequest req) {
	  System.out.println(product);
	  this.productDao.createProduct(product);
	  RedirectView redirectView = new RedirectView();
	  redirectView.setUrl( req.getContextPath() +"/");
	return redirectView;  
  }
  @RequestMapping("/delete/{productId}")
  public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) {
	  this.productDao.deletProduct(productId);
	  RedirectView redirectView = new RedirectView();
	  redirectView.setUrl( request.getContextPath() +"/");
	return redirectView; 
	
}
  @RequestMapping("/update/{productId}")
  public String updateForm(@PathVariable("productId") int productId,Model model ) {
	  Product product = this.productDao.getProduct(productId);
	  model.addAttribute("product",product );
	return "update_form";
	  
  }
}
