package jiaheqi.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

public class HttpGetNewSample {


    public static void main(String[] args) {
        //1、初始化httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://www.baidu.com";
        //2、使用get方法请求访问获取url信息
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        InputStream inputStream = null;

        try {
         //3、执行get请求，response用于接收返回
            response = httpClient.execute(httpGet);
         //打印链接状态码，判断链接是否建立成功
            System.out.println(response.getStatusLine().getStatusCode());
         //4、new实体接收响应返回信息
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity!=null){
          //5、字节流读取试题内容，并输出在控制台
                inputStream = httpEntity.getContent();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line="";
                while ((line = bufferedReader.readLine())!=null){
                    System.out.println(line);

                }
            }
        }
        catch (IOException e){
            e.printStackTrace();

        }
        finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (response != null){
                try{
                    response.close();

                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }


}
