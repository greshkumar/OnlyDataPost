package com.example.greshkumartharwani.postwithget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText etid,ettitle,etbody;
    TextView UserId, id , title, body;
    Button btnpost;
    model result ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etid = (EditText)findViewById(R.id.etid);
        ettitle = (EditText)findViewById(R.id.ettitle);
        etbody = (EditText)findViewById(R.id.etbody);

        UserId = (TextView)findViewById(R.id.UserId);
        id = (TextView)findViewById(R.id.id);
        title = (TextView)findViewById(R.id.title);
        body= (TextView)findViewById(R.id.body);

        btnpost = (Button)findViewById(R.id.btnpost);
        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model obj = new model();
                obj.setUserId(Integer.parseInt(etid.getText().toString()));
                obj.setTitle(ettitle.getText().toString());
                obj.setBody(etbody.getText().toString());
                postdata(obj);
            }
        });


    }
    public void postdata(model post){
        apiservice obje = apiclient.getretrofit().create(apiservice.class);
        Call<model> call= obje.gresh(post);
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                result=response.body();
                id.setText(String.valueOf(result.getId()));
                UserId.setText(String.valueOf(result.getUserId()));
                title.setText(result.getTitle());
                body.setText(result.getBody());
            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {

            }
        });

    }
}
