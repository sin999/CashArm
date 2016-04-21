package cashArm.search_engine;

import cashArm.Contract4Search;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.apache.lucene.util.Version;


import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 21.08.14.
 */
public class Indexer {
//    private static String DEFAULT_INDEX_DIR="c:\\lucene";
    private static String DEFAULT_INDEX_DIR="/var/sss/lucene";

    private IndexWriter indexWriter = null;
    private Directory fsDirectory;
    private Analyzer analyzer;


    public Indexer() throws IOException{
        this(DEFAULT_INDEX_DIR);
        analyzer = new StandardAnalyzer(Version.LUCENE_4_9);
    }

    public Indexer(String dirPath) throws IOException{
        fsDirectory =  FSDirectory.open(new File(dirPath));
    }

//    public void indexOrder(Orders order) throws IOException {
//        Client client=null;
////        System.out.println("Indexing hotel: " + order.getCid());
//        IndexWriter writer = getIndexWriter();
//        Document doc = new Document();
//        doc.add(new TextField("id", order.getDogovor(), Field.Store.YES));
//        if((client=order.getClient())!=null){
//            doc.add(new TextField("name", client.getName(), Field.Store.YES));
//            doc.add(new TextField("fullname", client.getFullname(), Field.Store.YES));
//            doc.add(new TextField("factAddr", client.getFact_addr(), Field.Store.YES));
//            doc.add(new TextField("vkluch_addr", client.getVkluch_addr(), Field.Store.YES));
//            String fullSearchableText = client.getName() + " " + client.getFullname() + " " +  client.getVkluch_addr()+" "+client.getPhone();
//            doc.add(new TextField("content", fullSearchableText, Field.Store.NO));
//        }
//        writer.addDocument(doc);
//
//    }


    public void indexContract( Contract4Search cf) throws IOException {
        IndexWriter writer = getIndexWriter();
        Document doc = new Document();
        doc.add(new TextField("code", cf.getCode(), Field.Store.YES));
        doc.add(new TextField("name", cf.getName(), Field.Store.YES));
        doc.add(new TextField("address", cf.getAddress(), Field.Store.YES));
        doc.add(new TextField("phone", cf.getPhone(), Field.Store.YES));
        doc.add(new TextField("group", cf.getGroup(), Field.Store.YES));
        String fullSearchableText = cf.getCode()+ " " + cf.getName() + " " +  cf.getAddress()+" "+cf.getPhone();
        doc.add(new TextField("content", fullSearchableText, Field.Store.NO));
        writer.addDocument(doc);

    }

    public IndexWriter getIndexWriter() throws IOException {
        if (indexWriter==null){
            IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_4_9,analyzer);
            indexWriter =new IndexWriter(fsDirectory,conf);
        }
        return indexWriter;
    }

    public void  close(){
        try{
            if(indexWriter!=null){
                indexWriter.close();
                indexWriter=null;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }




    public void search(String pattern,String fieldName) throws IOException {
        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(fsDirectory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryBuilder builder = new QueryBuilder(analyzer);
        QueryParser parser = new QueryParser(Version.LUCENE_4_9, fieldName, analyzer);
        try {
            Query query = parser.parse(pattern);
            ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;

            // Iterate through the results:
            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);
                System.out.println(  "Result "+i+" is "+hitDoc.get("code")
                        +" "+hitDoc.get("name")+" "+hitDoc.get("address")+" "+hitDoc.get("phone"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        ireader.close();
    }


    public List<String> lookFor(String pattern,String fieldName) throws IOException {

        List<String> results =new ArrayList<String>();
        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(fsDirectory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryBuilder builder = new QueryBuilder(analyzer);
        QueryParser parser = new QueryParser(Version.LUCENE_4_9, fieldName, analyzer);
        try {
            Query query = parser.parse(pattern);
            ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;

            // Iterate through the results:
            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);
                results.add(  " "+i+"  "+hitDoc.get("code")
                        +" "+hitDoc.get("name")+" "+hitDoc.get("address")+" "+hitDoc.get("phone"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        ireader.close();
        return results;
    }
    public List<Contract4Search> lookForObj(String pattern,String fieldName) throws IOException {

        List<Contract4Search>  results =new ArrayList<Contract4Search>();
        DirectoryReader ireader = DirectoryReader.open(fsDirectory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        QueryParser parser = new QueryParser(Version.LUCENE_4_9, fieldName, analyzer);
        try {
            Query query = parser.parse(pattern);
            ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;

            // Iterate through the results:
            for (int i = 0; i < hits.length; i++) {
                Contract4Search contract4Search=new Contract4Search();
                Document hitDoc = isearcher.doc(hits[i].doc);
                contract4Search.setId(hitDoc.get("id"));
                contract4Search.setCode(hitDoc.get("code"));
                contract4Search.setName(hitDoc.get("name"));
                contract4Search.setAddress(hitDoc.get("address"));
                contract4Search.setPhone(hitDoc.get("phone"));
                contract4Search.setGroup(hitDoc.get("group"));
                results.add(contract4Search);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        ireader.close();
        return results;
    }



    public void test() throws IOException{
        Directory directory = FSDirectory.open(new File("d:lucene/test"));
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_9, analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        Document doc = new Document();
        String text = "This is the text to be indexed.";
        doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
        iwriter.addDocument(doc);
        iwriter.close();

        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser(Version.LUCENE_4_9, "fieldname", analyzer);
        try {
            Query query = parser.parse("text");
            ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
            // Iterate through the results:
            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);
                System.out.println("This is the text to be indexed."+ hitDoc.get("fieldname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        ireader.close();
        directory.close();
    }
}
