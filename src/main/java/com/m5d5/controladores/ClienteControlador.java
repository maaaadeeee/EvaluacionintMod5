package com.m5d5.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;

import com.m5d5.beans.Cliente;
import com.m5d5.dao.ClienteDao;   

@Controller
public class ClienteControlador {

	@Autowired
	ClienteDao dao;
	
	static Logger log = Logger.getLogger(ClienteControlador.class.getName());
	
    @RequestMapping("/cliform")    
    public String showform(Model m){
        m.addAttribute("command", new Cliente());
        log.info("Ingreso a formulario de creación de clientes");
        return "cliform";
    } 

    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("cli") Cliente cli){    
        dao.save(cli);
        log.info("Cliente creado: " + cli.toString());
        return "redirect:/viewcli";
    }
    
    @RequestMapping("/viewcli")    
    public String viewcli(Model m){    
        List<Cliente> list=dao.getClientes();
        m.addAttribute("list",list);  
        log.error("Listado de clientes");
        return "viewcli";
    }
    
    @RequestMapping(value="/editcli/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Cliente cli=dao.getCliById(id);
        m.addAttribute("command",cli);
        log.info("Ingreso a edición de clientes");
        return "clieditform";
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("cli") Cliente cli){
        dao.update(cli);
        log.info("Procesando edición de clientes");
        return "redirect:/viewcli";
    }

    @RequestMapping(value="/deletecli/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.deletecli(id);
        log.debug("DEBUG - Cliente eliminado");
        return "redirect:/viewcli";
    }
    
}
