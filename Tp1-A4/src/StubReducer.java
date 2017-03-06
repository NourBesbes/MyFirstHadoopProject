import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer<KEY> extends Reducer<KEY, Text, KEY, DoubleWritable> {
	
	private DoubleWritable result = new DoubleWritable();

  @Override
  public void reduce(KEY key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
	  long salesTotal = 0 ;
	  for (Text val: values) 
	  {
		 
		  Double value=Double.parseDouble(val.toString());
 		  salesTotal+=value;
		  		
	  }
	  result.set(salesTotal);
	  context.write(key,result);

  
  }
}