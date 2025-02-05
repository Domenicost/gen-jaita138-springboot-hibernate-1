package com.github.domenicost.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.domenicost.demo.cli.CliManager;
import com.github.domenicost.demo.db.service.RoleService;
import com.github.domenicost.demo.db.service.SubRedditService;
import com.github.domenicost.demo.db.service.UtenteService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private SubRedditService subRedditService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new CliManager(utenteService, roleService, subRedditService);
	}
}