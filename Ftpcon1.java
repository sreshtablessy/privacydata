package Efficient;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.net.ftp.FTPClient;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author java2
 */
public class Ftpcon1 {

    FTPClient client = new FTPClient();
    FileInputStream fis = null;
    boolean status;

    public boolean upload(File file,String name,String server) {
        try {
            
            
            client.connect("ftp.drivehq.com");
            client.login("deepchoccy", "giri@2027");
            client.enterLocalPassiveMode();
            fis = new FileInputStream(file);
            if(server.equals("cloud1")){
                    status = client.storeFile("/cloud1/" + name, fis);
               
               
            }
            
            
          
            //status = client.storeFile("/cloud/" + filename, fis);
            client.logout();
            fis.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        if (status) {
            System.out.println("success");
            return true;
        } else {
            System.out.println("failed");
            return false;
        }
    }

    void upload(File f, String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
