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
public class Request extends message{
    
    public void Request(byte[] indexfield){
        this.setLength(9);
        this.setType(4);
        this.setPayload(indexfield);
        
    }
}
