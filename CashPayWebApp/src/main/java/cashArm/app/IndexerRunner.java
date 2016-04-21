package cashArm.app;

import au.com.bytecode.opencsv.CSVParser;
import cashArm.Contract4Search;
import cashArm.Contract4Search2ListAdapter;
import cashArm.search_engine.Indexer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 25.08.14.
 */
public class IndexerRunner {
    public static void main(String[] args) {
        IndexerRunner indexerRunner=new IndexerRunner();
        try {
            Indexer indexer=getIndexer();
            indexerRunner.lookFor("sss*","content",indexer);

//        indexerRunner.indexData("D:\\lucene\\sources\\ttt.csv",indexer);
            indexer.close();
        }catch (IOException e){
            e.printStackTrace();
        }



    }

    public static Indexer getIndexer() throws IOException{
        return new Indexer();
    }

    private List<String> lookFor(String pattern,String field,Indexer indexer) throws IOException{
        List<String> results=new ArrayList<String>();
        indexer.search(pattern,field);
        return results;
    }

    public  void indexData(String fileName,Indexer indexer){
        try {
            File file=new File(fileName);
            loadData(file,indexer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void loadData(File fileIn,Indexer indexer) throws IOException{

        BufferedReader fin=new BufferedReader(new InputStreamReader(new FileInputStream(fileIn),"windows-1251"));
        CSVParser csvParser=new CSVParser(';','"');
        String line=null;
        while ((line=fin.readLine())!=null){
            String[] parsedData=csvParser.parseLine(line);
            indexer.indexContract(new Contract4Search2ListAdapter(Arrays.asList(parsedData)));
            for(String field:parsedData){
                System.out.print(" -> "+field);
            }
            System.out.println( " next string >");
        }
    }





}
