/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Personal
 */
public interface Observa {
         public void suscribirObservador(Observador observador);
	public void notificarObservadores(String mensaje, Object parametro);
}
