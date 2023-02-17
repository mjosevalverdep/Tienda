
package com.tienda.controller;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author maria josé valverde peña
 */
@Slf4j
@Controller
public class IndexController {
    @Autowired
    ClienteService clienteService;
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC");
        //String fecha=new Date().toString();
        //String mensaje="Estamos en semana #4, saludos";
        //model.addAttribute("MensajeSaludo",mensaje);
        //model.addAttribute("fecha",fecha);
        //Cliente cliente= new Cliente("María José","Valverde Peña","mariajosevalverdepena@gmail.com","7117-9407");
        //Cliente cliente2= new Cliente("Carlos","Herrera Mata","carlosmataherrera@gmail.com","8768-9407");
        //Cliente cliente3= new Cliente("Ana"," Aguilar Mata","anita22@gmail.com","85768-9347");
        //model.addAttribute("cliente", cliente);

        //List<Cliente> clientes= Arrays.asList(cliente,cliente2,cliente3);
       var clientes= clienteService.getClientes();
      //var clientes= Arrays.asList();
      // List<Cliente> clientes = Arrays.asList();
       model.addAttribute("clientes", clientes);
       return "index";
    }
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
  
    @PostMapping ("/guardarCliente")
    public String guardarCliente (Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente=clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    @GetMapping("/eliminarCliente/{idCliente}")
     public String eliminarCliente(Cliente cliente){
         clienteService.delete(cliente);
         return "redirect:/";
     }
}
