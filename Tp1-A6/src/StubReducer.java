import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer<KEY> extends Reducer<KEY, Text, KEY, FloatWritable> {
	
	
	
  @Override
  public void reduce(KEY key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
	  float max =0 ;
	  
	  for (Text val: values) 
	  {
		  float value=Float.parseFloat(val.toString());
		  
			  if(value>max)
				  max=value;
 		  			  
		  		
	  }	  	
	  
	  context.write(key,new FloatWritable(max));
	 	 
  
  }
}