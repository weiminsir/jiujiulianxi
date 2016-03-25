package weiminsir.jiujiulianxi.jiujie.images;

/**
 * Created by Weimin on 2016/3/12.
 */
public class Image {

    private long id;
    private String path;
    private int size;
    private String displayName;
    private int width;
    private int height;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Image [id=" + id + ", path=" + path + ", size=" + size
                + ", displayName=" + displayName + ", width=" + width
                + ", height=" + height + "]";
    }


}
