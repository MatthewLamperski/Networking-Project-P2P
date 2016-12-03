/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.project;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author sarah
 */
public class Log {
    
    
    public static void TCPConnection(int peer_ID1, int peer_ID2) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " makes a connection to Peer " + peer_ID2 + ".\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
    public static void ChangePreferredNeighbors(int peer_ID1, int[] peer_IDs) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " has the preferred neighbors ";
        for (int i = 0; i < peer_IDs.length; i++)
        {
            if(i == 0)
            {
                thisLog = thisLog + peer_IDs[i];
            }
            else
            {
                thisLog = thisLog + ", " + peer_IDs[i];
            }
        }
        thisLog = thisLog + ".\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
    public static void OptimisticallyUnchoked(int peer_ID1, int peer_ID2) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " has the optimistically unchoked neighbor " + peer_ID2 + ".\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
    public static void Unchoked(int peer_ID1, int peer_ID2) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " is unchoked by " + peer_ID2 + ".\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
    public static void Choked(int peer_ID1, int peer_ID2) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " is choked by " + peer_ID2 + ".\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
    public static void Have(int peer_ID1, int peer_ID2, int pieceIndex) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " received the ‘have’ message from " + peer_ID2 + " for the piece " + pieceIndex + ".\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
    public static void Interested(int peer_ID1, int peer_ID2) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " received the ‘interested’ message from " + peer_ID2 + ".\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
    public static void NotInterested(int peer_ID1, int peer_ID2) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " received the ‘not interested’ message from " + peer_ID2 + ".\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
    public static void Downloading(int peer_ID1, int peer_ID2, int pieceIndex, int numPieces) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " has downloaded the piece " + pieceIndex +  " from " + peer_ID2 + ". Now the number of pieces it has is " + numPieces + ".\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
    public static void Downloaded(int peer_ID1) throws IOException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println( sdf.format(cal.getTime()) );
        
        String thisFile = "log_peer_" + peer_ID1 + ".log";
        String thisLog = sdf.format(cal.getTime()) + ": Peer " + peer_ID1 + " has downloaded the complete file.\n";
        
        
        FileWriter fw = new FileWriter(thisFile,true); //the true will append the new data
        fw.write(thisLog);//appends the string to the file
        fw.close();
        
    }
}
