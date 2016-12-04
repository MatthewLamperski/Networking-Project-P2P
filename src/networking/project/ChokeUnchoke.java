package networking.project;
/**
 *
 * @author sarah
 */
public class ChokeUnchoke extends Message{

    public void ChokeUncoke()
    {
        //this.setLength(0);
        //this.setType(0);
        this.setPayload(null);
    }

    public void setChokeMsg()
    {
      this.setType(0);
    }

    public void setUnchokeMsg()
    {
      this.setType(1);
    }

    public boolean RecieveChokeUnchokeMsg()
    {

    }
}
