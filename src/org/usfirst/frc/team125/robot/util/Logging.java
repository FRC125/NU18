package org.usfirst.frc.team125.robot.util;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Timer.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.*;
import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Vector;

public class Logging {

    String fileName;
    String basePath = "/home/lvuser/logs/";
    ArrayList<String> logNames;
    ArrayList<String> logEntries;

    private PrintWriter logWriter;

    protected File logFile = null;



    private class Logger implements Runnable {
        int j = 0;

        @Override
        public void run() {
            double lastWriteTime = Timer.getFPGATimestamp();
            while (true) {
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SmartDashboard.putNumber("j counter", j);
                j++;
            }
        }
    }

    public Logging(String fileName, ArrayList<String> logNames){
        this.fileName = new String(basePath);
        this.logNames = new ArrayList<>(logNames);
        this.logEntries = new ArrayList<>(logNames);
        //All initialization goes here
        this.logNames.add(0, "timestamp");

        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.logWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

            StringBuffer line = new StringBuffer();
            for (int i = 0; i < this.logNames.size(); i++) {
                line.append(this.logNames.get(i));
            }
            this.logWriter.write(line.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(String key, String val){
        System.out.println(logEntries.size());

        for(String temp : logNames){
            if(temp.equals(key)){
                int i = logNames.indexOf(temp);
                logEntries.add(i, val);
            }
        }
    }

    public void updateLogging(){

        StringBuffer line = new StringBuffer();
        this.logEntries.add(0, Double.toString(Timer.getFPGATimestamp()));
        for (int i = 0; i < this.logEntries.size(); i++) {
            line.append(this.logEntries.get(i));
            line.append(",");
        }
        line.append("\n");
        this.logWriter.write(line.toString());
        this.logWriter.flush();

        this.logEntries = new ArrayList<>(logNames);
    }

    public void endLogging(){
        this.logWriter.close();
    }

}
