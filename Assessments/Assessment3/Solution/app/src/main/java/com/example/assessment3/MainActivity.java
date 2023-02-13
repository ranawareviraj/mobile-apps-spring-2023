package com.example.assessment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WelcomeFragment.WelcomeListener, RegistrationFragment.RegistrationListener,
        SetGenderFragment.SetGenderListener, ProfileFragment.ProfileListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView, new WelcomeFragment())
                .commit();

    }

    @Override
    public void gotoRegistration() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new RegistrationFragment(), "reg-fragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoSetGender() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SetGenderFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoProfile(Profile profile) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, ProfileFragment.newInstance(profile))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void sendSelectedGender(String gender) {
        RegistrationFragment fragment = (RegistrationFragment) getSupportFragmentManager().findFragmentByTag("reg-fragment");
        if(fragment != null){
            fragment.setSelectedGender(gender);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelSetGender() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void closeProfileFragment() {
        getSupportFragmentManager().popBackStack();
    }
}