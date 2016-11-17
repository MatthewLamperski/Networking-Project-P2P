package networking.project;

import java.util.BitSet;
/**
 *
 * @author Cole
 */
public class Bitfield extends Message{
    
    private boolean finished;
    private BitSet bit_field;
    private final int BFlength;
    private int downloadedPieces;
    
    public Bitfield()
    {
        //initial values
        finished = false;
        downloadedPieces = 0;
        this.BFlength = this.getLength()*8; //retrieve from parent class, convert to num of bits
        bit_field = new BitSet(BFlength);
        
        //initialize bit_field array
        for(int i = 0; i < BFlength; i++)
        {
            bit_field.set(i, false);
        }
    }
    public synchronized void bitDownloaded(int pieceIndex)
    {
        if(bit_field.get(pieceIndex) == false)
        {
            bit_field.set(pieceIndex, true);
            downloadedPieces++;
        }
        
        if(downloadedPieces == BFlength)
        {
            finished = true;
        }
    }
    public synchronized boolean weAreFinished()
    {
        return finished;
    }
    public synchronized void readBitfield()
    {
        downloadedPieces = 0;
        for(int i = 0; i < BFlength; i++)
        {
            int byteIndex = i/8; //select byte
            int pieceIndex = i%8; //select bit in byte
            
            byte[] payload = this.getPayload(); //retrieve from parent class message
            
            if((payload[byteIndex] & (1 << pieceIndex)) == 0) //break down to bit, bit is 0
            {
                bit_field.set(i, false);
            }
            else //bit is 1
            {
                bit_field.set(i, true);
                downloadedPieces++;
            }
        }
    }
    public synchronized byte[] writeBitfield()
    {
        return bit_field.toByteArray();
    }
}
