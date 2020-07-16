package com.m5d5.controladores;

//import java.util.ArrayList;
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

import com.m5d5.beans.Accidente;
import com.m5d5.beans.Cliente;
import com.m5d5.dao.AccidenteDao;
import com.m5d5.dao.ClienteDao;   

@Controller
public class AccidenteControlador {


	@Autowired
	AccidenteDao daoacci;
	@Autowired 
	ClienteDao dao;
	
	static Logger log = Logger.getLogger(AccidenteControlador.class.getName());
	
   		
    @RequestMapping("/acciform")    
    public String showform(Model m){
        m.addAttribute("command", new Accidente());
        List<Cliente> listcli = dao.getClientes();
        m.addAttribute("listaclientes", listcli);
        log.info("Ingreso a formulario de creaci�n de accidentes");
        return "acciform";
    } 
    
    @RequestMapping("/cantacci")
    public String showform2(Model m){
      m.addAttribute("command", new Accidente());
        List<Cliente> listcli = dao.getClientes();
       m.addAttribute("listclientes", listcli);
       m.addAttribute("listcount", listcli.size());
        log.info("Ingreso a formulario de creaci�n de accidentes");
        return "cantacci";
}

    @RequestMapping(value="/accisave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("acci") Accidente acci){    
        daoacci.save(acci);
        log.info("Accidente creado: " + acci.toString());
        return "redirect:/viewacci";
    }
    
    @RequestMapping("/viewacci")    
    public String viewacci(Model m){    
        List<Accidente> list=daoacci.getAccidente();
        m.addAttribute("listado",list);  
        log.info("Listado de accidentes");
        return "viewacci";
    }
    
    @RequestMapping(value="/editacci/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Accidente acci=daoacci.getAcciById(id);
        m.addAttribute("command",acci);
        log.info("Ingreso a edici�n de accidentes");
        return "accieditform";
    }

    @RequestMapping(value="/editsaveacci",method = RequestMethod.POST)    
    public String edit(@ModelAttribute("acci") Accidente acci){
        daoacci.update(acci);
        log.info("Procesando edici�n de accidentes");
        return "redirect:/viewacci";
    }

    @RequestMapping(value="/deleteacci/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        daoacci.delete(id);
        log.debug("DEBUG - Accidente eliminado");
        return "redirect:/viewacci";
    }
    

    
}
 

