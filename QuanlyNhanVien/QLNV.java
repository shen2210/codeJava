package QuanlyNhanVien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class QLNV {
	static List<NhanVien> nhanVienList = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int chon = -1;
		String manv;
		
		do {
			try {
				showMenu();
				chon = Integer.parseInt(sc.nextLine());
				
				switch(chon) {
				case 1: 
					nhap();
					break;
				case 2:
					System.out.println("\t\tDANH SACH NHAN VIEN");
					xuatDS();
					break;
				case 3:
					timNhanVienTheoMa();
					break;
				case 4:
					xoaNhanVien();
					break;
				case 5:
					capNhatThongTinNhanVien();
					break;
				case 6:
					timNhanVienTheoKhoangLuong();
					break;
				case 7:
					sapXepNhanVienTheoHoTen(nhanVienList);
					xuatDS();
					break;
				case 8:
					int choose;
					do {
						System.out.println("\n1. Sap xep theo chieu TANG dan");
						System.out.println("2. Sap xep theo chieu GIAM dan");
						System.out.println("Chon chuc nang : ");
						choose = Integer.parseInt(sc.nextLine());
						
						if(choose == 1) {
							sapXepTangDanTheoThunhap(nhanVienList);
							xuatDS();
						}
						else if(choose == 2) {
							sapXepGiamDanTheoThunhap(nhanVienList);
							xuatDS();
						}
						else System.out.println("Vui long nhap lai chuc nang!");
						
					} while(choose != 1 && choose != 2);
					break;
				case 9:
					xuat5NhanVienThuNhapCaoNhat();
					break;
				}

			} catch (InputMismatchException ei) {
                System.err.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
		} while (chon != 0);
	}
	
	static void showMenu() {
		System.out.println("================================");
		System.out.println("1. Nhap thong tin nhan vien.\n"
						+ "2. Xuat danh sach nhan vien.\n"
						+ "3. Tim va hien thi nhan vien theo ma nhap tu ban phim.\n"
						+ "4. Xoa nhan vien theo ma nhap tu ban phim.\n"
						+ "5. Cap nhat thong tin nhan vien theo ma nhap tu ban phim.\n"
						+ "6. Tim cac nhan vien theo khoang luong nhap tu ban phim.\n"
						+ "7. Sap xep nhan vien theo ho va ten.\n"
						+ "8. Sap xep nhan vien theo thu nhap.\n"
						+ "9. Xuat 5 nhan vien co thu nhap cao nhat.\n"
						+ "0. Thoat chuong trinh.\n");
		System.out.println("================================");
		System.out.println("Chon chuc nang : ");
	}
	
	// 1. Nhap thong tin nhan vien.
	static void nhap() {
		try {
			
			System.out.println("Nhap so luong nhan vien can them: ");
			int n = Integer.parseInt(sc.nextLine());

			for (int i = 0; i < n; i++) {
				NhanVien nv = taoNhanVien();
				nhanVienList.add(nv);
			}
			
		} catch (InputMismatchException ei) {
            System.err.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	}

	static NhanVien taoNhanVien() {
		NhanVien nv = null;
		try {
			
			System.out.println("\n1. Nhap thong tin Nhan vien hanh chinh.\n"
								+"2. Nhap thong tin Nhan vien tiep thi.\n"
								+"3. Nhap thong tin Truong phong.\n"
								+"Chon chuc nang : ");
			
			int choose = Integer.parseInt(sc.nextLine());
			
			switch (choose) {
			case 1:
				nv = new NhanVien();
				break;
			case 2:
				nv = new TiepThi();
				break;
			case 3:
				nv = new TruongPhong();
				break;
			default:
				System.err.println("Nhap sai chuc nang!");
				break;
			}
			
			nv.nhapThongTin();

		} catch (InputMismatchException ei) {
            System.err.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return nv;
	}
	
	//2. Xuat danh sach nhan vien.
	static void xuatDS() {
		for(NhanVien nv : nhanVienList) {
			nv.xuatThongTin();
		}
	}
	
	//3. Tim va hien thi nhan vien theo ma nhap tu ban phim.
	static void timNhanVienTheoMa() {
		boolean isFind = false;
		System.out.println("Nhap ma nhan vien can tim : ");
		String manv = sc.nextLine();
		
		for(NhanVien nv : nhanVienList) {
			if(nv.getManv().equalsIgnoreCase(manv)) {
				nv.xuatThongTin();
				isFind = true;
				break;
			}	
		}
		
		if (!isFind) 
			System.out.println("Khong tim thay Nhan vien co manv la : " + manv);
	}
	
	//4. Xoa nhan vien theo ma nhap tu ban phim.
	static void xoaNhanVien() {
		boolean isFind = false;
		System.out.println("Nhap ma nhan vien can xoa : ");
		String manv = sc.nextLine();
		
		for(NhanVien nhanVien : nhanVienList) {
			if(nhanVien.getManv().equalsIgnoreCase(manv)) {
				nhanVienList.remove(nhanVien);
				System.out.println("Xoa Nhan vien thanh cong !");
				isFind = true;
				break;
			}
		}
		
		
		if(isFind == false) {
			System.out.println("Ma Nhan vien khong ton tai !");
		}
	}
	
	//5. Cap nhat thong tin nhan vien theo ma nhap tu ban phim.
	static void capNhatThongTinNhanVien() {
		NhanVien nhanVien = null;
		
		System.out.println("Nhap ma nhan vien can cap nhat : ");
		String manv = sc.nextLine();
		
		for(NhanVien nv : nhanVienList) {
			if(nv.getManv().equalsIgnoreCase(manv)) {
				nhanVien = nv;
				break;
			}	
		}
		
		if(nhanVien != null) {
			nhanVien.nhapThongTin();
			System.out.println("Cap nhat thanh cong !");
		} else System.out.println("Khong tim thay Nhan vien co manv la : " + manv);
	}
	
	//6. Tim cac nhan vien theo khoang luong nhap tu ban phim.
	static void timNhanVienTheoKhoangLuong() {
		double start, end;
		boolean isFind = false;
		
		try {
			System.out.println("Nhap khoang luong can tim : ");
			start = Double.parseDouble(sc.nextLine());
			end = Double.parseDouble(sc.nextLine());
			
			for(NhanVien nv : nhanVienList) {
				if(nv.getLuong() > start && nv.getLuong() < end) {
					nv.xuatThongTin();
					isFind = true;
				}	
			}
			
			if (!isFind) 
				System.out.println("Khong tim thay Nhan vien thoa dieu kien " + start + "<luong<" + end);

		} catch (InputMismatchException ei) {
            System.err.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	//7. Sap xep nhan vien theo ho va ten.
	static void sapXepNhanVienTheoHoTen(List<NhanVien> nhanVienList) {
		Collections.sort(nhanVienList, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				return o1.getHoten().compareToIgnoreCase(o2.getHoten());
			}
			
		});
	}
	
	//8. Sap xep nhan vien theo thu nhap.
	// Sap xep theo chieu giam dan
	static void sapXepGiamDanTheoThunhap(List<NhanVien> nhanVienList) {
		Collections.sort(nhanVienList, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				return o1.getThuNhap() > o2.getThuNhap() ? -1 : 1;
			}
			
		});
	}
	
	// Sap xep theo chieu tang dan
		static void sapXepTangDanTheoThunhap(List<NhanVien> nhanVienList) {
			Collections.sort(nhanVienList, new Comparator<NhanVien>() {

				@Override
				public int compare(NhanVien o1, NhanVien o2) {
					return o1.getThuNhap() > o2.getThuNhap() ? 1 : -1;
				}
				
			});
		}
	
	// 9. Xuat 5 nhan vien co thu nhap cao nhat.
		static void xuat5NhanVienThuNhapCaoNhat() {
			int size = nhanVienList.size();
			sapXepGiamDanTheoThunhap(nhanVienList);
			
			if(size > 5) {
				for(int i = 0; i < 5; i++) {
					nhanVienList.get(i).xuatThongTin();
				}
			} else {
				for(int i = 0; i < size; i++) {
					nhanVienList.get(i).xuatThongTin();
				}
			}
			
		}
		
}
