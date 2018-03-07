package be.ehb.oef2threading;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbJos, pbPiet, pbJan;
    private TextView tvResult;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbJos = findViewById(R.id.pb_jos);
        pbPiet = findViewById(R.id.pb_piet);
        pbJan = findViewById(R.id.pb_jan);

        tvResult = findViewById(R.id.tv_result);
        btnGo = findViewById(R.id.btn_go);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressTask pt1 = new ProgressTask(tvResult);
                pt1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,pbJos);

                ProgressTask pt2 = new ProgressTask(tvResult);
                pt2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,pbPiet);

                ProgressTask pt3 = new ProgressTask(tvResult);
                pt3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,pbJan);
            }
        });




    }
}
