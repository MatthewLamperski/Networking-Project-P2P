package networking.project;

/**
 *
 * @author Cole
 */
public class bitfield extends message{
    
    private boolean finished;
    private boolean [] bit_field;
    private final int BFlength;
    private int downloadedPieces;
    
    public bitfield()
    {
        //initial values
        finished = false;
        downloadedPieces = 0;
        this.BFlength = this.getLength();
        bit_field = new boolean[BFlength];
        
        //initialize bit_field array
        for(int i = 0; i < BFlength; i++)
        {
            bit_field[i] = false;
        }
    }
    
    public synchronized void bitDownloaded(int pieceIndex)
    {
        if(bit_field[pieceIndex] == false)
        {
            bit_field[pieceIndex] = true;
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
        
    }
    public synchronized void 
}
