package Network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlFileDownloader{

    public static File download(String link, String path, boolean print) throws Exception
    {
        File file=new File(path);

        if(file.exists())
            throw new Exception("The file already exist!");

        URL url= new URL(link);
        HttpURLConnection http= (HttpURLConnection) url.openConnection();
        double fileSize = (double) http.getContentLengthLong();
        BufferedInputStream in=new BufferedInputStream(http.getInputStream());
        FileOutputStream fos=new FileOutputStream(file);
        BufferedOutputStream bout=new BufferedOutputStream(fos, 1024);
        byte[] buffer = new byte[1024];
        double downloaded=0.00;
        int read=0;
        double percentDownloaded=0.00;
        while((read=in.read(buffer, 0, 1024)) >=0)
        {
            bout.write(buffer, 0, read);
            downloaded=+read;
            percentDownloaded=(downloaded*100)/(fileSize);
            String percent=String.format("%.4f", percentDownloaded);
            if(print==true)
                System.out.println("Downloaded: "+percent+" % of a file.");
        }
        bout.close();
        in.close();
        if(print==true)
            System.out.println("Download complete");

        return file;
    }


}
