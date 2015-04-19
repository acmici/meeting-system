
package com.acmici.meeting.ui;

import com.acmici.meeting.server.MeetingServer;

import java.awt.Toolkit;
import java.util.Timer;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author sukha
 */
public class OngoingFrame extends javax.swing.JFrame {

    /**
     * Creates new form OngoingFrame
     */
    private MeetingServer meetingServer;
    final private Date meetingStartTime;
    final private SimpleDateFormat meetingDateFormat = new SimpleDateFormat("HH:mm:ss");;
    final private SimpleDateFormat filePathFormat = new SimpleDateFormat("yy-MM-dd");
    final private String filePath = "D:\\test\\";
    public class MeetingTimerTask extends java.util.TimerTask {  
        //@Override  
        public void run() {
            Date currentTime = new Date();
            long diff = currentTime.getTime()-meetingStartTime.getTime();
            long hour = diff / (60*60*1000);
            long min = diff / (60*1000) - hour*60;
            long sec = diff / 1000 - hour*60*60 - min*60;
            String outputString = Long.toString(hour) + "小时" + Long.toString(min) + "分" + Long.toString(sec) + "秒";
            timeRefreshLabel.setText(outputString);
        }  
    }
    public OngoingFrame(MeetingServer server) {
        meetingServer = server;
        initComponents();
        int w = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int h = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        this.setLocation(w, h);
        
        //初始化会议主题、与会人员、记录员信息
        topic.setText(meetingServer.getTopic());
        participants.setText(meetingServer.getMembers());
        recorder.setText(meetingServer.getRecorder());
        
        //初始化会议开始时间信息
        meetingStartTime = new Date();
        startTime.setText(meetingDateFormat.format(meetingStartTime));
        Timer meetingTimer = new Timer();
        meetingTimer.schedule(new MeetingTimerTask(), 0 ,1000); 
        
        //System.out.println("ongoing...");
        this.backupFiles();
    }
    
    public void refreshServer(MeetingServer server) {
        //更新服务器信息
        meetingServer = server;
        participants.setText(meetingServer.getMembers());
        recorder.setText(meetingServer.getRecorder());
        
        this.backupFiles();
    }
    
    private void backupFiles() {
        //备份会议文件，文件夹命名方式为日期+会议主题
        FileHandler fileHandler = new FileHandler();
        if (fileHandler.copyFolder(meetingServer.getFile_path(), 
                filePath + filePathFormat.format(meetingStartTime) + meetingServer.getTopic())) {
            System.out.println("复制成功。");;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateButton = new javax.swing.JButton();
        readButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();
        topicLabel = new javax.swing.JLabel();
        participantsLabel = new javax.swing.JLabel();
        recorderLabel = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        ongoingTimeLabel = new javax.swing.JLabel();
        timeRefreshLabel = new javax.swing.JLabel();
        topic = new javax.swing.JLabel();
        participants = new javax.swing.JLabel();
        recorder = new javax.swing.JLabel();
        startTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("会议进行中...");
        setBounds(new java.awt.Rectangle(0, 0, 350, 260));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        updateButton.setText("修改会议信息");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        readButton.setText("查询历史会议");
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        endButton.setText("结束会议");
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        topicLabel.setText("会议主题：");

        participantsLabel.setText("与会人员：");

        recorderLabel.setText("记 录 员：");

        startTimeLabel.setText("开始时间：");

        ongoingTimeLabel.setText("进行时间：");

        timeRefreshLabel.setText("时间");

        topic.setText("主题");

        participants.setText("人员");

        recorder.setText("记录员");

        startTime.setText("开始时间");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(readButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(topicLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(topic))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(participantsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(participants))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(recorderLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recorder))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startTime))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ongoingTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeRefreshLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(topicLabel)
                    .addComponent(topic))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(participantsLabel)
                    .addComponent(participants))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recorderLabel)
                    .addComponent(recorder))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeLabel)
                    .addComponent(startTime))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ongoingTimeLabel)
                    .addComponent(timeRefreshLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(readButton)
                    .addComponent(endButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        UpdateDialog update_dialog = new UpdateDialog(this, true, meetingServer);
        update_dialog.setVisible(true);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
        // TODO add your handling code here:
        MeetingEndDialog meeting_end_dialog = new MeetingEndDialog(this, true);
        meeting_end_dialog.setVisible(true);
    }//GEN-LAST:event_endButtonActionPerformed

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed
        // TODO add your handling code here:
        HistroyFrame histroy_frame = new HistroyFrame();
        histroy_frame.setVisible(true);
    }//GEN-LAST:event_readButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MeetingEndDialog meeting_end_dialog = new MeetingEndDialog(this, true);
        meeting_end_dialog.setVisible(true);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endButton;
    private javax.swing.JLabel ongoingTimeLabel;
    private javax.swing.JLabel participants;
    private javax.swing.JLabel participantsLabel;
    private javax.swing.JButton readButton;
    private javax.swing.JLabel recorder;
    private javax.swing.JLabel recorderLabel;
    private javax.swing.JLabel startTime;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JLabel timeRefreshLabel;
    private javax.swing.JLabel topic;
    private javax.swing.JLabel topicLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
