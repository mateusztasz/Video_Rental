package tasz.mateusz;

/**
 * Created by Mateusz on 2017-03-31.
 */

import tasz.mateusz.Canva.Canva;
import tasz.mateusz.Canva.EntryWindow;
import tasz.mateusz.Exception.FinishApplicationException;

import java.lang.*;


public class App implements Runnable {

    private static DataBaseHandler db;

    public void run() {
        while(true) {
            try {

                // Sleep an hour.
                Thread.sleep(1000 * 60 * 60);

            }
            catch (InterruptedException ie) {

            }
        }
    }


    /**
     * An entry to the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        db = new DataBaseHandler();

        (new Thread(new App())).start();

        Canva window = new EntryWindow(db);

        while (true) {

            try {
                window = window.perform();
            }
            catch (FinishApplicationException e){
                break;
            }

        }
        db.close();
    }
}
