/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Personal
 */
public class VentanaGraficoPastel extends JFrame{
    JFreeChart chart;
    ChartPanel chartPanel;
    JPanel panel;
    DefaultPieDataset data;
    public static VentanaGraficoPastel graficoPastel;
    
    public VentanaGraficoPastel(){
        setTitle("Grafico Pastel");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(false);
    }
    
    public void iniciarGrafica(String[][] datos, int tamaño) {
 
        panel = new JPanel();
        getContentPane().add(panel);

        DefaultPieDataset data = new DefaultPieDataset(); 
            for (int i = 0; i < tamaño; i++) {
            data.setValue(datos[i][0] ,Double.parseDouble(datos[i][1]));
        }

            JFreeChart chart = ChartFactory.createPieChart("Votos de productos", data, true, true, false);

            ChartPanel chartPanel = new ChartPanel(chart);
            panel.add(chartPanel);

    }
    
}
