import java.net.*;
import java.util.*;
import java.io.*;

public class Server{
    public static String matrixType(int[][] m, int n){
        boolean upper = true;
        boolean lower = true;
        boolean diag = true;

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if(i>j && m[i][j]!= 0)
                    upper = false;
                if (i<j && m[i][j]!= 0 )
                    lower = false;
                if (i!=j && m[i][j]!=0)
                    diag = false;
            }
        }

        if (diag)
            return "Diagonal matrix";
        else if (upper)
            return "Upper triangular matrix";
        else if (lower)
            return "Lower triangular matrix";
        else 
            return "Not a special matrix";
    }
    public static void main(String args[]) throws Exception{
        
        ServerSocket ss=new ServerSocket(5000);
        System.out.println ("Server started...");
        Socket s=ss.accept();

        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());

        int n= dis.readInt();
        int[][] matrix=new int[n][n];
        System.out.println ("The matrix is: ");
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                matrix[i][j] = dis.readInt();
                System.out.println (matrix[i][j] + "\t");
            }
            System.out.println ();
        }

        String type= matrixType (matrix,n);
        dos.writeUTF(type);


        s.close();
        dis.close();
        dos.close();

    }
}
