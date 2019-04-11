package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class in_out {
	public in_out()
	{
		
	}

    /**
     * �����ļ�
     * @param fileName
     * @return
     */
    public static boolean createFile(File fileName)throws Exception{
        try{
            if(!fileName.exists()){
                fileName.createNewFile();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }


    /**
     *��ȡTXT����
     * @param file
     * @return
     */
    public static String readTxtFile(File file){
        String result = "";
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"gbk");
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            while((s=br.readLine())!=null){
                result = result  + s;
                //System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * д��TXT������ԭ����
     * @param content
     * @param fileName
     * @return
     * @throws Exception
     */
    public static boolean writeTxtFile(String content,File fileName)throws Exception{
        RandomAccessFile mm=null;
        boolean flag=false;
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(content.getBytes("gbk"));
            fileOutputStream.close();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * д��TXT��׷��д��
     * @param filePath
     * @param content
     */
    public static void fileChaseFW(String filePath, String content) {
        try {
            //���캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
            FileWriter fw = new FileWriter(filePath,true);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            System.out.println("�ļ�д��ʧ�ܣ�" + e);
        }
    }

    /**
     * ��ȡCSV
     */
    public List<String[]> readCSV(String path) {
        File csv = new File(path);  // CSV�ļ�·��
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        List<String[]> allString = new ArrayList<String[]>();
        try {
            while ((line = br.readLine()) != null)  //��ȡ�������ݸ�line����
            {
                everyLine = line;
                //System.out.println(everyLine);
                String item[] = everyLine.split(",");
                allString.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allString;
    }
}  