/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojet.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javaprojet.model.bdd.DBconnexion;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Namko
 */
public class Accueil_2 extends javax.swing.JFrame {

    /**
     * Creates new form Accueil
     */
    public Accueil_2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneAdmin = new javax.swing.JTabbedPane();
        jPanelRech = new javax.swing.JPanel();
        jComboBoxReClasse = new javax.swing.JComboBox<>();
        jButtonReChoixClasse = new javax.swing.JButton();
        jButtonReChoixEtu = new javax.swing.JButton();
        jComboBoxReEtu = new javax.swing.JComboBox<>();
        jPanelGest = new javax.swing.JPanel();
        jComboBoxMatiere = new javax.swing.JComboBox<>();
        jComboBoxEtudiantMat = new javax.swing.JComboBox<>();
        jButtonOkMatiere = new javax.swing.JButton();
        jButtonChoixMatiere = new javax.swing.JButton();
        jPanelNotes = new javax.swing.JPanel();
        jPanelContentNotes = new javax.swing.JPanel();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTableNotes = new javax.swing.JTable();
        jButtonChoixLigne = new javax.swing.JButton();
        jLabelModifyNom = new javax.swing.JLabel();
        jTextFieldModifyNom = new javax.swing.JTextField();
        jLabelModifyMat = new javax.swing.JLabel();
        jTextFieldModifyMat = new javax.swing.JTextField();
        jLabelNoteMoyenne = new javax.swing.JLabel();
        jTextFieldModifyNote = new javax.swing.JTextField();
        jButtonNotesModifier = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jPanelTitreNotes = new javax.swing.JPanel();
        jLabelTitreNotes = new javax.swing.JLabel();
        jButtonAccueil = new javax.swing.JButton();
        jButtonAdmin = new javax.swing.JButton();
        jButtonAca = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);

        jComboBoxReClasse.setModel(new javax.swing.DefaultComboBoxModel<>());
        ResultSet resClasse=null;
        Statement stmt2=null;

        try{
            javaprojet.model.bdd.DBconnexion.connexionDB();
            stmt2= DBconnexion.getConn().createStatement();
            String ClassSelect="SELECT * FROM `classe`";
            System.out.println("DEBUG / USERLOGIN REQUEST"+ClassSelect);
            resClasse=stmt2.executeQuery(ClassSelect);
            while(resClasse.next()){
                jComboBoxReClasse.addItem(resClasse.getString("NomClasse"));
            }
        }
        catch (SQLException SQLe) {
            System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());

        }

        jButtonReChoixClasse.setText("Ok");

        jButtonReChoixEtu.setText("Choix");
        jButtonReChoixEtu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReChoixEtuActionPerformed(evt);
            }
        });

        jComboBoxReEtu.setModel(new javax.swing.DefaultComboBoxModel<>());

        javax.swing.GroupLayout jPanelRechLayout = new javax.swing.GroupLayout(jPanelRech);
        jPanelRech.setLayout(jPanelRechLayout);
        jPanelRechLayout.setHorizontalGroup(
            jPanelRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRechLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(jPanelRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRechLayout.createSequentialGroup()
                        .addComponent(jComboBoxReClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(jPanelRechLayout.createSequentialGroup()
                        .addComponent(jComboBoxReEtu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)))
                .addGroup(jPanelRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonReChoixClasse)
                    .addComponent(jButtonReChoixEtu))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        jPanelRechLayout.setVerticalGroup(
            jPanelRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRechLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanelRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxReClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReChoixClasse))
                .addGap(18, 18, 18)
                .addGroup(jPanelRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReChoixEtu)
                    .addComponent(jComboBoxReEtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(537, Short.MAX_VALUE))
        );

        jTabbedPaneAdmin.addTab("Recherche par classe", jPanelRech);

        jComboBoxMatiere.setModel(new javax.swing.DefaultComboBoxModel<>());
        ResultSet res=null;
        Statement stmt=null;
        int nbp = 0;
        try{
            javaprojet.model.bdd.DBconnexion.connexionDB();
            stmt= DBconnexion.getConn().createStatement();
            String ClassSelect="SELECT * FROM `matiere`";
            System.out.println("DEBUG / USERLOGIN REQUEST"+ClassSelect);
            res=stmt.executeQuery(ClassSelect);
            while(res.next()){
                jComboBoxMatiere.addItem(res.getString("nomMat"));
            }
            stmt.close();
        }
        catch (SQLException SQLe) {
            System.out.println("Probleme lors de la recherche dans la BDD "+SQLe.getMessage());

        }

        jComboBoxEtudiantMat.setModel(new javax.swing.DefaultComboBoxModel<>());

        jButtonOkMatiere.setText("OK");

        jButtonChoixMatiere.setText("Choix");

        javax.swing.GroupLayout jPanelGestLayout = new javax.swing.GroupLayout(jPanelGest);
        jPanelGest.setLayout(jPanelGestLayout);
        jPanelGestLayout.setHorizontalGroup(
            jPanelGestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanelGestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEtudiantMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelGestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonChoixMatiere)
                    .addComponent(jButtonOkMatiere))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanelGestLayout.setVerticalGroup(
            jPanelGestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelGestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOkMatiere))
                .addGroup(jPanelGestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxEtudiantMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGestLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButtonChoixMatiere)))
                .addContainerGap(564, Short.MAX_VALUE))
        );

        jTabbedPaneAdmin.addTab("Gestion par matière", jPanelGest);

        jPanelNotes.setBackground(new java.awt.Color(204, 204, 255));

        jPanelContentNotes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));

        jTableNotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneTable.setViewportView(jTableNotes);
        jTableNotes.setAutoCreateRowSorter(true);

        jButtonChoixLigne.setText("Valider Choix Ligne");

        jLabelModifyNom.setText("Nom : ");

        jLabelModifyMat.setText("Matière : ");

        jTextFieldModifyMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldModifyMatActionPerformed(evt);
            }
        });

        jLabelNoteMoyenne.setText("Moyenne : ");

        jButtonNotesModifier.setText("Modifier");

        jButtonRefresh.setText("Rafraichir le tableau");

        javax.swing.GroupLayout jPanelContentNotesLayout = new javax.swing.GroupLayout(jPanelContentNotes);
        jPanelContentNotes.setLayout(jPanelContentNotesLayout);
        jPanelContentNotesLayout.setHorizontalGroup(
            jPanelContentNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentNotesLayout.createSequentialGroup()
                .addGroup(jPanelContentNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentNotesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneTable))
                    .addGroup(jPanelContentNotesLayout.createSequentialGroup()
                        .addGroup(jPanelContentNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelContentNotesLayout.createSequentialGroup()
                                .addGap(344, 344, 344)
                                .addComponent(jButtonChoixLigne))
                            .addGroup(jPanelContentNotesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelModifyNom)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldModifyNom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabelModifyMat)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelContentNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelContentNotesLayout.createSequentialGroup()
                                        .addComponent(jButtonNotesModifier)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonRefresh))
                                    .addGroup(jPanelContentNotesLayout.createSequentialGroup()
                                        .addComponent(jTextFieldModifyMat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(101, 101, 101)
                                        .addComponent(jLabelNoteMoyenne)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldModifyNote, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelContentNotesLayout.setVerticalGroup(
            jPanelContentNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonChoixLigne)
                .addGap(18, 18, 18)
                .addGroup(jPanelContentNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModifyNom)
                    .addComponent(jTextFieldModifyNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelModifyMat)
                    .addComponent(jTextFieldModifyMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNoteMoyenne)
                    .addComponent(jTextFieldModifyNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelContentNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNotesModifier)
                    .addComponent(jButtonRefresh))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabelTitreNotes.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabelTitreNotes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitreNotes.setText("NOTES");

        javax.swing.GroupLayout jPanelTitreNotesLayout = new javax.swing.GroupLayout(jPanelTitreNotes);
        jPanelTitreNotes.setLayout(jPanelTitreNotesLayout);
        jPanelTitreNotesLayout.setHorizontalGroup(
            jPanelTitreNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitreNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitreNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTitreNotesLayout.setVerticalGroup(
            jPanelTitreNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitreNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitreNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelNotesLayout = new javax.swing.GroupLayout(jPanelNotes);
        jPanelNotes.setLayout(jPanelNotesLayout);
        jPanelNotesLayout.setHorizontalGroup(
            jPanelNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNotesLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jPanelTitreNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(jPanelNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelContentNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNotesLayout.setVerticalGroup(
            jPanelNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitreNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelContentNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneAdmin.addTab("Modification notes", jPanelNotes);

        jButtonAccueil.setText("Accueil");
        jButtonAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccueilActionPerformed(evt);
            }
        });

        jButtonAdmin.setText("Partie Administrative");

        jButtonAca.setText("Partie Académique");
        jButtonAca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaActionPerformed(evt);
            }
        });

        jLabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaprojet/view/logo-ex-7.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAccueil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jButtonAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPaneAdmin))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccueilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAccueilActionPerformed

    private void jButtonAcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAcaActionPerformed

    private void jButtonReChoixEtuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReChoixEtuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReChoixEtuActionPerformed

    private void jTextFieldModifyMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldModifyMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldModifyMatActionPerformed

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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Accueil_2().setVisible(true);
        });
    }

    public JButton getjButtonAca() {
        return jButtonAca;
    }

    public void setjButtonAca(JButton jButtonAca) {
        this.jButtonAca = jButtonAca;
    }

    public JButton getjButtonAccueil() {
        return jButtonAccueil;
    }

    public void setjButtonAccueil(JButton jButtonAccueil) {
        this.jButtonAccueil = jButtonAccueil;
    }

    public JButton getjButtonAdmin() {
        return jButtonAdmin;
    }

    public void setjButtonAdmin(JButton jButtonAdmin) {
        this.jButtonAdmin = jButtonAdmin;
    }

    public JLabel getjLabelLogo() {
        return jLabelLogo;
    }

    public void setjLabelLogo(JLabel jLabelLogo) {
        this.jLabelLogo = jLabelLogo;
    }


    public JLabel getjLabelTitreNotes() {
        return jLabelTitreNotes;
    }

    public void setjLabelTitreNotes(JLabel jLabelTitreNotes) {
        this.jLabelTitreNotes = jLabelTitreNotes;
    }

    public JPanel getjPanelContentNotes() {
        return jPanelContentNotes;
    }

    public void setjPanelContentNotes(JPanel jPanelContentNotes) {
        this.jPanelContentNotes = jPanelContentNotes;
    }

    public JPanel getjPanelGest() {
        return jPanelGest;
    }

    public void setjPanelGest(JPanel jPanelGest) {
        this.jPanelGest = jPanelGest;
    }

    public JPanel getjPanelNotes() {
        return jPanelNotes;
    }

    public void setjPanelNotes(JPanel jPanelNotes) {
        this.jPanelNotes = jPanelNotes;
    }

    public JPanel getjPanelRech() {
        return jPanelRech;
    }

    public void setjPanelRech(JPanel jPanelRech) {
        this.jPanelRech = jPanelRech;
    }

    public JPanel getjPanelTitreNotes() {
        return jPanelTitreNotes;
    }

    public void setjPanelTitreNotes(JPanel jPanelTitreNotes) {
        this.jPanelTitreNotes = jPanelTitreNotes;
    }

    public JTabbedPane getjTabbedPaneAdmin() {
        return jTabbedPaneAdmin;
    }

    public void setjTabbedPaneAdmin(JTabbedPane jTabbedPaneAdmin) {
        this.jTabbedPaneAdmin = jTabbedPaneAdmin;
    }

    public JButton getjButtonChoixMatiere() {
        return jButtonChoixMatiere;
    }

    public void setjButtonChoixMatiere(JButton jButtonChoixMatiere) {
        this.jButtonChoixMatiere = jButtonChoixMatiere;
    }

    public JButton getjButtonOkMatiere() {
        return jButtonOkMatiere;
    }

    public void setjButtonOkMatiere(JButton jButtonOkMatiere) {
        this.jButtonOkMatiere = jButtonOkMatiere;
    }

    public JComboBox<String> getjComboBoxEtudiantMat() {
        return jComboBoxEtudiantMat;
    }

    public void setjComboBoxEtudiantMat(JComboBox<String> jComboBoxEtudiantMat) {
        this.jComboBoxEtudiantMat = jComboBoxEtudiantMat;
    }

    public JComboBox<String> getjComboBoxMatiere() {
        return jComboBoxMatiere;
    }

    public void setjComboBoxMatiere(JComboBox<String> jComboBoxMatiere) {
        this.jComboBoxMatiere = jComboBoxMatiere;
    }

    public JScrollPane getjScrollPaneTable() {
        return jScrollPaneTable;
    }

    public void setjScrollPaneTable(JScrollPane jScrollPaneTable) {
        this.jScrollPaneTable = jScrollPaneTable;
    }

    public JTable getjTableNotes() {
        return jTableNotes;
    }

    public void setjTableNotes(JTable jTableNotes) {
        this.jTableNotes = jTableNotes;
    }

    public JComboBox<String> getjComboBoxReClasse() {
        return jComboBoxReClasse;
    }

    public void setjComboBoxReClasse(JComboBox<String> jComboBoxReClasse) {
        this.jComboBoxReClasse = jComboBoxReClasse;
    }

    public JComboBox<String> getjComboBoxReEtu() {
        return jComboBoxReEtu;
    }

    public void setjComboBoxReEtu(JComboBox<String> jComboBoxReEtu) {
        this.jComboBoxReEtu = jComboBoxReEtu;
    }

    public JButton getjButtonReChoixClasse() {
        return jButtonReChoixClasse;
    }

    public void setjButtonReChoixClasse(JButton jButtonReChoixClasse) {
        this.jButtonReChoixClasse = jButtonReChoixClasse;
    }

    public JButton getjButtonReChoixEtu() {
        return jButtonReChoixEtu;
    }

    public void setjButtonReChoixEtu(JButton jButtonReChoixEtu) {
        this.jButtonReChoixEtu = jButtonReChoixEtu;
    }

    public JButton getjButtonChoixLigne() {
        return jButtonChoixLigne;
    }

    public void setjButtonChoixLigne(JButton jButtonChoixLigne) {
        this.jButtonChoixLigne = jButtonChoixLigne;
    }

    public JButton getjButtonNotesModifier() {
        return jButtonNotesModifier;
    }

    public void setjButtonNotesModifier(JButton jButtonNotesModifier) {
        this.jButtonNotesModifier = jButtonNotesModifier;
    }

    public JLabel getjLabelModifyMat() {
        return jLabelModifyMat;
    }

    public void setjLabelModifyMat(JLabel jLabelModifyMat) {
        this.jLabelModifyMat = jLabelModifyMat;
    }

    public JLabel getjLabelModifyNom() {
        return jLabelModifyNom;
    }

    public void setjLabelModifyNom(JLabel jLabelModifyNom) {
        this.jLabelModifyNom = jLabelModifyNom;
    }

    public JLabel getjLabelNoteMoyenne() {
        return jLabelNoteMoyenne;
    }

    public void setjLabelNoteMoyenne(JLabel jLabelNoteMoyenne) {
        this.jLabelNoteMoyenne = jLabelNoteMoyenne;
    }

    public JTextField getjTextFieldModifyMat() {
        return jTextFieldModifyMat;
    }

    public void setjTextFieldModifyMat(JTextField jTextFieldModifyMat) {
        this.jTextFieldModifyMat = jTextFieldModifyMat;
    }

    public JTextField getjTextFieldModifyNom() {
        return jTextFieldModifyNom;
    }

    public void setjTextFieldModifyNom(JTextField jTextFieldModifyNom) {
        this.jTextFieldModifyNom = jTextFieldModifyNom;
    }

    public JTextField getjTextFieldModifyNote() {
        return jTextFieldModifyNote;
    }

    public void setjTextFieldModifyNote(JTextField jTextFieldModifyNote) {
        this.jTextFieldModifyNote = jTextFieldModifyNote;
    }

    public JButton getjButtonRefresh() {
        return jButtonRefresh;
    }

    public void setjButtonRefresh(JButton jButtonRefresh) {
        this.jButtonRefresh = jButtonRefresh;
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAca;
    private javax.swing.JButton jButtonAccueil;
    private javax.swing.JButton jButtonAdmin;
    private javax.swing.JButton jButtonChoixLigne;
    private javax.swing.JButton jButtonChoixMatiere;
    private javax.swing.JButton jButtonNotesModifier;
    private javax.swing.JButton jButtonOkMatiere;
    private javax.swing.JButton jButtonReChoixClasse;
    private javax.swing.JButton jButtonReChoixEtu;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JComboBox<String> jComboBoxEtudiantMat;
    private javax.swing.JComboBox<String> jComboBoxMatiere;
    private javax.swing.JComboBox<String> jComboBoxReClasse;
    private javax.swing.JComboBox<String> jComboBoxReEtu;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelModifyMat;
    private javax.swing.JLabel jLabelModifyNom;
    private javax.swing.JLabel jLabelNoteMoyenne;
    private javax.swing.JLabel jLabelTitreNotes;
    private javax.swing.JPanel jPanelContentNotes;
    private javax.swing.JPanel jPanelGest;
    private javax.swing.JPanel jPanelNotes;
    private javax.swing.JPanel jPanelRech;
    private javax.swing.JPanel jPanelTitreNotes;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JTabbedPane jTabbedPaneAdmin;
    private javax.swing.JTable jTableNotes;
    private javax.swing.JTextField jTextFieldModifyMat;
    private javax.swing.JTextField jTextFieldModifyNom;
    private javax.swing.JTextField jTextFieldModifyNote;
    // End of variables declaration//GEN-END:variables
}
