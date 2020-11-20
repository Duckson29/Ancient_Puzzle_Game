package dk.ducksoft.ancientpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dk.ducksoft.ancientpuzzlegame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainPresenter mainPresetner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresetner = new MainPresenter();
        binding.setPreset(mainPresetner);
    }
}