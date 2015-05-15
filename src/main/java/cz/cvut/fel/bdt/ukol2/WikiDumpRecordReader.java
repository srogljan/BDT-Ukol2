package cz.cvut.fel.bdt.ukol2;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.LineRecordReader;
import org.apache.hadoop.mapred.RecordReader;


public class WikiDumpRecordReader implements RecordReader<LongWritable, Text>
{
	private LineRecordReader lineReader;
	private LongWritable lineKey;
	private Text lineValue;
	
	public WikiDumpRecordReader(JobConf job, FileSplit split) throws IOException {
	    lineReader = new LineRecordReader(job, split);
	    lineKey = lineReader.createKey();
	    lineValue = lineReader.createValue();
	  }
	

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public LongWritable createKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public Text createValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getPos() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getProgress() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean next(LongWritable key, Text value) throws IOException 
	{
		if (!lineReader.next(key, value))
		{
			return false;
		}
		String[] s = lineValue.toString().split("  ");
		lineKey = new LongWritable(Long.parseLong(s[0]));
		lineValue = new Text(s[1]);
		return true;
	}

}
