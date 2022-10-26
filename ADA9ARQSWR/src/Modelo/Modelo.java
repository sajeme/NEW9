/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Personal
 */
public class Modelo {
    private Fichero fichero= Fichero.getInstancia();
    private String direccionBitacora = "src/Modelo/Bitacora.txt";
    private String direccionNombresProductos = "src/Modelo/NombresProductos.txt";
    private String direccionVotacionesProductos = "src/Modelo/Votaciones";
    private ArrayList<Observador> observadores = new ArrayList<Observador>();
    private ArrayList<Producto> productos = new ArrayList<Producto>();
        
    public Modelo(Observador principal){
         suscribirObservador(principal);
            inicializarListaProductos();
    }
public void suscribirObservador(Observador observador)
	{
		observadores.add(observador);
                registrarBitacora("Observador suscrito.");
	}
	public void notificarObservadores(String mensaje, Object parametro)
	{
		for (int i = 0; i < observadores.size(); i++)
		{
			observadores.get(i).actualizar(mensaje, parametro);
		}
		registrarBitacora(mensaje);
	}
	
	private Producto encontrarProducto(String nombreProducto)
	{
		for (int i = 0; i < productos.size(); i++)
		{
			Producto producto = productos.get(i);
			if (producto.getNombre() == nombreProducto)
			{
				return producto;
			}
		}
		return null;
	}
	
	public void registrarVoto(String nombreProducto) 
	{
		Producto producto = encontrarProducto(nombreProducto);
		producto.setVotos(producto.getVotos()+1);
		
		Date fecha = new Date();
		
		fichero.escribirFichero(direccionVotacionesProductos+ "/"+producto.getNombre()+"Votaciones.txt", fecha.toString());
		
		actualizarListaProductos();
		
		ArrayList<String> parametros = new ArrayList<>();
		parametros.add(producto.getNombre());
		parametros.add(""+producto.getVotos());
		
		notificarObservadores("Voto registrado", parametros);
	}
	
	private void inicializarListaProductos()
	{
		ArrayList<String> listaNombres = fichero.leerFichero(direccionNombresProductos);
		
		for(int i = 0; i < listaNombres.size(); i++)
		{
			Producto productoNuevo = new Producto(listaNombres.get(i), 0);
			productos.add(productoNuevo);
			
			File archivoVotaciones = fichero.crearFichero(direccionVotacionesProductos+
															"/"+productoNuevo.getNombre()+
															"Votaciones.txt");
		}
                
		notificarObservadores("Inicializada lista productos", listaNombres);
	}
	
	private void actualizarListaProductos()
	{
		for(int i = 0; i < productos.size(); i++)
		{
			Producto productoActual = productos.get(i);
			ArrayList<String> votacionesProducto = fichero.leerFichero(direccionVotacionesProductos+
																		 "/"+productoActual.getNombre()+
																		 "Votaciones.txt");
			productoActual.setVotos(0);
			for(int j = 0; j < votacionesProducto.size(); j++)
			{
				productoActual.setVotos(productoActual.getVotos()+1);
			}
		}
	}
	
	private void registrarBitacora(String mensaje)
	{
		Date fecha = new Date();
		String entrada = "["+fecha.toString()+"] "+mensaje; 
		fichero.escribirFichero(direccionBitacora, entrada);
	}
}
