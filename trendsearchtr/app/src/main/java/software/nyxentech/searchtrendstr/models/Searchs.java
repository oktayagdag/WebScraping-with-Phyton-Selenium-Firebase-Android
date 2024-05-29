package software.nyxentech.searchtrendstr.models;
public class Searchs {
    private String title,new_details,image_url,new_source,search_count,share_url;
    private int number;



    public Searchs(){}

    public Searchs(String title, String new_details, String image_url, String new_source, String search_count, String share_url, int number) {
        this.title = title;
        this.new_details = new_details;
        this.image_url = image_url;
        this.new_source = new_source;
        this.search_count = search_count;
        this.share_url = share_url;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNew_details() {
        return new_details;
    }

    public void setNew_details(String new_details) {
        this.new_details = new_details;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getNew_source() {
        return new_source;
    }

    public void setNew_source(String new_source) {
        this.new_source = new_source;
    }

    public String getSearch_count() {
        return search_count;
    }

    public void setSearch_count(String search_count) {
        this.search_count = search_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}