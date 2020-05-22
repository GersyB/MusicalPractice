package generator;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;

import e08zu8.musicpractice.R;

public class NotePlayer {
    private Context context;
    private MediaPlayer mpl;
    private MediaPlayer mph;
    private int[] tracks;

    public NotePlayer(Context c) {
        context = c;
        tracks = new int[35];
        this.Init();
    }
    public void Play(int b){
        final int i = b;
                int high = i / 10000;
                int low = (i - (high * 10000)) / 100;
                mph = MediaPlayer.create(context, tracks[low-1]);
                mpl = MediaPlayer.create(context, tracks[high-1]);
                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        mpl.start();
                    }
                };
                mph.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    int count = 0;
                    @Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        if(count == 1) return;
                        mph.start();
                        Handler handler = new Handler();
                        handler.postDelayed(runnable, 3000);
                        count++;
                    }
                });
                mpl.start();
                mph.start();
            }

    public void Stop(){
        if(mpl != null && mph != null){
            mpl.release();
            mph.release();
        }
    }

    private void Init(){
        tracks[0] = R.raw.c;
        tracks[1] = R.raw.cs;
        tracks[2] = R.raw.d;
        tracks[3] = R.raw.ds;
        tracks[4] = R.raw.e;
        tracks[5] = R.raw.f;
        tracks[6] = R.raw.fs;
        tracks[7] = R.raw.g;
        tracks[8] = R.raw.gs;
        tracks[9] = R.raw.a;
        tracks[10] = R.raw.as;
        tracks[11] = R.raw.b;
        tracks[12] = R.raw.c2;
        tracks[13] = R.raw.c2s;
        tracks[14] = R.raw.d2;
        tracks[15] = R.raw.d2s;
        tracks[16] = R.raw.e2;
        tracks[17] = R.raw.f2;
        tracks[18] = R.raw.f2s;
        tracks[19] = R.raw.g2;
        tracks[20] = R.raw.g2s;
        tracks[21] = R.raw.a2;
        tracks[22] = R.raw.a2s;
        tracks[23] = R.raw.b2;
        tracks[24] = R.raw.c3;
        tracks[25] = R.raw.c3s;
        tracks[26] = R.raw.d3;
        tracks[27] = R.raw.d3s;
        tracks[28] = R.raw.e3;
        tracks[29] = R.raw.f3;
        tracks[29] = R.raw.f3s;
        tracks[30] = R.raw.g3;
        tracks[31] = R.raw.g3s;
        tracks[32] = R.raw.a3;
        tracks[33] = R.raw.a3s;
        tracks[34] = R.raw.b3;
    }
}
