package org.bakara.web;

import java.util.ArrayList;
import java.util.List;

import org.bakara.dto.TeamPlayerDTO;
import org.bakara.service.TeamPlayerService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/admin/*")
@Log
public class TeamPlayerController {

	private WebDriver driver;

	private List<String> playerPage = new ArrayList<>();

	@Autowired
	private TeamPlayerService service;

	@GetMapping("/teamplayers")
	public void teamPlayers() throws Exception {
		
		service.crawlPlayersInfo();
	}

}
