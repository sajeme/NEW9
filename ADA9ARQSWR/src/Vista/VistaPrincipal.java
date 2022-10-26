/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Personal
 */
public class VistaPrincipal extends javax.swing.JFrame {
    Menu menuVista;
    JButton botonVotar = new JButton();
    /**
     * Creates new form VistaPrincipal
     */
   public VistaPrincipal(Menu menuVista, String[][] datos) 
    {
        initComponents();
        this.menuVista = menuVista;
        
        String[] columns = new String[] {"Nombre", "Votos", "Accion"};
        String[][] data = datos;
        DefaultTableModel model = new DefaultTableModel(data,columns);
        jTable1.setModel(model);
        jTable1.getColumn("Accion").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Accion").setCellEditor(new ButtonEditor(new JCheckBox()));

        botonVotar.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String nombreProducto = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    menuVista.accionVotar(nombreProducto);
                }
            }
        );
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        boton_graficoBarras = new javax.swing.JButton();
        boton_graficoPastel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        boton_graficoBarras.setText("Grafico de Barras");
        boton_graficoBarras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_graficoBarrasMouseClicked(evt);
            }
        });

        boton_graficoPastel.setText("Grafico de Pastel");
        boton_graficoPastel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_graficoPastelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_graficoBarras)
                        .addGap(161, 161, 161)
                        .addComponent(boton_graficoPastel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_graficoBarras)
                    .addComponent(boton_graficoPastel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_graficoBarrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_graficoBarrasMouseClicked
        // TODO add your handling code here:
        String[][] arrayProducto = new String[jTable1.getRowCount()][2];
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            arrayProducto[i][0] = jTable1.getValueAt(i, 0).toString();
            arrayProducto[i][1] = jTable1.getValueAt(i, 1).toString();
        }
        VentanaGraficoBarras graficoBarras = new VentanaGraficoBarras();
        graficoBarras.inicializarGrafica(arrayProducto, jTable1.getRowCount());
        graficoBarras.setVisible(true);
    }//GEN-LAST:event_boton_graficoBarrasMouseClicked

    private void boton_graficoPastelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_graficoPastelMouseClicked
        // TODO add your handling code here:
        String[][] arrayProducto = new String[jTable1.getRowCount()][2];
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            arrayProducto[i][0] = jTable1.getValueAt(i, 0).toString();
            arrayProducto[i][1] = jTable1.getValueAt(i, 1).toString();
        }
        
        VentanaGraficoPastel graficoPastel = new VentanaGraficoPastel();
        graficoPastel.iniciarGrafica(arrayProducto, jTable1.getRowCount());
        graficoPastel.setVisible(true);
    }//GEN-LAST:event_boton_graficoPastelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
    
        public void actualizarProducto(String nombreProducto, String votosProducto)
    {
        for (int i = 0; i < jTable1.getRowCount(); i++)
        {
            String nombreProductoActual = jTable1.getValueAt(i, 0).toString();
            if (nombreProductoActual == nombreProducto)
            {
                jTable1.setValueAt(votosProducto, i, 1);
                return;
            }
        }
    }
    
    
    
    class ButtonRenderer extends JButton implements TableCellRenderer 
    {
        public ButtonRenderer() 
        {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) 
        {
            setText((value == null) ? "Votar" : value.toString());
            return this;
        }
    }
    
    class ButtonEditor extends DefaultCellEditor 
    {
        private String label;
    
        public ButtonEditor(JCheckBox checkBox)
        {
            super(checkBox);
        }
        public Component getTableCellEditorComponent(JTable table, Object value,
                                        boolean isSelected, int row, int column) 
        {
            label = (value == null) ? "Votar" : value.toString();
            botonVotar.setText(label);
            return botonVotar;
        }
        public Object getCellEditorValue() 
        {
            return new String(label);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_graficoBarras;
    private javax.swing.JButton boton_graficoPastel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
