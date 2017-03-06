import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class StubMapper extends Mapper<LongWritable, Text, Text, Text> {
	
	Text resultat = new Text() ;

    HashMap<String,String> hmap=new HashMap<String,String>();

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  String line = value.toString();
      String[] part = line.split("\t");
      
      resultat.set(part[4]);
       
     
      context.write(new Text("Total"), resultat);


  }
  
}
