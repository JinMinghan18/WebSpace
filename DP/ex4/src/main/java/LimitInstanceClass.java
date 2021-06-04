import java.io.*;

public class LimitInstanceClass {

    //实例数量
    static int num;
    //实例编号
    int id;
    //实例状态，false为空闲
    boolean isBusy = false;
    //调用实例的线程名
    String accessMessage = "";


    //从cfg中读取num数据
    static {
        num = Integer.parseInt(getFileContent("D:\\MyStudySpace\\WebSpace\\DP\\ex4\\src\\main\\resources\\InstanceLimit.cfg"));
    }




    private static LimitInstanceClass limitInstanceClass[] = new LimitInstanceClass[num];
    //实例化num个有限线程实例数量
    static {
        for(int i = 0; i < num; i++){
            limitInstanceClass[i] = new LimitInstanceClass();
            limitInstanceClass[i].id = i+1;
        }
    }
    //私有化构造
    private LimitInstanceClass(){
        isBusy = false;
    }
    //释放实例，状态设置为false空闲
    public void release(){
        isBusy = false;

    }
    //线程获取一个实例
    public static LimitInstanceClass getInstance(){
        int i=0;
        for(i = 0;i < num; i++){
            //找到空闲实例，标记并返回
            if(limitInstanceClass[i].isBusy == false){
                limitInstanceClass[i].isBusy=true;
                return limitInstanceClass[i];
            }
        }
        return null;
    }
    //线程将线程名写入accessMessage中
    public void WriteAccessMessage(String message){
        this.accessMessage = message;
    }
    //输出调用实例的线程名
    public void PrintAccessMessage(){
        System.out.println("thread "+accessMessage+" is using class "+this.id);

    }
    //获取cfg中的参数
    public static String getFileContent(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(path);
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader reader = new BufferedReader(read);
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}