package quanlysinhvien.moi.controller;

import java.util.ArrayList;
import java.util.Scanner;

import quanlysv.moi.model.SinhVienDAO;
import quanlysv.moi.model.entity.Diem;
import quanlysv.moi.model.entity.SinhVien;
import quanlysv.moi.wiew.QuanLySVWiew;

public class QuanLySV {
	SinhVienDAO sinhVienDao;
	QuanLySVWiew wiew;

	public QuanLySV() {
		sinhVienDao = new SinhVienDAO();
		wiew = new QuanLySVWiew();
	}

	public void addSinhVien() {
		SinhVien sinhVien = new SinhVien();
		sinhVien = wiew.nhapInfoSinhVien();

		if (sinhVienDao.addSinhVien(sinhVien)) {
			System.out.println("Them thanh cong");
		} else {
			System.out.println("Them khong thanh cong");
		}
	}
	
	public void updateSinhVien() {
		SinhVien sinhVien = new SinhVien();
		sinhVien = wiew.themSinhVien();

		if (sinhVienDao.updateSinhVien(sinhVien)) {
			System.out.println("Sua thanh cong");
		} else {
			System.out.println("Sua khong thanh cong");
		}
	}
	
	public void deleteSinhVien() {
		SinhVien sinhVien = new SinhVien();
		sinhVien.setMaSinhVien(wiew.xoaSinhVien());
		
		if (sinhVienDao.deleteSinhVien(sinhVien)) {
			System.out.println("xoa thanh cong");
		} else {
			System.out.println("xoa khong thanh cong");
		}
	}
	
	public void deleteDiem() {
		SinhVien sinhVien = new SinhVien();
		sinhVien = wiew.xoaDiem();

		if (sinhVienDao.deleteDiem(sinhVien)) {
			System.out.println("xoa thanh cong");
		} else {
			System.out.println("xoa khong thanh cong");
		}
	}
	
	public void addDiem() {
		SinhVien sinhVien = new SinhVien();
		sinhVien = wiew.nhapDiemSinhVien();
		
		if (sinhVienDao.addDiem(sinhVien)) {
			System.out.println("Them thanh cong");
		} else {
			System.out.println("Them khong thanh cong");
		}
	}
	
	public void displayAllSV() {
		ArrayList<SinhVien> listSv = sinhVienDao.getAllSinhVien();
		for (SinhVien sinhVien : listSv) {
			System.out.println(sinhVien.getMaSinhVien() + " " + sinhVien.getTenSinhVien() + " "
					+ sinhVien.getDiem().getMonHoc() + " " + sinhVien.getDiem().getDiem());
		}
	}
	
	public void showSV() {
		String ten = wiew.showSinhVien();
		ArrayList<SinhVien> listSv = sinhVienDao.getSinhVienTheoTen(ten);
		
		for (SinhVien sinhVien : listSv) {
			System.out.println(sinhVien.getMaSinhVien() + " " + sinhVien.getTenSinhVien() + " "
					+ sinhVien.getDiem().getMonHoc() + " " + sinhVien.getDiem().getDiem());
		}
	
	}

	public void menu() {

		while (true) {
			String choose = wiew.menu();
			switch (choose) {
			case "1":
				addSinhVien();
				break;
			case "2":
				addDiem();
				break;
			case "3":
				updateSinhVien();
				break;
			case "4":
				deleteSinhVien();
				break;
			case "5":
				deleteDiem();
				break;
			case "6":
				displayAllSV();
				break;
			case "7":
				showSV();
				break;
			default:
				System.out.println("chon sai");
				break;

			}
		}
	}

	public static void main(String[] args) {
		QuanLySV qlsv = new QuanLySV();
		qlsv.menu();
	}
}
