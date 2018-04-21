package lesson4.FileRepositories;

/**
 * Created by Kushn_000 on 15.04.2018.
 */
public class Storage {
private long Id;
private String formatSupported;
private String storageCountry;
private long storageSize;

    public Storage(long id, String formatSupported, String storageCountry, long storageSize) {
        Id = id;
        this.formatSupported = formatSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return Id;
    }

    public String getFormatSupported() {
        return formatSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }
}
