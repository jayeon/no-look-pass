package com.company;

import javax.swing.*;
import java.io.*;

public class Backups {
    //placeholder arrays until we connect with SQLite
    private static String[] usernames = {"Facebook","Google","YouTube"};
    private static String[] passwords = {"FacebookPass","GooglePass","YouTubePass"};

    //file where the entries will be saved
    private static String filepath = "backup.txt";

    public static void newBackup(){
        try {
            FileWriter fw = new FileWriter(filepath, false); //change false to true if you want to append rather than overwrite
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            //goes through each array value and prints it to backup.txt
            if (usernames.length == passwords.length) {
                for (int i = 0; i < usernames.length; i++) {
                    pw.println(usernames[i] + "," + passwords[i]);
                }
                pw.flush();
                pw.close();

                //dialog box saying that it either went through or failed. Might have to edit this for JavaFX??
                JOptionPane.showMessageDialog(null, "Backup created");
            }else{
                JOptionPane.showMessageDialog(null,"Number of username entries does not match number of password entries");
            }
        }
        catch(Exception E){
            JOptionPane.showMessageDialog(null, "Backup creation failed");
        }
    }

    /*
    need to look more into reading files, then I will add an import method
     */
}