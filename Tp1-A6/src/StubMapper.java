import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class StubMapper extends Mapper<LongWritable, Text, Text, Text> {
	Text outkey=new Text();
	Text cout = new Text();
    HashMap<String,String> hmap=new HashMap<String,String>();

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  
	  String line = value.toString();
      String[] part = line.split("\t");
     outkey.set(part[2]);
     cout.set(part[4]);   
     
      context.write(outkey, cout);


  }
  
}
