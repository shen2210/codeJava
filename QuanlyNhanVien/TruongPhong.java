package QuanlyNhanVien;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TruongPhong extends NhanVien{
	
	private double trachNhiem;
	
	public TruongPhong() {
		
	}

	public TruongPhong(String manv, String hoten, double luong, double trachNhiem) {
		super(manv, hoten, luong);
		this.trachNhiem = trachNhiem;
	}

	public double getTrachNhiem() {
		return trachNhiem;
	}

	public boolean setTrachNhiem(double trachNhiem) {
		if(trachNhiem > 0) {
			this.trachNhiem = trachNhiem;
			return true;
		}
		return false;
		
	}
	
	@Override
	public void nhapThongTin() {
		try {
			
			super.nhapThongTin();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Nhap luong trach nhiem: ");
			while(!setTrachNhiem(Double.parseDouble(sc.nextLine())));
			
		} catch (InputMismatchException ei) {
            System.err.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	}

	@Override
	public String toString() {
		return super.toString() + " ,trachNhiem=" + trachNhiem;
	}
	
	@Override
	public double getThuNhap() {
		return super.getThuNhap() + getTrachNhiem();
	}
}
