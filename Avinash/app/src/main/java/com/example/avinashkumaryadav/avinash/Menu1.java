package com.example.avinashkumaryadav.avinash;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu1 extends Fragment  {

MediaPlayer mp;

ImageButton button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Happy B'day Dear");
mp=MediaPlayer.create(getActivity(),R.raw.hpbday);
        button=view.findViewById(R.id.btnplay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying())
                {
                    mp.pause();
                    button.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                }
                else {
                    mp.start();
                    button.setImageResource(R.drawable.ic_pause_black_24dp);
                }
            }
        });



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}
