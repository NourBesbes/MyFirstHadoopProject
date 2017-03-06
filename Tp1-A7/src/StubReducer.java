import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer<KEY> extends Reducer<Text, Text, Text, Text> {
	

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
	  //nombre total des ventes
		float nb_ventes=0;
		//la valeur totale des ventes
		float total_ventes = 0;
	  for (Text val: values) 
	  {
		 float value =Float.parseFloat(val.toString());
 		nb_ventes++;
 		total_ventes+=value;
		  		
	  }
	 
	  context.write(new Text("Total"),new Text(nb_ventes+"___"+total_ventes));

  
  }
  
  
}