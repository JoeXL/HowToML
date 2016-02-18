package com.Team17.socialmedia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

import io.fabric.sdk.android.Fabric;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.io.File;

public class MainActivity extends Activity {
    private TextView info;
    private LoginButton loginButton;
    private Button shareButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();



        setContentView(R.layout.activity_main);
        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton)findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                info.setText(
                        "User ID: "
                                + loginResult.getAccessToken().getUserId()
                                + "\n"
                                + "Auth Token: "
                                + loginResult.getAccessToken().getToken()
                );
            }

            @Override
            public void onCancel() {
                info.setText("Login attempt cancelled.");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Login attempt failed.");
            }

        });

        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://developers.facebook.com"))
                .build();


        shareButton = (Button)findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                share();
            }
        });

        TwitterAuthConfig authConfig = new TwitterAuthConfig("05iACK0HOD3tjAwIAh4DHfXm7","K3HcLD5yAphXUwQLKBgbEmtXqtV3tutDMpULKHmLiYC3OeKSMN");
        Fabric.with(this, new Twitter(authConfig), new TweetComposer());




    }

    private void share() {

        //create the send intent
        Intent shareIntent =
                new Intent(android.content.Intent.ACTION_SEND);

        //set the type
        shareIntent.setType("text/plain");

        //build the body of the message to be shared
        String shareMessage = "I've just completed a level on HowToML! ******Then link to our app in play store*********";

        //add the message
        shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "HowToML");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareMessage);

        //start the chooser for sharing
        startActivity(Intent.createChooser(shareIntent, "Which app are you going to share to!"));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    /*
    code implementing twitter share was here and is currently temporarily in notepad
     */



}
