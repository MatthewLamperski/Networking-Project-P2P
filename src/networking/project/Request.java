package networking.project;

import java.nio.ByteBuffer;
/*
 *
 * ‘request’ messages have a payload which consists of a 4-byte piece index field. Note
 * that ‘request’ message payload defined here is different from that of BitTorrent. We
 * don’t divide a piece into smaller subpieces.
 * 
 * @author sarah and cole
 */
public class Request extends Message{
    
    private final int pieceID;
    private final byte[] requestPayload;
    
    public Request(int pieceID)
    {
        this.pieceID = pieceID;
        //this.setLength(4);
        this.setType(6);
        requestPayload = ByteBuffer.allocate(4).putInt(this.pieceID).array();
        this.setPayload(requestPayload);
    }
    public Request()
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
    