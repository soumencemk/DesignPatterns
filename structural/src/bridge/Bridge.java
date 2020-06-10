package bridge;

/**
 * @author Soumen Karmakar
 * 10/06/2020
 */
public class Bridge {

    public static void main(String[] args) {
        String os = "linux";
        FileDownloaderAbstraction downloader = null;
        switch (os) {
            case "windows":
                downloader = new FileDownloaderAbstractionImpl(new WindowsFileDownloadImplementor());
                break;

            case "linux":
                downloader = new FileDownloaderAbstractionImpl(new LinuxFileDownloadImplementor());
                break;

            default:
                System.out.println("OS not supported !!");
        }

        Object fileContent = downloader.download("some path");
        downloader.store(fileContent);
    }
}

interface FileDownloaderAbstraction {
    Object download(String path);

    boolean store(Object object);
}

interface FileDownloadImplementor {
    public Object downloadFile(String path);

    public boolean storeFile(Object object);
}

class FileDownloaderAbstractionImpl implements FileDownloaderAbstraction {
    FileDownloadImplementor provider;

    public FileDownloaderAbstractionImpl(FileDownloadImplementor provider) {
        super();
        this.provider = provider;
    }

    @Override
    public Object download(String path) {
        return provider.downloadFile(path);
    }

    @Override
    public boolean store(Object object) {
        return provider.storeFile(object);
    }
}

class LinuxFileDownloadImplementor implements FileDownloadImplementor {

    @Override
    public Object downloadFile(String path) {
        return new Object();
    }

    @Override
    public boolean storeFile(Object object) {
        System.out.println("File downloaded successfully in LINUX !!");
        return true;
    }
}

class WindowsFileDownloadImplementor implements FileDownloadImplementor {
    @Override
    public Object downloadFile(String path) {
        return new Object();
    }

    @Override
    public boolean storeFile(Object object) {
        System.out.println("File downloaded successfully in WINDOWS !!");
        return true;
    }
}
