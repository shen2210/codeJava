package QuanlyNhanVien;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TiepThi extends NhanVien{

	private double doanhSo, hueHong;

	public TiepThi() {
		
	}

	public TiepThi(String manv, String hoten, double luong, double doanhSo, double hueHong) {
		super(manv, hoten, luong);
		this.doanhSo = doanhSo;
		this.hueHong = hueHong;
	}

	public double getDoanhSo() {
		return doanhSo;
	}

	public boolean setDoanhSo(double doanhSo) {
		if(doanhSo > 0) {
			this.doanhSo = doanhSo;
			return true;
		}
		return false;
	}

	public double getHueHong() {
		return hueHong;
	}

	public boolean setHueHong(double hueHong) {
		if(hueHong > 0) {
			this.hueHong = hueHong;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + ", doanhSo=" + doanhSo + ", hueHong=" + hueHong;
	}
	
	@Override
	public void nhapThongTin() {
		try {
			
			super.nhapThongTin();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Nhap doanh so ban hang : ");
			while(!setDoanhSo(Double.parseDouble(sc.nextLine())));
						
			System.out.println("Nhap ti le hue hong : ");
			while(!setHueHong(Double.parseDouble(sc.nextLine())));
			
		} catch (InputMismatchException ei) {
            System.err.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	}
	
	@Override
	public double getThuNhap() { //thu nhap = luong - thue + huehong*doanhthu
		return super.getThuNhap() + getDoanhSo()*getHueHong();
	}
	
}
