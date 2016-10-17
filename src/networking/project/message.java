package networking.project;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class message {
    
    /*After handshaking, each peer can send a stream of actual messages. 
    An actual message consists of 4-byte message length field, 
    1-byte message type field, and a message payload with variable size. 
    The 4-byte message length specifies the message length in bytes. 
    It does not include the length of the message length field itself.
    The 1-byte message type field specifies the type of the message.
    There are eight types of messages.*/   
    
    //message structure
    private int length;
    private int type;
    private byte[] payload;
    
    //message type
    final static int choke = 0;
    final static int unchoke = 1;
    final static int interested = 2;
    final static int not_interested = 3;
    final static int have = 4;
    final static int bitfield = 5;
    final static int request = 6;
    final static int piece = 7;
    
    //Get/Set Length
    public int getLength()
    {
        return length;
    }
    public void setLength(int l)
    {
        this.length = l;
    }
    
    //Get/Set Type
    public int getType()
    {
        return type;
    }
    public void setType(int t)
    {
        this.type = t;
    }
    
    //Get/Set Payload    
    public byte[] getPayload()
    {
        return payload;
    }
    public void setPayload(byte[] p)
    {
        this.payload = p;
    }
    
    //message send
    public void writeMessage(Socket to_em) throws IOException
    {
        //set length
        if(payload == null) //message with no payload
        {
            length = 0;
        }
        else                //message with payload
        {
            length = payload.length;
        }
        
                            //message to send
        OutputStream output = to_em.getOutputStream();
        output.write(ByteBuffer.allocate(4).putInt(length).array()); //*****check byte conversion******
        output.write(ByteBuffer.allocate(1).putInt(type).array()); //*****check byte conversion******
        
        if(payload != null) //message has payload
        {
            output.write(payload);
        }
        output.flush();
    
    }
    
    //message receive 
    public void readMessage(Socket to_em) throws IOException
    {
        //4 bytes length, 1 byte type, variable byte message
        
        byte[] lengthInBytes = new byte[4];
        byte[] typeInBytes = new byte[4];
        int bytes = 0;
        int totalBytes = 0;
        
        InputStream input = to_em.getInputStream();
        
        //Read Length
        while(totalBytes < 4) //get the first 4 bytes without error
        {
            bytes = input.read(lengthInBytes, totalBytes, 4 - totalBytes);
            totalBytes += bytes; 
        }
        length = ByteBuffer.wrap(lengthInBytes).getInt();
        //debug
        System.out.println("Message length:" + length);
        
        //Read Type
        totalBytes=0; //Reinitialize byte array position
        bytes = 0; //Reinitialize byte read num
        while(totalBytes < 1) //get the next byte without error
        {
            bytes = input.read(typeInBytes, totalBytes, 1 - totalBytes);
            totalBytes += bytes; 
        }
        type = ByteBuffer.wrap(typeInBytes).getInt();
        //debug
        System.out.println("Message type:" + type);
        
        //Read Payload
        if (length > 0) //payload exists, make payload byte array
        {
            payload = new byte[length];
            totalBytes=0; //Reinitialize byte array position
            bytes = 0; //Reinitialize byte read num
            
            while(totalBytes < length) //get the next bytes without error
                {
                bytes = input.read(payload, totalBytes, length - totalBytes);
                totalBytes += bytes; 
                } 
        }
        else //no payload
        {
            payload = null;
        }
    } 
}
