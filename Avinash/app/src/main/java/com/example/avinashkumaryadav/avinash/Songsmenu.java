package com.example.avinashkumaryadav.avinash;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Songsmenu extends Fragment {

MediaPlayer mediaPlayer;
    public Songsmenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_songsmenu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Songs And Movies");
        Button button=view.findViewById(R.id.play1);
        mediaPlayer=MediaPlayer.create(getActivity(),R.raw.kalhona);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Toast.makeText(getActivity(),"playing Kal ho na ho",Toast.LENGTH_LONG).show();

            }
        });
        Button btn=view.findViewById(R.id.pause2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                Toast.makeText(getActivity(),"paused",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
