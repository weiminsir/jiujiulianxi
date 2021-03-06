package weiminsir.jiujiulianxi.youlu.entity;

/**
 * Created by Weimin on 2016/3/14.
 */
public class Contact {
    private int id;
    private String name;
    private int photoId;
    private String phone;
    private String address;
    private String email;
    public Contact(){}
    public Contact(
            int id,
            String name,
            int photoId,
            String phone,
            String address,
            String email
    ){
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.photoId = photoId;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + ", photoId=" + photoId
                + ", phone=" + phone + ", address=" + address + ", email="
                + email + "]";
    }
}
