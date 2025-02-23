package matching;
import java.io.*;
import java.util.*;
public class matching 
{
    public static void main(String agrs[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int n,r1,r2,c1,c2,i,j;
        System.out.println("Enter the grid cross-section");
        System.out.println("The grid should not be greater than 9*9");
        n=sc.nextInt();
        while (n>9 || n<2)
        {
            System.out.println("The grid should not be greater than 9*9");
            n=sc.nextInt();
        }
        int count=0;
        int grid[][]=new int[n][n];
        if (n%2==1){grid[n/2][n/2]=-1;}
        while (count!=(n*n)/2)
        {
            r1=(int)(Math.random()*10);
            c1=(int)(Math.random()*10);
            r2=(int)(Math.random()*10);
            c2=(int)(Math.random()*10);
            if ( r1<n && c1<n && c2<n && r2<n && (r1!=r2 && c1!=c2))
            {
                if (grid[r1][c1]==0 && grid[r2][c2]==0)                     //in java all the grid values are initialized to ZERO
                {
                    count++;
                    grid[r1][c1]=count;
                    grid[r2][c2]=count;
                } 
            }
        }
        if (n%2==1){grid[n/2][n/2]=0;}
        System.out.println("Grid created!");
        System.out.println("Start!");
        int f=0,f2=0;
        int grid2[][]=new int[n][n];
        for (i=0;i<n;i++)
        {
            for (j=0;j<n;j++)
            {
                System.out.print(grid2[i][j]+"\t");                       //all zeros printed
            }
            System.out.println();
        }
        
        while (f==0)
        {
            do
            {
                f2=0;
                System.out.println("Enter the 1st index");
                r1=sc.nextInt();
                c1=sc.nextInt();
                if (r1>=0 && r1<n && c1>=0 && c1<n)
                {
                    f2=1;
                    if(n%2==1 && r1==n/2 && c1==n/2){f2=0;}
                }
            }while(f2==0);
            grid2[r1][c1]=grid[r1][c1];
            System.out.println();
            for (i=0;i<n;i++)
            {
                for (j=0;j<n;j++)
                {
                    System.out.print(grid2[i][j]+"\t");
                }
                System.out.println();
            }
            do
            {
                f2=0;
                System.out.println("Enter the 2nd index");
                r2=sc.nextInt();
                c2=sc.nextInt();
                if (r2>=0 && r2<n && c2>=0 && c2<n)
                {
                    f2=1;
                    if(n%2==1 && r2==n/2 && c2==n/2){f2=0;}
                }
            }while (f2==0);
            grid2[r2][c2]=grid[r2][c2];
            System.out.println();
            for (i=0;i<n;i++)
            {   
                for (j=0;j<n;j++)
                {
                    System.out.print(grid2[i][j]+"\t");
                }
                System.out.println();
            }
            if (grid2[r1][c1]!=grid2[r2][c2])
            {
                grid2[r1][c1]=grid2[r2][c2]=0;
            }
            System.out.println();
            System.out.println("Updated grid");
            for (i=0;i<n;i++)
            {
                for (j=0;j<n;j++)
                {
                    System.out.print(grid2[i][j]+"\t");
                    if (grid2[i][j]!=0)
                    {f++;}
                }
                System.out.println();
            }
            if (f==n*n && n%2==0){f=1;}
            else if(f==(n*n-1) && n%2!=0){f=1;}
            else{f=0;}
        }
        System.out.println("YOU WIN!!");
        sc.close();
    }   
}
