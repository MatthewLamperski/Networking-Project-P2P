package networking.project;
import java.io.*;
import java.nio.file.Files;
/**
 *File must be located in "file" folder in the working directory.
 *
 *
 * @author cole
 */
public class FileHandler extends Message{

    String fileName;
    int fileSize;
    int pieceSize;
    int pieceCount;
    int NPieces;
    Piece[] PieceArray;
    int PeerID;

    public FileHandler (String f, long fs, int size, int PeerID)
    {
      this.fileName = f;
      this.fileSize = (int)fs;
      this.pieceSize = size;
      this.pieceCount = 0;
      this.NPieces = this.fileSize/this.pieceSize;
      this.PieceArray = new Piece[NPieces];
      this.PeerID = PeerID;
     }

    public Piece[] splitFile () throws IOException
    {
      String path = "/file/"+fileName;
      File inputFile = new File(path);
      FileInputStream inputStream;
      int read = 0, readLength = pieceSize;
      byte[] PieceInBytes;
      
      inputStream = new FileInputStream(inputFile);
        
        while (fileSize > 0) 
        {
            if (fileSize <= pieceSize) 
            {
                readLength = fileSize;
            }
            PieceInBytes = new byte[readLength];
            read = inputStream.read(PieceInBytes, 0, readLength);
            fileSize -= read;
            assert (read == PieceInBytes.length);
            PieceArray[pieceCount] = new Piece(pieceCount, PieceInBytes);
            pieceCount++;
            PieceInBytes = null;
        }
       inputStream.close();
       return PieceArray;
    }
    
    public void joinFile (Piece[] p) throws IOException
    {
        String path = "/file/"+fileName+"_"+PeerID;
        byte[] fileInBytes = new byte[fileSize];
        int arrayPosition = 0;
        for (Piece p1 : p) 
        {
            byte[] pieceInBytess = p1.getPieceInBytesNoID();
            for (int i = 0; i < pieceInBytess.length; i++) 
            {
                fileInBytes[arrayPosition] = pieceInBytess[i];
                arrayPosition++;
            }
        }
        Files.write(new File(path).toPath(), fileInBytes);
    }
}

