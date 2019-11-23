package com.example.firebasecloundmessage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity implements OnCompleteListener<InstanceIdResult> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(this);
    }

    @Override
    public void onComplete(@NonNull Task<InstanceIdResult> task) {
        if(!task.isSuccessful())
        {
            Log.d("OOPS!!","Unable to get the token");
        }
        else
        {
            String token=task.getResult().getToken();
            Log.d("TOKEN","YOUR TOKEN IS::"+token);
        }


    }
}
