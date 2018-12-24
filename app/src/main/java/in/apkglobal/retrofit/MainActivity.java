package in.apkglobal.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
Button btnsend;
String baseurl="http://searchkero.com/";
EditText etname,etemail,etmobile,etpassword, ettech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btnsend=findViewById(R.id.btnsend);
    etemail=findViewById(R.id.etemail);
    etmobile=findViewById(R.id.etmobile);
    etname=findViewById(R.id.etname);
    etpassword=findViewById(R.id.etpassword);
    ettech=findViewById(R.id.ettechnology);

    btnsend.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RestAdapter restAdapter=new RestAdapter
                    .Builder().setEndpoint(baseurl).build();
            API api=restAdapter.create(API.class);

            api.send(
                    etname.getText().toString(),
                    etemail.getText().toString(),
                    etpassword.getText().toString(),
                    etmobile.getText().toString(),
                    ettech.getText().toString(),

                    new Callback<Response>() {
                        @Override
                        public void success(Response response, Response response2) {

                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    }

            );
        }
    });
    }
}
