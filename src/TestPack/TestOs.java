package TestPack;

public class TestOs {

    public static void main(String[] args)
    {
        String os=System.getProperty("os.name");
        System.out.println(os);

        boolean isWindows=os.contains("Windows");
        System.out.println(isWindows);

    }

}
