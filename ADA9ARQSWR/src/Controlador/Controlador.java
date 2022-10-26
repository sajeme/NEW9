/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;

/**
 *
 * @author Personal
 */
public class Controlador
{
	Modelo modelo;
	
	public Controlador(Menu vistaMenu)
	{
                modelo = new Modelo(vistaMenu);
	}
	
	public void votarProducto(String nombreProducto)
	{
		modelo.registrarVoto(nombreProducto);
	}
}
