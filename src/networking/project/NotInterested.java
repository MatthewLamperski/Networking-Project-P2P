package networking.project;
/**
 *
 * @author sarah
 */
public class NotInterested extends Message{
    
    public void NotInterested()
    {
        //this.setLength(0);
        this.setType(3);
        this.setPayload(null);
    }
}
