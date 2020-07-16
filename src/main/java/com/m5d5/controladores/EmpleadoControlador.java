package com.m5d5.controladores;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.m5d5.beans.Empleado;
import com.m5d5.dao.EmpleadoDao;

@Controller
public class EmpleadoControlador {

	@Autowired
	EmpleadoDao daoemp;
	
	static Logger log = Logger.getLogger(EmpleadoControlador.class.getName());
	
	 @RequestMapping("/empform")    
	    public String showform(Model m){
	        m.addAttribute("command", new Empleado());
	        log.info("Ingreso a formulario de creación de empleados");
	        return "empform";
	    } 

	    @RequestMapping(value="/empsave",method = RequestMethod.POST)    
	    public String saveemp(@ModelAttribute("emp") Empleado emp){    
	        daoemp.saveemp(emp);
	        log.info("Empleado creado: " + emp.toString());
	        return "redirect:/viewemp";
	    }
	
    @RequestMapping("/viewemp")    
    public String viewemp(Model m){
        List<Empleado> list=daoemp.getEmpleado();
        m.addAttribute("listar",list);  
        return "viewemp";
    }	
	
    @RequestMapping(value="/editemp/{idempleado}")    
    public String edit(@PathVariable int idempleado, Model m){    
        Empleado emp=daoemp.getEmpById(idempleado);
        m.addAttribute("command",emp);
        log.info("Ingreso a edición de empleados");
        return "empeditform";
    }

    @RequestMapping(value="/editsaveemp",method = RequestMethod.POST)    
    public String editsaveemp(@ModelAttribute("emp") Empleado emp){
        daoemp.updateemp(emp);
        log.info("Procesando edición de empleados");
        return "redirect:/viewemp";
    }

    @RequestMapping(value="/deleteemp/{idempleado}",method = RequestMethod.GET)    
    public String deleteemp(@PathVariable int idempleado){    
        daoemp.deleteemp(idempleado);
        log.debug("DEBUG - Empleado eliminado");
        return "redirect:/viewemp";
    }
    
}
