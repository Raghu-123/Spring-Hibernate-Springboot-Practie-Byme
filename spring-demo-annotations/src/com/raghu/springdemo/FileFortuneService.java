package com.raghu.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	private String fileName ="/Users/apple/eclipse-workspace/spring-demo-annotations/src/fortune-data.txt";
	private List<String> theFortunes;
	
	//create a random number generator
	private Random myRandom = new Random();
	
 public FileFortuneService() {
		File file = new File(fileName);
		System.out.println("Reading the fortunes from the Files: "+file);
		System.out.println("File exists:"+file.exists());
		
		//initialyzing the list
		
		theFortunes = new ArrayList<String>();
		
		//read fortunes from the files
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			String tempLine;
			
			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 

	@Override
	public String getFortune() {
		// pick a random string from the array
		System.out.println(theFortunes.size());
				int index = myRandom.nextInt(theFortunes.size());

				String tempFortune = theFortunes.get(index);

				return tempFortune;
	}

}
