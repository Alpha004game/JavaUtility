package TestPack;

import Network.UrlFileDownloader;

import java.io.File;

public class DownloadFromURLTest {

    public static void main(String[] args)
    {
        File file;
        try {
            UrlFileDownloader.download("https://www.brescianet.com/appunti/riservata/ManualePraticoJava.pdf","C:\\Users\\Alpha\\Desktop\\test.pdf", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
