package be.ehb.oef2threading;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

/**
 * Created by Q on 2-3-2018.
 */

public class ProgressTask extends AsyncTask<ProgressBar,Void,Void> {


    private WeakReference<TextView> tvWinner;

    public ProgressTask(TextView tvWinner){
        this.tvWinner = new WeakReference<TextView>(tvWinner);
    }




    @Override
    protected Void doInBackground(ProgressBar... progressBars) {

        for (ProgressBar pb : progressBars){

            for (int i = 0; i <= 100; i++){
                Random rGenerator = new Random();
                int randomNr = rGenerator.nextInt(500);
                try {
                    Thread.sleep(randomNr);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                pb.setProgress(i);

            }
        }




        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


    }
}
