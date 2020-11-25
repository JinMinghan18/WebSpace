package cn.edu.zjut.po;

//import com.mysql.cj.jdbc.Blob;
import java.sql.Blob;
public class ItemDetail extends ItemBasic{
    private Blob image;

    public ItemDetail() {    }

    public ItemDetail(String isbn, String title, String description, Float cost, Blob image) {
        super(isbn, title, description, cost);
        this.image = image;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
