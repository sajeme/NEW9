/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Personal
 */
public class VentanaGraficoBarras extends JFrame{
    
    public static VentanaGraficoBarras graficoBarras;
    /*
        public static VentanaGraficoBarras getInstancia() {
        if (graficoBarras == null) {
            graficoBarras = new VentanaGraficoBarras();
        }
        return graficoBarras;
    }
    */
    JPanel panel;
    public VentanaGraficoBarras(){
        setTitle("Grafico barras");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(false);
    }
    
    public void inicializarGrafica(String [][] datos, int tamaño) {
        panel = new JPanel();
        getContentPane().add(panel);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < tamaño; i++) {
            dataset.setValue(Double.parseDouble(datos[i][1]), "Producto", datos[i][0]);
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Votos de los productos","Productos", "Numero de votos", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.cyan);
        chart.getTitle().setPaint(Color.black); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); 
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
}
