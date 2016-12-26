package com.prongbang.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prongbang.hibernate.entities.Address;
import com.prongbang.hibernate.entities.Person;
import com.prongbang.hibernate.service.PersonService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(ModelMap model) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try {
			
			List<Person> persons = personService.findAll();
			model.addAttribute("persons", persons);
			System.out.println(gson.toJson(persons));
			
			List<Address> addresss = personService.findPersonAddressByPersonId(1);
			System.out.println(gson.toJson(addresss));
			model.addAttribute("addresss", addresss);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) { 
		
        return "admin";
    }
 
    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) { 
		
        return "dba";
    }
	
	
}
