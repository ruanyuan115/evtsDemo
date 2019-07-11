import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo
{
    public static void main(String[] args)throws IOException,InterruptedException
    {
        Evts.getEvts();
    }
}
class Evts{

    public static void getEvts()throws IOException,InterruptedException
    {
        String cmds="echo '060105' | sudo -S python2.7 petrarch_chinese/main.py";
        //设置命令行传入的参数
        String[] command = { "/bin/sh", "-c", cmds };
        Process pr = Runtime.getRuntime().exec(command);
        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line=in.readLine();
        while (line!=null)
        {
            System.out.println(line);
            line=in.readLine();
        }
        in.close();
        pr.waitFor();
    }

    public static void getEvtsWin()throws IOException,InterruptedException
    {
        //设置命令行传入的参数
        String[] arg = new String[]{"python", "petrarch_chinese/main.py"};
        Process pr = Runtime.getRuntime().exec(arg);
        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String str=in.readLine();
        while(str!=null)
        {
            System.out.println(str);
            str=in.readLine();
        }
        in.close();
        pr.waitFor();
    }
}
