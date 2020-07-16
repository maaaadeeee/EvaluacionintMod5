package com.m5d5.controladores;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.m5d5.beans.Accidente;
import com.m5d5.beans.Visitas;
import com.m5d5.beans.Cliente;
import com.m5d5.dao.VisitasDao;
import com.m5d5.dao.ClienteDao;

public class VisitasControlador {


	@Autowired
	VisitasDao daoase;
	
	@Autowired 
	ClienteDao dao;
	
	static Logger log = Logger.getLogger(VisitasControlador.class.getName());
	
	
    @RequestMapping("/acciform")    
    public String showform(Model m){
        m.addAttribute("command", new Visitas());
        List<Cliente> listcli = dao.getClientes();
        m.addAttribute("listaclientes", listcli);
        log.info("Ingreso a formulario de creaci�n de Visistas");
        return "acciform";
    } 

    @RequestMapping(value="/vissave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("vis") Visitas vis){    
        daovis.save(vis);
        log.info("Visita creado: " + vis.toString());
        return "redirect:/viewvis";
    }
    
    @RequestMapping("/viewvis")    
    public String viewvis(Model m){    
        List<Accidente> list=daovis.getVisitas();
        m.addAttribute("lister",list);  
        log.info("Listado de Visitas");
        return "viewvis";
    }
    
    @RequestMapping(value="/editvis/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Visitas vis=daovis.getvisById(id);
        m.addAttribute("command",vis);
        log.info("Ingreso a edici�n de visitas");
        return "viseditform";
    }

    @RequestMapping(value="/editsavevis",method = RequestMethod.POST)    
    public String edit(@ModelAttribute("acci") Visitas vis){
        daovis.update(vis);
        log.info("Procesando edici�n de visitas");
        return "redirect:/viewacci";
    }

    @RequestMapping(value="/deletevis/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        daovis.delete(id);
        log.debug("DEBUG - Visitas eliminado");
        return "redirect:/viewvis";
    }
}

 