package networking.project;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author tyler
 */
public class FileReadTest {
    public static class CommonConfig
    {
    int preferredNeighbors = 0;
    int unchokingInterval = 0;
    int optimisticUnchokingInterval = 0;
    String fileName = "";
    int fileSize = 0;
    int pieceSize = 0; 
    
        public CommonConfig(int pref,int unch,int opt, String file,int size,
                int piece){   
            preferredNeighbors = pref;
            unchokingInterval = unch;
            optimisticUnchokingInterval= opt;
            fileName = file;
            fileSize = size;
            pieceSize = piece;
        }
        public int getPref(){
      System.out.println("Pref is :" + preferredNeighbors );
      return preferredNeighbors;
        }
        public int getUnch(){
      System.out.println("Unch is :" + unchokingInterval );
      return unchokingInterval;
        }
        public int getOpt(){
      System.out.println("Opt is :" + optimisticUnchokingInterval );
      return optimisticUnchokingInterval;
        }
        public String getFile(){
      System.out.println("File is :" + fileName );
      return fileName;
        }
        public int getSize(){
      System.out.println("Size is :" + fileSize );
      return fileSize;
        }
        public int getPiece(){
      System.out.println("Piece is :" + pieceSize );
      return pieceSize;
        }
    
    }
    public static class peerConfig
    {
    int peerID = 0;
    String hostName = "";
    int listeningPort = 0;
    boolean hasFile = false;
    public peerConfig(int peer,String host,int port, boolean hasF){   
    peerID = peer;
    hostName = host;
    listeningPort = port;
    hasFile = hasF;
        }
    public peerConfig()
    {
        peerID = 0;
        hostName = "";
        listeningPort = 0;
        hasFile = false;
    }
    public void setID(int id)
    {
        peerID = id;
    }
    public int getID(){
      System.out.println("ID is :" + peerID );
      return peerID;
    }
    public void setHost(String hostN)
    {
        hostName = hostN;
    }
    public String getHost(){
      System.out.println("Host is :" + hostName );
      return hostName;
    }
    public void setPort(int portNum)
    {
        listeningPort = portNum;
    }
    public int getPort(){
      System.out.println("Port is :" + listeningPort );
      return listeningPort;
    }
    public void setHasFile(boolean flag)
    {
        hasFile = flag;
    }
    public boolean getHasFile(){
      System.out.println("HasFile: " + hasFile );
      return hasFile;
    }

    }
    public static ArrayList<peerConfig> getPeerValues()
    {
        Path filepath = Paths.get("./config", "PeerInfo.cfg");
        Charset charset = Charset.forName("ISO-8859-1");
        int pI = 0;
        String hN = "";
        int lP = 0;
        int hFTemp = 0;
        boolean hF = false;
        int index = 0;
        ArrayList<peerConfig> peerValsList = new ArrayList<peerConfig>();

        try {
      List<String> lines = Files.readAllLines(filepath, charset);
      for (String line : lines) {
          
          peerConfig peerVals = new peerConfig();
         // System.out.println(line);
          String[] values = line.split("\\s+");
          pI = Integer.parseInt(values[0]);
          hN = values[1];
          lP = Integer.parseInt(values[2]);
          hFTemp = Integer.parseInt(values[3]);
          if (hFTemp == 0)
          {
              hF = false;
          }
          else
              hF = true;
          peerVals.setID(pI);
         // peerVals.getID();
          peerVals.setHost(hN);
          peerVals.setPort(lP);
          peerVals.setHasFile(hF);
          peerValsList.add(peerVals);
         // peerValsList.get(0).getID();
      }
      index++;
        }
    catch (IOException e) {
      System.out.println(e);
    }
        return peerValsList;
    }
    public static CommonConfig getCommonValues()
    {   
    Path filepath = Paths.get("./config", "Common.cfg");
    Charset charset = Charset.forName("ISO-8859-1");
    int pN = 0;
    int uI = 0;
    int oUI = 0;
    String fN = "";
    int fS = 0;
    int pS = 0;
    int lineNumber = 1;
    try {
      List<String> lines = Files.readAllLines(filepath, charset);
      for (String line : lines) {
        if (line.contains("NumberOf") && lineNumber == 1)
        {
            String getValue = line.replaceAll("[^0-9]", "");
            pN = Integer.parseInt(getValue);
        }
        else
                if (line.contains("UnchokingInterval") && lineNumber == 2)
        {
            String getValue = line.replaceAll("[^0-9]", "");
            uI = Integer.parseInt(getValue);
        } 
        else
                if (line.contains("Optimistic") && lineNumber == 3)
        {
            String getValue = line.replaceAll("[^0-9]", "");
            oUI = Integer.parseInt(getValue);
        } 
        
        else
                if(line.contains("FileName") && lineNumber == 4)
        {
            int spaceDelimiter = line.indexOf(" ");
            int stringLength = line.length();
            fN = line.substring(spaceDelimiter + 1,stringLength);
            
        } 
        else
                if (line.contains("FileSize") && lineNumber == 5)
        {
            String getValue = line.replaceAll("[^0-9]", "");
            fS = Integer.parseInt(getValue);
        }
        else
                if (line.contains("PieceSize") && lineNumber == 6)
        {
            String getValue = line.replaceAll("[^0-9]", "");
            pS = Integer.parseInt(getValue);
        }
        else
                {
                    System.out.println("Incorrect Config File");
                    break;
                }
        lineNumber++;
      }
    }
    catch (IOException e) {
      System.out.println(e);
    }
    CommonConfig getConf = new CommonConfig(pN,uI,oUI,fN,fS,pS);
    return getConf;
    }
    public static void main(String[] args) {        
    
    CommonConfig commonConfigValues = getCommonValues();
      commonConfigValues.getPref();
      commonConfigValues.getUnch();
      commonConfigValues.getOpt();
      commonConfigValues.getFile();
      commonConfigValues.getSize();
      commonConfigValues.getPiece();
    //  getPeerValues();
    ArrayList<peerConfig> peerConfigValues = new ArrayList<peerConfig>(getPeerValues());
    peerConfigValues.get(0).getID();
    peerConfigValues.get(0).getHost();
    peerConfigValues.get(0).getPort();
    peerConfigValues.get(0).getHasFile();

    //  peerConfigValues.get(0).getID();   
    }
}