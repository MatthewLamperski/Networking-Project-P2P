/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking.project;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author sarah
 */
public class UnChoke extends message{
    
    public void UnChoke(){
        byte[] b = {(byte)0x00};
        this.setLength(5);
        this.setType(1);
        this.setPayload(b);
        
    }
}
