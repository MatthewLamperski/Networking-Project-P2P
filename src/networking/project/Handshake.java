/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.project;

import java.net.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

/**
 *
 * @author sarah
 */
public class Handshake {
    
    private int peerID;
    
    public void setPeerID(int ID){
        peerID = ID;
    }
    
    public int getPeerID(){
        return peerID;
    }
    
    public void readHandshake(Socket to_em) throws IOException{
        Scanner reader = new Scanner(to_em.getInputStream());
        // Ths reads next token. Might need to read next line, or read some pattern.
        String msg = reader.next();
        String header = msg.substring(0, 18);
        String zeroes = msg.substring(18, 28);
        String peerIDString = msg.substring(28, 32);
        int peerIDInt = Integer.parseInt(peerIDString);
        
        if((header.compareTo("P2PFILESHARINGPROJ") == 1) && (zeroes.compareTo("0000000000")) == 1){
            // Assign peer ID
            peerID = peerIDInt;
        }
        else{
            // Wrong header or Handshake message format. Ignore message
        }
    }
    
    public void sendHandshake(Socket to_em) throws IOException{
        ObjectOutputStream writer = new ObjectOutputStream(to_em.getOutputStream());
        String peerIDString = Integer.toString(peerID);
        if(peerIDString.length() < 4){
            String zeroes = "";
            for(int i = 0; i < (4-peerIDString.length()); i+=1){
                zeroes = zeroes + '0';
            }
            peerIDString = zeroes + peerIDString;
        }
        String msg = "P2PFILESHARINGPROJ" + "0000000000" + peerIDString;
        
        writer.writeObject(msg);
        writer.flush();
        System.out.println(msg);
    }
    
}
