package com.example.monitoringapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private WorkerService workerService;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
        TextView textViewError = findViewById(R.id.textViewError);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        workerService = retrofit.create(WorkerService.class);
        Call<List<Worker>> call = workerService.getWorkers();
        call.enqueue(new Callback<List<Worker>>() {
            @Override
            public void onResponse(Call<List<Worker>> call, Response<List<Worker>> response) {
                if (response.isSuccessful()) {
                    List<Worker> workers = response.body();
                    for (Worker worker : workers) {
                        if (worker != null) {
                            Log.d("WORKER", "First name: " + worker.getFirst_name());
                        } else {
                            Log.e("WORKER", "Worker is null");
                        }

                    }
                } else {
                    Log.e("WORKER", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Worker>> call, Throwable t) {
                Log.e("WORKER", "Error: " + t.getMessage());
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                RegistrationService registrationService = retrofit.create(RegistrationService.class);
                Call<ResponseBody> call = registrationService.register(email, password);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            // Добавьте здесь обработку успешной регистрации
                            Log.e("DataBase", "Message: Found");

                            // Обработка успешной регистрации
                            String responseString = null;
                            try {
                                responseString = response.body().string();
                                Log.d("Response String", responseString);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            JSONObject jsonResponse = null;
                            try {
                                jsonResponse = new JSONObject(responseString);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            String message = jsonResponse.optString("message");
                            Log.d("Message", message);
                            if (message != null && message.equals("admin")) {
                                Log.e("Redirect", "Message: Found");
                                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                                startActivity(intent);
                            } else if (message != null && message.equals("worker")) {
                                Log.e("Redirect", "Message: Found");
                                Intent intent = new Intent(MainActivity.this, WorkerActivity.class);
                                startActivity(intent);
                            }
                        } else {
                            Log.e("DataBase", "Message: Not Found");

                            // Очищаем поля ввода логина и пароля
                            emailEditText.getText().clear();
                            passwordEditText.getText().clear();

                            // Отображаем красную надпись с ошибкой
                            textViewError.setText("Login or Password are not just right");
                            textViewError.setTextColor(Color.RED);

                            // Делаем TextView видимым
                            textViewError.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Ошибка сети. Проверьте подключение к Интернету и попробуйте снова", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

}
