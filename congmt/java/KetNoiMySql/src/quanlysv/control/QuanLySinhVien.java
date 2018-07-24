package quanlysv.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

import quanlysv.entity.SinhVien;
import quanlysv.model.SinhVienDao;
import quanlysv.view.QuanLySinhVienView;

public class QuanLySinhVien {
	SinhVienDao sinhvienDao;
	QuanLySinhVienView quanlySvView;

	public QuanLySinhVien() {
		sinhvienDao = new SinhVienDao();
		quanlySvView = new QuanLySinhVienView();
	}

	public void displayAllSv() {
		ArrayList<SinhVien> listSv = sinhvienDao.getAllSinhVien();
		quanlySvView.displaySinhVien(listSv);
	}
	public void displaySinhVienTheoTen() {
			
		ArrayList<SinhVien> listSv1 = sinhvienDao.getAllSinhVienTheoTen(quanlySvView.hienThiTheoTen());
		quanlySvView.displaySinhVienTheoTen(listSv1);
	}

	public void addSinhVien() {

		SinhVien sinhvien = quanlySvView.addSinhVien();

		if (sinhvienDao.addNewSinhVien(sinhvien)) {
			System.out.println("Thêm sinh viên thành công!!");
		} else {
			System.out.println("Thêm sinh viên thất bại!!");
		}

	}

	public void addDiemSinhVien() {
		SinhVien sinhvien= quanlySvView.nhapDiemSinhVien();
		if (sinhvienDao.updateDiemSinhVien(sinhvien)) {
			System.out.println("Cap nhap cap thành công!!");
		}else if(sinhvienDao.addDiemSinhVien(sinhvien)) {
			System.out.println("Them diem thành công!!");
		}
		else {
			System.out.println("Thêm diem thất bại!!");
		}
	}
	public void updateSinhVien() {
		SinhVien sinhvien= quanlySvView.updateSinhVien();
		if (sinhvienDao.updateSinhVien(sinhvien)){
			System.out.println("Cap nhap thành công!!");
		} else {
			System.out.println("Cap nhap thất bại!!");
		}
	}
	public void deletelSinhVien() {
		SinhVien sinhvien= quanlySvView.deletelSinhVien();
		if (sinhvienDao.deletelSinhVien(sinhvien)){
			System.out.println("Xoa thành công!!");
		} else {
			System.out.println("Xoa thất bại!!");
		}
	}
	public void updateDiemSinhVien() {
		SinhVien sinhvien= quanlySvView.updateDiemSinhVien();
		if (sinhvienDao.updateDiemSinhVien(sinhvien)){
			System.out.println("Cap nhap diem thành công!!");
		} else {
			System.out.println("Cap nhap diem thất bại!!");
		}
	}
	public void deletelDiemSinhVien() {
		SinhVien sinhvien= quanlySvView.deletelDiemSinhVien();
		if (sinhvienDao.deletelDiemSinhVien(sinhvien)){
			System.out.println("Xoa diem thành công!!");
		} else {
			System.out.println("Xoa diem thất bại!!");
		}
	}
	

	public void menu() {
		while (true) {

			String chosse = quanlySvView.menu();
			switch (chosse) {

			case "1":
				addSinhVien();
				break;
			case "2":
				addDiemSinhVien();
				break;

			case "3":
				updateSinhVien();
				break;
			case "4":
				deletelSinhVien();
				break;
			case "5":
				updateDiemSinhVien();
				break;
			case "6":
				deletelDiemSinhVien();
				break;

			case "7":
				displayAllSv();
				break;

			case "8":
				displaySinhVienTheoTen();
				break;

			case "0":
				// sc.close();
				System.out.println("Kết thúc chương trình!!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Ch�?n sai chức năng. M�?i ch�?n lại!!");
				break;
			}
		}
	}

	public static void main(String[] args) {
		QuanLySinhVien quanlysinhvien = new QuanLySinhVien();
		quanlysinhvien.menu();
	}

}
