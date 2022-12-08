import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class lab13
{
    public ArrayList<Integer> storedValues = new ArrayList<Integer>();
    public Stream<Integer> storedValuesStream = storedValues.stream();

	lab13()
	{
		
	}

	public void readData(String filename)
	{
        try
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            String inn;

            while((inn = input.readLine()) != null)
            {
                StringTokenizer st = new StringTokenizer(inn);
                while(st.hasMoreTokens())
                {
                    String s1 = st.nextToken();
                    try
                    {
                        storedValues.add(Integer.parseInt(s1));
                    }
                    catch(Exception e)
                    {
                    }
                }
            }
            input.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            System.exit(0);
        }
	}

	public long getTotalCount()
	{
		return storedValuesStream.count();
	}

	public long getOddCount()
	{
		return storedValuesStream.filter(x -> x % 2 == 1).count();
	}

	public long getEvenCount()
	{
		return storedValuesStream.filter(x -> x % 2 == 0).count();
	}

	public long getDistinctGreaterThanFiveCount()
	{
		return storedValuesStream.distinct().skip(6).count();
	}

	public Integer[] getResult1()
	{
		return storedValuesStream.filter(x -> x % 2 == 0 && x < 50 && x > 5).sorted().toArray(Integer[]::new);	
	}

	public Integer[] getResult2()
	{
		return storedValuesStream.limit(50).map(x -> (x*x)*3).toArray(Integer[]::new);
	}

	public Integer[] getResult3()
	{
		return storedValuesStream.filter(x -> x % 2 == 1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);	
	}
}
