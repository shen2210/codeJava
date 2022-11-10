package QuanlyNhanVien;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NhanVien {
	
	private String manv, hoten;
	private double luong;
	
	public NhanVien() {
		
	}

	public NhanVien(String manv, String hoten, double luong) {
		this.manv = manv;
		this.hoten = hoten;
		this.luong = luong;
	}

	public String getManv() {
		return manv;
	}

	public boolean setManv(String manv) {
		if(manv != null && !manv.contains(" ")) {
			this.manv = manv;
			return true;
		}
		return false;
	}

	public String getHoten() {
		return hoten;
	}

	public boolean setHoten(String hoten) {
		if(hoten != null && !hoten.equals("")) {
			this.hoten = hoten;
			return true;
		}
		return false;
	}

	public double getLuong() {
		return luong;
	}

	public boolean setLuong(double luong) {
		if(luong > 0) {
			this.luong = luong;
			return true;
		}
		return false;
	}
	
	public void nhapThongTin() {
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap ma nhan vien : ");
			while(!setManv(sc.nextLine()));
			
			System.out.println("Nhap ho ten : ");
			while(!setHoten(sc.nextLine()));
			
			System.out.println("Nhap luong : ");
			while(!setLuong(Double.parseDouble(sc.nextLine())));
			
		} catch (InputMismatchException ei) {
            System.err.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	}

	public double getThuNhap() {
		return getLuong() - getLuong() * getThueTN();
	}
	
	public double getThueTN() {
		double thue = 0;
		if(getLuong() > 15000000) thue = 0.12;
		else if(getLuong() >= 9000000) thue = 0.1;
		return thue;		
	}
	
	@Override
	public String toString() {
		return "manv=" + manv + ", hoten=" + hoten + ", luong=" + luong;
	}
	
	public void xuatThongTin() {
		System.out.println(this);
	}
	
}
