package com.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController 
{
	@RequestMapping(value="/") 
	public String displayHome() {
	return "index";
	}
    @RequestMapping(value="/CosmeticsFrontend") 
    public String displayHom() {
    return "index";
 }
}