package new_project_ADV;

public class Numbers
{
	// def counter, array and amount
    private int count = 0; 
    private int[] nums; s
	private int max; 

    public Numbers(int n1)
    {
		// creates array and check 
        max = n1; 
        nums = new int[max]; 
        while (count < max) 
            FillNum();
    }

    public void FillNum()
    {
        int num = (int)(Math.random()*max) + 1; 
        int index = 0; 
        boolean loop = true; 

        while (loop)
        {
            if (num == nums[index]) 
                loop = false;  

            if (num != nums[index] && index == count) 
            {
                nums[count] = num;  
                count++; 
                loop = false;
            }

            index++;
        }
    }
}