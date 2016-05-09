package com.manavbagai.summary;

import java.io.File;
import java.io.IOException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

/**
 * 
 * Once the index is created, prepare an index reader class. 
 * You will use IndexReader class to read the index, 
 * to count the number of terms, frequencies and counting total number of documents
 *
 */
public class IndexOpener {
    
    public static IndexReader GetIndexReader() throws IOException {
        IndexReader indexReader = DirectoryReader.open(FSDirectory.open(new File(Configuration.INDEX_DIRECTORY)));
        return indexReader;
    }

    //Total number of documents in an index
    public static Integer TotalDocumentInIndex() throws IOException
    {
        Integer maxDoc = GetIndexReader().maxDoc();
        GetIndexReader().close();
        return maxDoc;
    }
}