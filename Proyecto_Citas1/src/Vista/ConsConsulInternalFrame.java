/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class ConsConsulInternalFrame extends javax.swing.JInternalFrame {

    public Controlador.GestorConsultorioControl gestorconsultorioControl;
    private DefaultTableModel tabla;
    public ConsConsulInternalFrame() {
        initComponents();
        gestorconsultorioControl =new Controlador.GestorConsultorioControl(this);
        String titulosTabla[]={"Codigo","Nombres"};     
        tabla=new DefaultTableModel(null, titulosTabla);
        jtConsultorio.setModel(tabla);
        btnBusConsulta.addActionListener(gestorconsultorioControl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrConsulta = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jrNomConsulta = new javax.swing.JRadioButton();
        jrCodiConsulta = new javax.swing.JRadioButton();
        txtConValor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBusConsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultorio = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setForeground(java.awt.Color.darkGray);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar consultorio");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btgrConsulta.add(jrNomConsulta);
        jrNomConsulta.setText("Nombre Consultorio");
        jrNomConsulta.setOpaque(false);
        jPanel1.add(jrNomConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        btgrConsulta.add(jrCodiConsulta);
        jrCodiConsulta.setText("Codigo consultorio");
        jrCodiConsulta.setOpaque(false);
        jPanel1.add(jrCodiConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));
        jPanel1.add(txtConValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 80, -1));

        jLabel2.setText("Valor a buscar:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        btnBusConsulta.setText("Buscar");
        btnBusConsulta.setOpaque(false);
        jPanel1.add(btnBusConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        jtConsultorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtConsultorio);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_citas1/primer-plano-medicina-empaquetada-blister-estetoscopio-bloc-notas-espiral-sobre-fondo-azul_23-2148214025.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 330));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgrConsulta;
    public javax.swing.JButton btnBusConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton jrCodiConsulta;
    public javax.swing.JRadioButton jrNomConsulta;
    public javax.swing.JTable jtConsultorio;
    public javax.swing.JTextField txtConValor;
    // End of variables declaration//GEN-END:variables
}
