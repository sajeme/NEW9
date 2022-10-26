/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.*;
import Vista.*;
import Controlador.*;
import java.util.ArrayList;

/**
 *
 * @author Personal
 */
public class Menu implements Observador
{
        VistaPrincipal vistaPrincipal;
	Controlador controlador;
	
        public Menu()
        {
            controlador = new Controlador(this);
        }
        
	
	public void accionVotar(String nombreProducto)
        {
            controlador.votarProducto(nombreProducto);
        }
	
	@Override
	public void actualizar(String mensaje, Object parametro)
	{
            System.out.println(mensaje);
		switch(mensaje.toString())
		{
			case "Inicializada lista productos":
				actualizarLista((ArrayList<String>)parametro);
				break;
			case "Voto registrado":
				actualizarVotos((ArrayList<String>)parametro);
				break;
			default:
				break;
		}
	}
	
	public void actualizarLista(ArrayList<String> nombresProductos)
	{
            String[][] datos = new String[nombresProductos.size()][2];
            
            for (int i = 0; i < nombresProductos.size(); i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    if (j == 0) datos[i][j] = nombresProductos.get(i);
                    if (j == 1) datos[i][j] = "0";
                }
            }
            
            vistaPrincipal = new VistaPrincipal(this, datos);
            vistaPrincipal.setVisible(true);
	}
	
	public void actualizarVotos(ArrayList<String> producto)
	{
            System.out.println();
            String nombreProducto = producto.get(0);
            String votosProducto = producto.get(1);
	
            vistaPrincipal.actualizarProducto(nombreProducto, votosProducto);
	}
}
