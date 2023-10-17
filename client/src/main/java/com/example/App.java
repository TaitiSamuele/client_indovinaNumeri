package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            System.out.print("creo la socket\n");
            Socket s = new Socket("localhost", 3000);

            BufferedReader inTastiera = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String risposta = "";

            do{
                //prendo da tastierra il numero
                String saa = inTastiera.readLine();
                out.writeBytes( saa+ "\n");

                risposta = inServer.readLine();

                switch(risposta){
                    case "1":
                        System.out.println("il numero inserito e' piu' piccolo\n");
                        break;
                    case "2":
                        System.out.println("il numero inserito e' piu' grande\n");
                        break;
                    case "3":
                        System.out.println("hai vinto!!!!\n");
                        System.out.println("con " + inServer.readLine() + " tentativi\n" );
                        break;
                }               
            }while(!risposta.equals("3"));
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
