package jiaheqi.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

public class HttpGetNewSample {


    public static void main(String[] args) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://www.baidu.com";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        InputStream inputStream = null;

        try {
            response = httpClient.execute(httpGet);
            System.out.println(response.getStatusLine().getStatusCode());
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity!=null){
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
