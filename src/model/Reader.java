package model;

public class Reader {
    private int id;
    private String idCard;
    private String name;
    private String address;
    private String email;
    private String tel;
    private String note;

    public Reader() {
    }

    public Reader(int id, String idCard, String name, String address, String email, String tel, String note) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
