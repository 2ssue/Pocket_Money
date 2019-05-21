package com.Pocket_Money;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

public class Categories {
	private List<String> categories;
	private static Categories categoriesObject = new Categories();
	
	static Categories getInstance() {
		return categoriesObject;
	}
	
	private Categories(){
		categories = new ArrayList<>();
		File categoryFile = new File(".\\Category.txt");
		try {
			FileReader fileReader = new FileReader(categoryFile);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			String sLine = "";
			while((sLine = bufferReader.readLine()) != null) {
				categories.add(sLine);
			}
		}catch(FileNotFoundException e) {
			try {
				FileWriter fileWriter = new FileWriter(categoryFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void addCategory(String sCategoryName) {
		categories.add(sCategoryName);
	}
	public void deleteCategory(int nCategoryNumber) {
		try {
			categories.remove(nCategoryNumber - 1);
		}catch (IndexOutOfBoundsException | InputMismatchException e) {
			System.out.println("없는 카테고리 입니다. 범위 내의 숫자를 입력해주세요.");
		}
	}
	public Iterator<String> iteratorCategories(){
		return categories.iterator();
	}
	public String getCategory(int nCategoryNumber) {
		return categories.get(nCategoryNumber);
	}
	public void saveCategory() {
		try {
			File categoryFile = new File(".\\Category.txt");
			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(categoryFile));
		
			if(categoryFile.isFile() && categoryFile.canWrite()) {
				Iterator<String> categoryList = categories.iterator();
				while(categoryList.hasNext()) {
					bufferWriter.write(categoryList.next());
					bufferWriter.newLine();
				}
				bufferWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}