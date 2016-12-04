package networking.project;

import java.nio.ByteBuffer;
/**
 * Pieces need to be received from the input stream.
 * This class saves the piece in bytes based on its piece ID.
 * 
 * @author Cole
 */
public class Piece extends Message{
    
    private final int pieceID;
    private final byte[] pieceInBytes;
    
    public Piece ()
    {
        byte[] Payload = getPayload();
        byte[] pieceIDInBytes = new byte[4];
        System.arraycopy(Payload, 0, pieceIDInBytes, 0, pieceIDInBytes.length);
        this.pieceID = ByteBuffer.wrap(pieceIDInBytes).getInt();
        
        this.pieceInBytes = new byte[this.getLength()-4];
        for(int i = 0; i < pieceInBytes.length; i++)
        {
            this.pieceInBytes[i] = Payload[i+4];
        }
    }
    public Piece (int ID, byte[] piece)
    {
        this.pieceID = ID;
        this.pieceInBytes= piece;
        byte[] pieceToSend = new byte[this.pieceInBytes.length+4];
        byte[] pieceIDinBytes = ByteBuffer.allocate(4).putInt(this.pieceID).array();
        System.arraycopy(pieceIDinBytes, 0, pieceToSend, 0, 4);
        System.arraycopy(this.pieceInBytes, 0, pieceToSend, 4, this.pieceInBytes.length);
        this.setPayload(pieceToSend);
        this.setLength(piece.length+4);
        this.setType(7);
    }
    public byte [] getPieceInBytes()
    {
        return pieceInBytes;
    }
    public int getPieceID()
    {
        return pieceID;
    }
    public byte [] getPieceInBytesNoID()
    {
        byte[] b = new byte[pieceInBytes.length-4];
        for (int i = 0; i < b.length; i++)
        {
            b[i] = pieceInBytes[i+4];
        }
        return b;
    }
}
