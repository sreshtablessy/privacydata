package Efficient;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author java2
 */
public class BlockchainDemo {
        

    public static int blockchainkey(String msg) {
         int plainData = 0;
         try {
          Blockchain blockchain = new Blockchain();
        blockchain.addBlock(new String[]{msg});
       // blockchain.addBlock(new String[]{"Mohamed send 60 bitcoin to mom."});
      //  blockchain.addBlock(new String[]{"Omar send 13 bitcoin to karim."});

        System.out.println("Blocks hash:");
        for(Block block : blockchain.getBlocks()) {            
            //plainData =block.getHash();
            System.out.println("block #" +blockchain.getBlocks());
            
            if ( block.getIndex() == 1)
            {
                plainData = block.getHash();
                System.out.println("blockffffffffffff #" + block.getIndex()  + ": " + plainData);
            }
            
        }
         } catch (Exception e) {
            System.out.println(e);
        }
              
            return plainData;
        
    }
}
         


