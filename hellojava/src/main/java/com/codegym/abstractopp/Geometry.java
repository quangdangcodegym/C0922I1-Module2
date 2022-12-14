package com.codegym.abstractopp;

public abstract class Geometry {
    protected Point toaDo;

    public Geometry(Point toaDo) {
        this.toaDo = toaDo;
    }

    public Geometry() {

    }
    public Point getToaDo() {
        return toaDo;
    }

    public void setToaDo(Point toaDo) {
        this.toaDo = toaDo;
    }

    public abstract double Area();

    /**
     - Trong lớp trừu trương có phương thức trừu tượng, phương thức trừu là phương
     thức chỉ khai báo mà không có phần thân
     - Có phương thức và thuộc tính
     - Vẫn có hàm khởi tạo nhưng không ta được đối tượng. Không sử dụng được từ khóa new
     - Phương thức trừu tượng thì access modifier không thể là final
     - 1 lớp có phương thức truu tuong thi lop do phai la lop truu tuong
     */
}
