package in.apkglobal.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FetchingActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetching);
        listView = findViewById(R.id.listview);
getData();
    }

    private void getData() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Data.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Data data=retrofit.create(Data.class);

        Call<List<Hero>> listCall=data.getHeroes();

        listCall.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
List<Hero> list=response.body();
String [] name=new String[list.size()];

                for (int i = 0; i < list.size(); i++) {
                    name[i] = list.get(i).getName();
                }

                //displaying the string array into listview
                listView.setAdapter
                        (new ArrayAdapter<String>
                                (getApplicationContext(),
                                        android.R.layout.simple_list_item_1,
                                        name));

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }
}
