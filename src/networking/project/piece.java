package networking.project;

/**
 * Pieces need to be received from the input stream.
 * This class saves the piece in bytes based on its piece ID.
 * 
 * @author Cole
 */
public class piece {
    
    private final int pieceID;
    private final byte[] pieceInBytes;
    
    public piece (int ID, byte[] piece)
    {
        this.pieceID = ID;
        this.pieceInBytes= piece;
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
