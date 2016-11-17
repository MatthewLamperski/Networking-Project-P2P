package networking.project;

import java.nio.ByteBuffer;
/*
 *
 * @author sarah and cole
 */
public class Have extends Message{
    
    private final int pieceID;
    private final byte[] requestPayload;
    
    public Have(int pieceID)
    {
        this.pieceID = pieceID;
        //this.setLength(4);
        this.setType(4);
        requestPayload = ByteBuffer.allocate(4).putInt(this.pieceID).array();
        this.setPayload(requestPayload);
    }
    public Have()
    {
        this.requestPayload = new byte[4];
        System.arraycopy(this.getPayload(), 0, this.requestPayload, 0, this.requestPayload.length);
        this.pieceID = ByteBuffer.wrap(requestPayload).getInt();
    }
    public byte [] getRequestPayload()
    {
        return requestPayload;
    }
    public int getPieceID()
    {
        return pieceID;
    }
}
