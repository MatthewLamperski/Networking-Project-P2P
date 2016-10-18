package networking.project;

import java.nio.ByteBuffer;
/**
 * Pieces need to be received from the input stream.
 * This class saves the piece in bytes based on its piece ID.
 * 
 * @author Cole
 */
public class piece extends message{
    
    private final int pieceID;
    private final byte[] pieceInBytes;
    
    public piece ()
    {
        byte[] Payload = getPayload();
        byte[] pieceIDInBytes = new byte[4];
        for(int i = 0; i < pieceIDInBytes.length; i++)
        {
            pieceIDInBytes[i] = Payload[i];
        }
        this.pieceID = ByteBuffer.wrap(pieceIDInBytes).getInt();
        
        this.pieceInBytes = new byte[this.getLength()-4];
        for(int i = 0; i < pieceInBytes.length; i++)
        {
            this.pieceInBytes[i] = Payload[i+4];
        }
    }
    public piece (int ID, byte[] piece)
    {
        this.pieceID = ID;
        this.pieceInBytes= piece;
    }
    public byte[] writePiece()
    {
        byte[] pieceToSend = new byte[pieceInBytes.length+4];
        byte[] pieceIDinBytes = ByteBuffer.allocate(4).putInt(pieceID).array();
                
        for(int i = 0; i < 4; i++)
        {
            pieceToSend[i] = pieceIDinBytes[i];
        }
        for(int i = 0; i < pieceInBytes.length; i++)
        {
            pieceToSend[i+4] = pieceInBytes[i];
        }
        
        return pieceToSend;
    }
    public byte [] getPieceInBytes()
    {
        return pieceInBytes;
    }
    public int getPieceID()
    {
        return pieceID;
    }
}
