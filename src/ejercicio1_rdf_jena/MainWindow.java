/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1_rdf_jena;

import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.apache.jena.atlas.logging.LogCtl;
import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        LogCtl.setCmdLogging();
        initComponents();
        tweetModel = new TweetModel();
        twitter = new TwitterFactory().getInstance();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outputFileTypeButtonGroup = new javax.swing.ButtonGroup();
        hashtagLabel = new javax.swing.JLabel();
        hashtagTextField = new javax.swing.JTextField();
        topicLabel = new javax.swing.JLabel();
        topicTextField = new javax.swing.JTextField();
        outputOptions = new javax.swing.JPanel();
        outputFileOptionLabel = new javax.swing.JLabel();
        turtleRadioButton = new javax.swing.JRadioButton();
        xmlRadioButton = new javax.swing.JRadioButton();
        exportButton = new javax.swing.JButton();
        numberOfTweetsLabel = new javax.swing.JLabel();
        numberOfTweetsTextField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        informationLabelMax200 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        searchTweetsButton = new javax.swing.JButton();
        resultsLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tweetsResultTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 725));
        setResizable(false);

        hashtagLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        hashtagLabel.setText("Hashtag:");

        hashtagTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hashtagTextFieldActionPerformed(evt);
            }
        });

        topicLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        topicLabel.setText("Tema:");

        topicTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topicTextFieldActionPerformed(evt);
            }
        });

        outputOptions.setPreferredSize(new java.awt.Dimension(200, 677));

        outputFileOptionLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        outputFileOptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputFileOptionLabel.setText("Tipo de fichero de salida");
        outputFileOptionLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        outputFileTypeButtonGroup.add(turtleRadioButton);
        turtleRadioButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        turtleRadioButton.setText("Turtle");
        turtleRadioButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        outputFileTypeButtonGroup.add(xmlRadioButton);
        xmlRadioButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        xmlRadioButton.setText("XML");
        xmlRadioButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        exportButton.setText("Exportar");

        numberOfTweetsLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        numberOfTweetsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberOfTweetsLabel.setText("Número de tweets a descargar");
        numberOfTweetsLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        numberOfTweetsTextField.setToolTipText("");
        numberOfTweetsTextField.setName(""); // NOI18N
        numberOfTweetsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfTweetsTextFieldActionPerformed(evt);
            }
        });

        informationLabelMax200.setText("(Máximo 200)");

        javax.swing.GroupLayout outputOptionsLayout = new javax.swing.GroupLayout(outputOptions);
        outputOptions.setLayout(outputOptionsLayout);
        outputOptionsLayout.setHorizontalGroup(
            outputOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputOptionsLayout.createSequentialGroup()
                .addGroup(outputOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exportButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(outputOptionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(outputFileOptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator3)
                    .addGroup(outputOptionsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(outputOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(turtleRadioButton)
                            .addComponent(xmlRadioButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(outputOptionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(numberOfTweetsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                    .addComponent(numberOfTweetsTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(outputOptionsLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(informationLabelMax200)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        outputOptionsLayout.setVerticalGroup(
            outputOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputOptionsLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(outputFileOptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(turtleRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xmlRadioButton)
                .addGap(18, 18, 18)
                .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(numberOfTweetsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationLabelMax200)
                .addGap(18, 18, 18)
                .addComponent(numberOfTweetsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        searchTweetsButton.setText("Buscar");
        searchTweetsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTweetsButtonActionPerformed(evt);
            }
        });

        resultsLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        resultsLabel.setText("Resultados:");

        tweetsResultTextArea.setColumns(20);
        tweetsResultTextArea.setRows(5);
        tweetsResultTextArea.setEnabled(false);
        jScrollPane1.setViewportView(tweetsResultTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(resultsLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hashtagLabel)
                                .addComponent(topicLabel))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(topicTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hashtagTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(searchTweetsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(outputOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(hashtagLabel)
                                            .addComponent(hashtagTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(topicLabel)
                                            .addComponent(topicTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(searchTweetsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(resultsLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hashtagTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hashtagTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hashtagTextFieldActionPerformed

    private void topicTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topicTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topicTextFieldActionPerformed

    private void searchTweetsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTweetsButtonActionPerformed
        try {
            final int numberOfTweets = Integer.parseInt(numberOfTweetsTextField.getText());
            final String hashtag = hashtagTextField.getText();
            final String topic = topicTextField.getText();
            if (checkLimitOfTweets(numberOfTweets) && checkHashtag(hashtag) && checkTopic(topic))
                searchTweets(hashtag, topic, numberOfTweets);
            
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                                          "Debes introducir un número entero de tweets a descargar",
                                          "Número de tweets a descargar",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_searchTweetsButtonActionPerformed

    private void numberOfTweetsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfTweetsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfTweetsTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportButton;
    private javax.swing.JLabel hashtagLabel;
    private javax.swing.JTextField hashtagTextField;
    private javax.swing.JLabel informationLabelMax200;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel numberOfTweetsLabel;
    private javax.swing.JTextField numberOfTweetsTextField;
    private javax.swing.JLabel outputFileOptionLabel;
    private javax.swing.ButtonGroup outputFileTypeButtonGroup;
    private javax.swing.JPanel outputOptions;
    private javax.swing.JLabel resultsLabel;
    private javax.swing.JButton searchTweetsButton;
    private javax.swing.JLabel topicLabel;
    private javax.swing.JTextField topicTextField;
    private javax.swing.JRadioButton turtleRadioButton;
    private javax.swing.JTextArea tweetsResultTextArea;
    private javax.swing.JRadioButton xmlRadioButton;
    // End of variables declaration//GEN-END:variables
    private final TweetModel tweetModel;
    private final Twitter twitter;

    private boolean checkLimitOfTweets(int numberOfTweets) {
        if (numberOfTweets > 200 || numberOfTweets < 1) {
            JOptionPane.showMessageDialog(null,
                                          "El número de tweets a descargar debe estar entre 1 y 200",
                                          "Número de tweets a descargar",
                                          JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean checkHashtag(String hashtag) {
        if (!hashtag.startsWith("#") || hashtag.length() < 2 || hashtag.contains(" ")) {
            JOptionPane.showMessageDialog(null,
                                          "El hashtag debe empezar por #, debe contener al menos un carácter más y no contener espacios",
                                          "Hashtag",
                                          JOptionPane.INFORMATION_MESSAGE);
            return false;            
        }
        return true;
    }
    
    private boolean checkTopic(String topic) {
        if (topic.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                                          "El tema no puede estar vacío",
                                          "Tema",
                                          JOptionPane.INFORMATION_MESSAGE);
            return false;            
        }
        return true;
    }

    private void searchTweets(String hashtag, String topic, int numberOfTweets) {
        try {
            Query query = new Query(hashtag);
            query.setCount(numberOfTweets);
            List<Status> tweets_result = twitter.search(query).getTweets();
            String tweetsResult = "Se han encontrado " + tweets_result.size() + " tweets \n\n";
            for (Status tweet : tweets_result) {
                Tweet tw = new Tweet(tweet.getId(),
                                     tweet.getInReplyToStatusId(),
                                     new User(tweet.getUser().getName(), tweet.getUser().getLocation()),
                                     new Language(tweet.getLang(), get_lenguage(tweet.getLang())),
                                     tweet.getText(),
                                     topic,
                                     hashtag,
                                     tweet.getCreatedAt());
                tweetsResult += ("User: " + tw.getUser().getName() + "\n" +
                                              "Tweet: \n" + tw.getText() + "\n\n\n");
                tweetModel.addResource(twitter, tw);
            }
            tweetsResultTextArea.setText(tweetsResult);
        } catch (TwitterException te) {
            System.out.println("Failed to search tweets: " + te.getMessage());
            JOptionPane.showMessageDialog(null,
                                          "No se ha encontrado ningún tweet.",
                                          "Búsqueda",
                                          JOptionPane.INFORMATION_MESSAGE);            
            //System.exit(-1);
        }
    }
    
    private static String get_lenguage(String iso3){
        for (Locale country : Locale.getAvailableLocales()) {
            if(country.toLanguageTag().equals(iso3))
                return country.getDisplayLanguage();
        }
        return "";
    }

}
