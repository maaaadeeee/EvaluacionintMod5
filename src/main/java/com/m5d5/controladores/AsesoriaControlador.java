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

import com.m5d5.beans.Asesoria;
import com.m5d5.beans.Cliente;
import com.m5d5.dao.AsesoriaDao;
import com.m5d5.dao.ClienteDao;   

@Controller
public class AsesoriaControlador {

	@Autowired
	AsesoriaDao daoase;
	
	@Autowired 
	ClienteDao dao;
	
	static Logger log = Logger.getLogger(AsesoriaControlador.class.getName());
	
    @RequestMapping("/aseform")    
    public String showform(Model m){
        m.addAttribute("command", new Asesoria());
        List<Cliente> listcli = dao.getClientes();
        m.addAttribute("listaclientes", listcli);
        log.info("Ingreso a formulario de creaci�n de asesorias");
        return "aseform";
    } 

    @RequestMapping("/VisualizarActividad")
    public String showform2(Model m){
        m.addAttribute("command", new Asesoria());
        List<Cliente> listcli = dao.getClientes();
        m.addAttribute("listcliente", listcli);
        log.info("Ingreso a formulario de creaci�n de asesorias");
        return "VisualizarActividad";
    }
    @RequestMapping(value="/asesave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("ase") Asesoria ase){    
        daoase.save(ase);
        log.info("Asesoria creada: " + ase.toString());
        return "redirect:/viewase";
    }
    
    @RequestMapping("/viewase")    
    public String viewase(Model m){    
        List<Asesoria> list=daoase.getAsesoria();
        m.addAttribute("lista",list);  
        log.info("Listado de asesorias");
        return "viewase";
    }
    
    @RequestMapping(value="/editase/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Asesoria ase=daoase.getAseById(id);
        m.addAttribute("command",ase);
        log.info("Ingreso a edici�n de asesorias");
        return "aseeditform";
    }

    @RequestMapping(value="/editsavease",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("ase") Asesoria ase){
        daoase.update(ase);
        log.info("Procesando edici�n de asesorias");
        return "redirect:/viewase";
    }

    @RequestMapping(value="/deletease/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        daoase.delete(id);
        log.debug("DEBUG - Asesoria eliminada");
        return "redirect:/viewase";
    }
    	
}
