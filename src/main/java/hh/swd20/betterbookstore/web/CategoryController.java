package hh.swd20.betterbookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.betterbookstore.domain.Category;
import hh.swd20.betterbookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;
	
	@RequestMapping(value = "/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/addc")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		repository.save(category);
		return "redirect:categorylist";
	}

}
