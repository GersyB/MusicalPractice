package generator;

import java.util.Random;

public class NoteGenerator {
    private int lower;
    private int higher;
    private int distance;
    private int base;

    public NoteGenerator(int b){
        distance = 0;
        base = b;
    }

    public int Generate(){
        Random r = new Random();
        lower = base + r.nextInt(13) + 1;
        higher = lower + r.nextInt(12) + 1;
        distance = higher - lower +1;
        return higher*10000 + lower*100 + distance;
    }

    public int GetDist(){
        return distance;
    }

    public void SetDist(){
        distance = 0;
    }

}
