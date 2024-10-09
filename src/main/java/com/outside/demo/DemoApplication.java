package com.outside.demo;

import java.util.HashMap;
import java.util.List;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		System.out.println("###################");
		System.out.println(args.length);
		System.out.printf("arguments: %s\n", List.of(args).toString());
		HashMap<String, Object> map = new HashMap<>();
		for (String arg : args) {
			System.out.println(arg);
			String[] splitted = arg.split("=");
			map.put(splitted[0], splitted[1]);
		}
		System.out.println(map.toString());
		System.out.println(map.getOrDefault("qwe", null));
		System.out.println(map.getOrDefault("qwe2", null));
		System.out.println("###################");
		SpringApplication.run(DemoApplication.class, args);
	}

}
