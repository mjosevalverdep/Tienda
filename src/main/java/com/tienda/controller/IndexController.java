
package com.tienda.controller;

import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Carrito;
import com.tienda.domain.CarritoDetalle;
import com.tienda.domain.Usuario;
import com.tienda.service.ArticuloService;
import com.tienda.service.CarritoDetalleService;
import com.tienda.service.CarritoService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired
    ArticuloService articuloService;
    
    @Autowired
    CarritoService carritoService;
    
    @Autowired
    CarritoDetalleService carritoDetalleService;
    
    @Autowired
    UsuarioDao usuarioDao;
    
    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request) {
        
        // Obtener usuario Loggeado
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;
        
        if (principal instanceof UserDetails){
            user = (UserDetails) principal;
        }
        // Validar si el usuario es de un cliente
        boolean esCliente = false;
        if (user != null) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());

            if (usuario.getIdCliente() != null && usuario.getIdCliente() != 0) {
                esCliente = true;
                Carrito carrito = carritoService.getCarritoCliente(usuario.getIdCliente());
                request.getSession().setAttribute("idCliente", usuario.getIdCliente());
                request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
                request.getSession().setAttribute("esCliente", esCliente);

                //Consultar items del carrito
                List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
                model.addAttribute("cantidadArticulosCarrito", carritoDetalles.size());
            }

        }
        var articulos=articuloService.getArticulos(true);
        model.addAttribute("articulos",articulos);
        model.addAttribute("esCliente",esCliente);
        
        return "index";
    }   
}
