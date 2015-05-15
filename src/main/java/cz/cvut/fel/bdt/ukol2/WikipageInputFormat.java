package cz.cvut.fel.bdt.ukol2;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordReader;
import org.apache.hadoop.mapred.Reporter;

public class WikipageInputFormat extends FileInputFormat<LongWritable,Text> 
{
	@Override
	public RecordReader<LongWritable, Text> getRecordReader(InputSplit input,
			JobConf job, Reporter reporter) throws IOException {
		reporter.setStatus(input.toString());
		return new WikiDumpRecordReader(job, (FileSplit) input);
	}
}
