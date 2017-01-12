package com.example.ashleigh.fbexxample;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;


public class MainActivity extends AppCompatActivity {
    Button button;
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                android.app.Fragment pv = getFragmentManager().findFragmentByTag("dialog");
                if(pv== null) Log.e("pv ","null");
                if(pv !=null) {
                    ft.remove(pv);
                }
                ft.addToBackStack(null);

                FragmentManager fm = getSupportFragmentManager();
                FacebookDialog fmt = new FacebookDialog();

                DialogFragment newFrag = FacebookDialog.newInstance(0);
                newFrag.show(ft,"dialog");
            }
        });
//        callbackManager = CallbackManager.Factory.create();
//
//        LoginManager.getInstance().logInWithReadPermissions(MainActivity.this,
//                Arrays.asList("public_profile","email","user_photos")); // , "email","user_photos"));
//        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(final LoginResult loginResult) {
//                /*GraphRequest request;
//                request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
//                    @Override
//                    public void onCom
//                    ,pleted(JSONObject user, GraphResponse response) {
//                        if (response.getError() != null) {
//
//                        } else {
//                            Log.e("TAG", "user: " + user.toString());
//                            setResult(RESULT_OK);
//                            finish();
//                        }
//                    }
//                });
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "albums{name,photo{images}}");//,photos/uploaded"); //,photos?type=uploaded,album");
//                request.setParameters(parameters);
//                request.executeAsync();*/
//                GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequest(loginResult.getAccessToken(),
//                        "/me?fields=email,birthday,albums{name,photos{images}}",null, HttpMethod.GET,new GraphRequest.Callback() {
//                    public void onCompleted(GraphResponse response) {
//                        JSONObject object = response.getJSONObject();
//                        try {
//                            Log.e("response : ",response.toString());
//                            JSONArray profile = object.getJSONObject("albums").getJSONArray("data");
//                            JSONObject profile2 = profile.getJSONObject(2);
//                            JSONObject profile3 = profile2.getJSONObject("photos").getJSONArray("data").getJSONObject(1).getJSONArray("images").getJSONObject(0);
//                            String source = profile3.getString("source");
//                            Log.e("data length2 ",""+profile2.toString());
//                            Log.e("profile3",""+profile3.toString());
//                            Log.e("source",""+source);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).executeAsync();
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//                Log.e("OnERROR",""+error.toString());
//            }
//        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
