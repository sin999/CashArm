package cashArm.onyma.common;

import java.util.ArrayList;

/**
 * Created by Admin on 14.10.14.
 */
public class DataChunk<T> extends ArrayList<T>{
    private boolean theLastChunk;
    private int chunkNum;

    public  DataChunk(){}

    public  DataChunk(int chunkNum,boolean theLastChunk){
        this.theLastChunk=theLastChunk;
        this.chunkNum=chunkNum;
    }


    public boolean isTheLastChunk() {
        return theLastChunk;
    }

    public void setTheLastChunk(boolean theLastChunk) {
        this.theLastChunk = theLastChunk;
    }

    public int getChunkNum() {
        return chunkNum;
    }

    public void setChunkNum(int chunkNum) {
        this.chunkNum = chunkNum;
    }
}
